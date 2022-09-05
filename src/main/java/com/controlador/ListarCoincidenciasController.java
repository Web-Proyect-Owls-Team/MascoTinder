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
		// Parameters
		int idMiMascota;
		if(request.getAttribute("idMascota") != null) {
			// GET
			idMiMascota = (int)request.getAttribute("idMascota");
		}else {
			//POST
			idMiMascota = Integer.parseInt(request.getParameter("idMascota"));
		}
		
		// Models
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);

		ArrayList<Coincidencia> coincidenciasPretendiente = getCoincidenciasAsPretendiente(miMascota);
		ArrayList<Coincidencia> coincidenciasPretendido = getCoincidenciasAsPretendido(miMascota);
	
		ArrayList<Mascota> matchs = (ArrayList<Mascota>) getMascotasByCoincidencias(coincidenciasPretendiente, coincidenciasPretendido);
		

		request.setAttribute("match", matchs);
		request.setAttribute("miMascota", miMascota);
		
		request.getRequestDispatcher("jsp/listarCoincidencias.jsp").forward(request, response);
	}
	

	private ArrayList<Coincidencia> getCoincidenciasAsPretendiente(Mascota m) {
		
		ArrayList<Coincidencia> coincidenciasPretendiente = new ArrayList<Coincidencia>();
		List<?> soyPretendiente =  m.getCoincidenciasE();
		
		for (int i = 0; i < soyPretendiente.size(); i++ ) {
			Coincidencia c = (Coincidencia) soyPretendiente.get(i);
			if (c.getLike()) {
				coincidenciasPretendiente.add(c);
			}
		}
		return  coincidenciasPretendiente;
	}


	private ArrayList<Coincidencia> getCoincidenciasAsPretendido(Mascota m) {
		ArrayList<Coincidencia> coincidenciasPretendido = new ArrayList<Coincidencia>();
		List<?> soyPretendido =  m.getCoincidenciasR();
		for (int i = 0; i < soyPretendido.size(); i++ ) {
			Coincidencia c = (Coincidencia) soyPretendido.get(i);
			if (c.getLike()) {
				coincidenciasPretendido.add(c);
			}
			
		}
		return coincidenciasPretendido;
	}

	private List<Mascota> getMascotasByCoincidencias(ArrayList<Coincidencia> coincidenciasPretendiente,
			ArrayList<Coincidencia> coincidenciasPretendido) {
		ArrayList<Mascota> matchs = new ArrayList<Mascota>();
		for (Coincidencia c: coincidenciasPretendiente) {
				matchs.add(c.getPretendido());
		}
		
		for (Coincidencia c: coincidenciasPretendido) {
				matchs.add(c.getPretendiente());
		}
		
		return matchs;
	} 
}
