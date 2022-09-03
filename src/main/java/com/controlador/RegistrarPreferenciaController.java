package com.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Especie;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Preferencia;
import com.modelo.entidades.Sexo;

@WebServlet("/RegistrarPreferenciaController")
public class RegistrarPreferenciaController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public RegistrarPreferenciaController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		request.setAttribute("mascota", mascota);
		request.getRequestDispatcher("jsp/registrarPreferencia.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		//Get parameters
		String auxEdadMinima = request.getParameter("txtEdadMinima");
		String auxEdadMaxima = request.getParameter("txtEdadMaxima");
		String sexo = request.getParameter("txtSexo");
		String especie = request.getParameter("txtEspecie");
		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		int edadMinima = Integer.parseInt(auxEdadMinima);
		int edadMaxima = Integer.parseInt(auxEdadMaxima);
		
		Preferencia preferencia = new Preferencia();
		preferencia.setEdadMinima(edadMinima);
		preferencia.setEdadMaxima(edadMaxima);
		preferencia.setEspecie(especie);
		preferencia.setSexo(sexo);
		
		//Call Models
	
		DAOFactory.getFactory().getPreferenciaDAO().create(preferencia);
		Mascota m = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		m.setPreferencia(preferencia);
		DAOFactory.getFactory().getMascotaDAO().update(m);
		
		
		// Dispatch request
		request.getRequestDispatcher("ListarMascotasController").forward(request, response);
	}

}
