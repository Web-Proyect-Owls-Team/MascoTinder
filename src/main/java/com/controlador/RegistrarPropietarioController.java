package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Propietario;

@WebServlet("/RegistrarPropietarioController")
public class RegistrarPropietarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrarPropietarioController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- obtener parámetros
		// 2.- Llamar al modelo
		// 3.- Llamar a la vista
		request.getRequestDispatcher("jsp/registrarPropietario.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.- obtener parámetros
		
		String nombre = request.getParameter("txtNombre");
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");

		// 2.- Llamar al modelo
		Propietario p = new Propietario();
		
		p.setNombre(nombre);
		p.setUsuario(usuario);
		p.setClave(clave);

		DAOFactory.getFactory().getPropietarioDAO().create(p);

		// 3.- Llamar a la vista
		request.getRequestDispatcher("LoginController").forward(request, response);

	}

}
