package com.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Foto;
import com.modelo.entidades.Mascota;

@WebServlet("/ListarCoincidenciasController")
public class ListarCoincidenciasController  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarCoincidenciasController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		listarMascotasCoincidencias(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		listarMascotasCoincidencias(request, response);
	}
	
	private void listarMascotasCoincidencias(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		int idMiMascota;
		if(request.getAttribute("idMascota") != null) {
			// GET
			idMiMascota = (int)request.getAttribute("idMascota");
		}else {
			//POST
			idMiMascota = Integer.parseInt(request.getParameter("idMascota"));
		}
		
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		
		ArrayList<Coincidencia> coincidenciasPretendiente = new ArrayList<Coincidencia>();
		List<?> soyPretendiente =  miMascota.getCoincidenciasE();
		for (int i = 0; i < soyPretendiente.size(); i++ ) {
			Coincidencia c = (Coincidencia) soyPretendiente.get(i);
			if (c.getLike()) {
				coincidenciasPretendiente.add(c);
			}
		}
		
		ArrayList<Coincidencia> coincidenciasPretendido = new ArrayList<Coincidencia>();
		List<?> soyPretendido =  miMascota.getCoincidenciasR();
		for (int i = 0; i < soyPretendido.size(); i++ ) {
			Coincidencia c = (Coincidencia) soyPretendido.get(i);
			if (c.getLike()) {
				coincidenciasPretendido.add(c);
			}
			
		}
		
		ArrayList<Mascota> matchs = new ArrayList<Mascota>();
		for (Coincidencia c: coincidenciasPretendiente) {
				matchs.add(c.getPretendido());
		}
		
		for (Coincidencia c: coincidenciasPretendido) {
				matchs.add(c.getPretendiente());
		}
		
		//ArrayList<Mascota> coincidenciaMascotas = (ArrayList<Mascota>) DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencias(miMascota, true);
		//System.out.println("Coincidencias : " + coincidenciaMascotas.size());
		//ArrayList<Foto> fotos = (ArrayList<Foto>) DAOFactory.getFactory().getFotoDAO().getFotoByIdMascota(1);
		
		request.setAttribute("match", matchs);
		//request.setAttribute("fotos", fotos);
		request.getRequestDispatcher("jsp/listarCoincidencias.jsp").forward(request, response);
	}

	
}
