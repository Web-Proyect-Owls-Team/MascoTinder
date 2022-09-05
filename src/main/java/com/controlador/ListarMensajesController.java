package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Listar mensajes por id de usuario
		// 1.- obtener parámetros
		int idUsuario = Integer.parseInt( request.getParameter("idUsuario"));
		// 2.- Llamar al modelo
		ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) DAOFactory.getFactory().getMensajeDAO().getMensajesByIdUsuario(idUsuario);

		// 3.- Forward to view
		request.setAttribute("mensajes", mensajes);
		request.getRequestDispatcher("listarMensajes.jsp").forward(request, response);
		

		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
