package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.entidades.Mensaje;

/**
 * Servlet implementation class EnviarMensajeController
 */
@WebServlet("/EnviarMensajeController")
public class EnviarMensajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMensajeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Enviar mensaje a un propietario
		// 1.- obtener parámetros
		String mensaje = request.getParameter("txtMensaje");
		// 2.- Llamar al modelo
		Mensaje m = new Mensaje();
		m.setMensaje(mensaje);
		// 3.- Redireccionar
		request.getRequestDispatcher("jsp/listarMensajes.jsp").forward(request, response);
		
	}

}
