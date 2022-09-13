package com.controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			miMascotaID = (int) request.getAttribute("idMascota");
		} else {
			miMascotaID = Integer.parseInt(request.getParameter("idMascota"));
		}

		// Call Models
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(miMascotaID);
		if (miMascota.getPreferencia() != null) {
			ArrayList<Mascota> prospectos = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO()
					.getProspectos(miMascota);

				request.setAttribute("prospectos", prospectos);
				request.setAttribute("miMascota", miMascota);
		}

		// Dispatch
		request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);

	}

}
