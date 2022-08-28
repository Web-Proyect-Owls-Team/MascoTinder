package com.controlador;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modelo.jpa.JPAPropietarioDAO;


@WebServlet("/ListarMascotasControler")
public class ListarMascotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListarMascotasController() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1.Obtenemos Parametros
		// 2. Llamamos al modelo
		JPAPropietarioDAO propietario = new  JPAPropietarioDAO();

		List<JPAMascotaDAO > mascotas = propietario.getMascotas();
		
		request.setAttribute("mascotas", mascotas);
		request.setAttribute("propietarioAutorizado", propietario);
		
		// 3. LLamamos a la vista
		request.getRequestDispatcher("JSP/vermascota.jsp").forward(request, response);
	}
	
}
