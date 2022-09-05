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
			coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idPretendiente, idPretendido);
			if (coincidencia == null) {
				crearCoincidencia(idPretendido, idPretendiente);
			}
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
		// Create
		Coincidencia coincidencia = new Coincidencia();
		coincidencia.setLike(false);
		DAOFactory.getFactory().getCoincidenciaDAO().create(coincidencia);
		// Update
		Mascota pretendido = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idPretendido);
		coincidencia.setPretendido(pretendido);
		Mascota pretendiente = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idPretendiente);
		coincidencia.setPretendiente(pretendiente);
		
		DAOFactory.getFactory().getCoincidenciaDAO().update(coincidencia);
	}

}
