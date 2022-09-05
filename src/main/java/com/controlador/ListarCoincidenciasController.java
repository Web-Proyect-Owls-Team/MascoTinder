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
		System.out.println("id Mascota : " + miMascota.getId());
		ArrayList<Coincidencia> coincidenciasPretendiente = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidenciasAsPretendiente(miMascota);
		System.out.println("c1: " + coincidenciasPretendiente);
		ArrayList<Coincidencia> coincidenciasPretendido = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidenciasAsPretendido(miMascota);
		System.out.println("c2: " + coincidenciasPretendido);
		
		ArrayList<Mascota> matchs = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO().getMascotasByCoincidencias(coincidenciasPretendiente, coincidenciasPretendido);
		

		request.setAttribute("match", matchs);
	
		request.getRequestDispatcher("jsp/listarCoincidencias.jsp").forward(request, response);
	}

	
}
