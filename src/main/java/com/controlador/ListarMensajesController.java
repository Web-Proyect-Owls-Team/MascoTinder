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
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Mensaje;
import com.modelo.entidades.Propietario;

/**
 * Servlet implementation class ListarMensajesController
 */
@WebServlet("/ListarMensajesController")
public class ListarMensajesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarMensajesController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Listar mensajes por id de usuario
		// 1.- obtener parámetros
		//HttpSession misession = request.getSession(true);
		int idMascotaMatch = Integer.parseInt(request.getParameter("idMatch"));
		int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMiMascota);
		request.setAttribute("mascota", mascota);
		Mascota match = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascotaMatch);
		request.setAttribute("match", match);
		HttpSession misession = request.getSession(true);
		request.setAttribute("myId", misession.getAttribute("id"));
		
		
		Coincidencia coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMascotaMatch, idMiMascota);

		if (coincidencia == null) {
			coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMiMascota, idMascotaMatch);
		}

		// 2.- Llamar al modelo
		ArrayList <Mensaje> mensajes = DAOFactory.getFactory().getMensajeDAO().getMensajesByCoincidencia(coincidencia);
		
		
		// 3.- Forward to view
		request.setAttribute("mensajes", mensajes);
		request.setAttribute("coincidencia", coincidencia);
		request.setAttribute("idMascotaMatch", idMascotaMatch);
		request.setAttribute("idMiMascota", idMiMascota);
		
		request.getRequestDispatcher("jsp/listarMensajes.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idMascotaMatch = (int) request.getAttribute("idMatch");
		int idMiMascota = (int) request.getAttribute("idMiMascota");
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMiMascota);
		request.setAttribute("mascota", mascota);
		Mascota match = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascotaMatch);
		request.setAttribute("match", match);
		HttpSession misession = request.getSession(true);
		request.setAttribute("myId", misession.getAttribute("id"));
		
		
		Coincidencia coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMascotaMatch, idMiMascota);

		if (coincidencia == null) {
			coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMiMascota, idMascotaMatch);
		}

		// 2.- Llamar al modelo
		ArrayList <Mensaje> mensajes = DAOFactory.getFactory().getMensajeDAO().getMensajesByCoincidencia(coincidencia);
		
		
		// 3.- Forward to view
		request.setAttribute("mensajes", mensajes);
		request.setAttribute("coincidencia", coincidencia);
		request.setAttribute("idMascotaMatch", idMascotaMatch);
		request.setAttribute("idMiMascota", idMiMascota);
		
		request.getRequestDispatcher("jsp/listarMensajes.jsp").forward(request, response);
	}

}
