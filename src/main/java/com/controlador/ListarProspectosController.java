package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Mascota;

@WebServlet("/ListarProspectosController")
public class ListarProspectosController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarProspectosController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		// Get Parameters
		int idMascota;
		if (request.getAttribute("idMascota") != null) {
			idMascota =  (int) request.getAttribute("idMascota");
		} else {
			idMascota = Integer.parseInt(request.getParameter("idMascota"));
		}
		// Call Models
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		// Dispatch 
		//request.setAttribute("mascota", mascota);
		 * 
		 */
		listarProspectos(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listarProspectos(request, response);

	}

	private void listarProspectos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get Parameters
		int miMascotaID;
		if (request.getAttribute("idMascota") != null) {
			miMascotaID =  (int) request.getAttribute("idMascota");
		} else {
			miMascotaID = Integer.parseInt(request.getParameter("idMascota"));
		}

		// Call Models
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(miMascotaID);
		ArrayList<Mascota> prospectos = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO()
				.getProspectos(miMascota);

		if (prospectos.size() > 0) {
			int index = (int) (Math.random() * prospectos.size());
			request.setAttribute("prospecto", prospectos.get(index));
			request.setAttribute("miMascota", miMascota);
		}
		// Dispatch
		request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);

	}

}
