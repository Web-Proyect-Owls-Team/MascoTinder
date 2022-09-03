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
import com.modelo.entidades.Foto;
import com.modelo.entidades.Mascota;


@WebServlet("/ListarMascotasController")
public class ListarMascotasController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public ListarMascotasController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		listMascotas(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listMascotas(request, response);

	}
	
	private void listMascotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. Get Parameters
				HttpSession misession = request.getSession(true);
				int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
				
				System.out.println(idPropietario);
				// 2. Call model
				ArrayList<Mascota> mascotas = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO().getMascotasByIdPropietario(idPropietario);
				ArrayList<Foto> fotos = (ArrayList<Foto>) DAOFactory.getFactory().getFotoDAO().getFotoByIdMascota(5);
				
				// 3. Call View
				
				
				
				misession.setAttribute("misMascotas", mascotas);
				request.setAttribute("mascotas", mascotas);
				request.setAttribute("fotos", fotos);
				request.getRequestDispatcher("jsp/listarMascotas.jsp").forward(request, response);
	}
	
}
