package com.controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.dao.DAOFactory;
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
		procesar(request, response);
		
	}
	
	
	public void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- obtener parámetros
		String nombre = request.getParameter("txtNombre");
		int fechaNacimiento = Integer.parseInt(request.getParameter("txtFechaNacimiento"));
		String sexo = request.getParameter("txtSexo");
		String especie = request.getParameter("txtEspecie");
		Foto foto1 = new Foto(request.getParameter("txtFoto1"));
		Foto foto2 = new Foto(request.getParameter("txtFoto2"));
		Foto foto3 = new Foto(request.getParameter("txtFoto3"));
		// 2.- Llamar al modelo
		Mascota m = new Mascota();

		m.setNombre(nombre);
		m.setEdad(fechaNacimiento);
		m.setSexo(sexo);
		m.setEspecie(especie);

		DAOFactory.getFactory().getMascotaDAO().create(m);
		
		
		
		
		
		HttpSession misession = request.getSession(true);
		int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
		
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getById(m.getId());
		
		Propietario propietario = DAOFactory.getFactory().getPropietarioDAO().getById(idPropietario);
		
		foto1.setMascota(mascota);
		foto2.setMascota(mascota);
		foto3.setMascota(mascota);
		
		m.setPropietario(propietario);
		

		DAOFactory.getFactory().getFotoDAO().create(foto1);
		DAOFactory.getFactory().getFotoDAO().create(foto2);
		DAOFactory.getFactory().getFotoDAO().create(foto3);
		
		DAOFactory.getFactory().getMascotaDAO().update(m);
		
		
		//Llamar a la vista
		request.getRequestDispatcher("ListarMascotasController").forward(request, response);
	}

}
