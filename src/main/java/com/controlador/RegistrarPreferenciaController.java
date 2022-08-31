package com.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Especie;
import com.modelo.entidades.Fecha;
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
		request.getRequestDispatcher("jsp/registrarPreferencia.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		//Obtener parámetros
		String auxEdadMinima = request.getParameter("txtEdadMinima");
		String auxEdadMaxima = request.getParameter("txtEdadMaxima");
		String sexoS = request.getParameter("txtSexo");
		String especieS = request.getParameter("txtEspecie");
		
		
		//Tranformar los valores de String a Int
		
		int edadMinima = Integer.parseInt(auxEdadMinima);
		int edadMaxima = Integer.parseInt(auxEdadMaxima);
		
		//Iniciar el modelo.
		Preferencia preferencia = new Preferencia();
		Especie especie = preferencia.convertEspecie(especieS);
		Sexo  sexo= preferencia.convertSexo(sexoS);
		
		preferencia.setEdadMinima(edadMinima);
		preferencia.setEdadMaxima(edadMaxima);
		preferencia.setEspecie(especie);
		preferencia.setSexo(sexo);
		
		DAOFactory.getFactory().getPreferenciaDAO().create(preferencia);
		
		
		request.getRequestDispatcher("jsp/listaMascotas.jsp").forward(request, response);
	}

}
