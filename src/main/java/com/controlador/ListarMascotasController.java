package com.controlador;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Propietario;


@WebServlet("/ListarMascotasController")
public class ListarMascotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListarMascotasController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("jsp/listarMascotas.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get Parameters
		int idPropietario = Integer.parseInt( (String) request.getAttribute("id"));
		// 2. Call model
		ArrayList<Mascota> mascotas = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO().getMascotasByIdPropietario(idPropietario);
		// 3. Call View
		request.setAttribute("mascotas", mascotas);
		request.getRequestDispatcher("jsp/listarMascotas.jsp").forward(request, response);
	}
	
}
