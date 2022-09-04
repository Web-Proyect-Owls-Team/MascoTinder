package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

/**
 * Servlet implementation class MatchController
 */
@WebServlet("/DarLikeController")
public class DarLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DarLikeController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameters
		int idPretendiente = Integer.parseInt(request.getParameter("idPretendiente"));
		int idPretendido = Integer.parseInt( request.getParameter("idPretendido"));
		
		// Models
		Coincidencia coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idPretendido, idPretendiente);
		if (coincidencia != null) {
			coincidencia.setLike(true);
			DAOFactory.getFactory().getCoincidenciaDAO().update(coincidencia);
			
		} else {
			crearCoincidencia(idPretendido, idPretendiente);
			
		}
		// Dispatch request
		request.setAttribute("idMascota", idPretendiente);
		request.getRequestDispatcher("ListarProspectosController").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("ListarProspectosController").forward(request, response);
	}
	
	
	private void crearCoincidencia(int idPretendido, int idPretendiente) {
		Coincidencia c = new Coincidencia();
		c.setIdPretendido(idPretendido);
		c.setLike(false);
		
		DAOFactory.getFactory().getCoincidenciaDAO().create(c);
		
		Mascota m = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idPretendiente);
		c.setPretendiente(m);
		
		DAOFactory.getFactory().getCoincidenciaDAO().update(c);
	}

}
