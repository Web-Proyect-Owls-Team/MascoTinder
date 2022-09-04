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

		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		request.setAttribute("mascota", mascota);

		// request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request,
		// response);
		listarProspectos(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request,
		// response);
		listarProspectos(request, response);

	}

	private void listarProspectos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Get Parameters
		int miMascotaID = Integer.parseInt(request.getParameter("idMascota"));

		// Call Models
		Mascota miMascota = DAOFactory.getFactory().getMascotaDAO().getById(miMascotaID);
		ArrayList<Mascota> prospectos = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO()
				.getProspectos(miMascota);

		System.out.println("En total coinciden " + prospectos.size());
		if (prospectos.size() > 0) {
			request.setAttribute("prospectos", prospectos);
		}
		

		request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);

	}


}
