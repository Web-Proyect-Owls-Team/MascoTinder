package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Mascota;

@WebServlet("/EliminarMascotaController")
public class EliminarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EliminarMascotaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesar(request, response);
	}
	
	public void procesar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		DAOFactory.getFactory().getMascotaDAO().deleteByID(idMascota);
		request.getRequestDispatcher("ListarMascotasController").forward(request, response);
	}

}
