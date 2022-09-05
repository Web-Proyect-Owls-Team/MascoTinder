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
import com.modelo.entidades.Mensaje;

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
		
		System.out.println("mio: " + idMiMascota);
		System.out.println("ob: "+ idMascotaMatch);
		Coincidencia coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMascotaMatch, idMiMascota);
		System.out.println(coincidencia);
		if (coincidencia == null) {
			coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getCoincidencia(idMiMascota, idMascotaMatch);
		}
		System.out.println(coincidencia);
		// 2.- Llamar al modelo
		ArrayList <Mensaje> mensajes = DAOFactory.getFactory().getMensajeDAO().getMensajesByCoincidencia(coincidencia);
		
		System.out.println("listMen" + mensajes);
		// 3.- Forward to view
		
		request.setAttribute("mensajes", mensajes);
		
		
		request.getRequestDispatcher("jsp/listarMensajes.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
