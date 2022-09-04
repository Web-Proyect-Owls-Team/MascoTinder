package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
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
			idMiMascota = (int)request.getAttribute("idMascota");
			
		}else {
			idMiMascota = Integer.parseInt(request.getParameter("idMascota"));
			
		}
		
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(idMiMascota);
		
		ArrayList<Mascota> coincidenciaMascotas = (ArrayList<Mascota>) DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencias(miMascota, true);
		ArrayList<Foto> fotos = (ArrayList<Foto>) DAOFactory.getFactory().getFotoDAO().getFotoByIdMascota(1);
		
		request.setAttribute("mascotas", coincidenciaMascotas);
		request.setAttribute("fotos", fotos);
		request.getRequestDispatcher("jsp/listarCoincidencias.jsp").forward(request, response);
	}

	
}
