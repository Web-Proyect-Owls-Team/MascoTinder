package com.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Foto;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Preferencia;
import com.modelo.entidades.Propietario;

/**
 * Servlet implementation class ActualizarMascotaController
 */
@WebServlet("/ActualizarMascotaController")
public class ActualizarMascotaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ActualizarMascotaController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		request.setAttribute("mascota", mascota);
		request.getRequestDispatcher("jsp/actualizarMascota.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.- obtener parámetros
		HttpSession misession = request.getSession(true);
		int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
		int idMascota = Integer.parseInt(request.getParameter("txtId"));
		String nombre = request.getParameter("txtNombre");
		int fechaNacimiento = Integer.parseInt(request.getParameter("txtFechaNacimiento"));
		String sexo = request.getParameter("txtSexo");
		String especie = request.getParameter("txtEspecie");
		Foto foto1 = new Foto(request.getParameter("txtFoto1"));
		Foto foto2 = new Foto(request.getParameter("txtFoto2"));
		Foto foto3 = new Foto(request.getParameter("txtFoto3"));
		// 2.- Llamar al modelo
		Mascota m = new Mascota();

		m.setId(idMascota);
		m.setNombre(nombre);
		m.setEdad(fechaNacimiento);
		m.setSexo(sexo);
		m.setEspecie(especie);
		
        Propietario propietario = DAOFactory.getFactory().getPropietarioDAO().getById(idPropietario);
		
		foto1.setMascota(m);
		foto2.setMascota(m);
		foto3.setMascota(m);
		
		m.setPropietario(propietario);
		
		System.out.print(m.toString());

		DAOFactory.getFactory().getMascotaDAO().update(m);

		// Llamar a la vista
		request.getRequestDispatcher("ListarMascotasController").forward(request, response);
	}

}
