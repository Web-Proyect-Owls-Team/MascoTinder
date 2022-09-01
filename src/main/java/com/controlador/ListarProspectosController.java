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
public class ListarProspectosController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListarProspectosController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void listarProspectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. Get Parameters
				HttpSession misession = request.getSession(true);
				int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
				boolean  esMiMascota = false;
				
				//Guradar todas las mascotas de la base de datos exepto las del id del propietario.
				ArrayList<Mascota> mascotas = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO().getMascotasByIdPropietario(idPropietario, esMiMascota);
				
	}

}
