package com.controlador;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.entidades.*;

/**
 * Servlet implementation class RegistrarMascotaController
 */
@WebServlet("/RegistrarMascotaController")
public class RegistrarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarMascotaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/registrarMascota.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- obtener parámetros
		String nombre = request.getParameter("txtNombre");
		Fecha fechaNacimiento = new Fecha(request.getParameter("txtFechaNacimiento"));
		String sexo = request.getParameter("txtSexo");
		String especie = request.getParameter("txtEspecie");
		File foto = new File(request.getParameter("txtImagenes"));

		// 2.- Llamar al modelo
		Mascota m = new Mascota();
		m.setNombre(nombre);
		m.setFechaNac(fechaNacimiento);
		m.setSexo(sexo);
		m.setEspecie(especie);
		m.setFoto(foto);

		//Llamar a la vista
		request.getRequestDispatcher("jsp/listaMascotas.jsp").forward(request, response);
		
	}

}
