package com.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Mensaje;
import com.modelo.entidades.Propietario;

/**
 * Servlet implementation class EnviarMensajeController
 */
@WebServlet("/EnviarMensajeController")
public class EnviarMensajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnviarMensajeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Parameters
		int idCoincidencia = Integer.parseInt(request.getParameter("coincidenciaId"));
		HttpSession misession = request.getSession(true);
		int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
		
		int idMascotaMatch = Integer.parseInt(request.getParameter("idMascotaMatch"));
		String mensaje = request.getParameter("mensaje");
		Coincidencia coincidencia = DAOFactory.getFactory().getCoincidenciaDAO().getById(idCoincidencia);
		Propietario propietarioEmisor = DAOFactory.getFactory().getPropietarioDAO().getById(idPropietario);
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getById(idMascotaMatch);
		Propietario propietarioReceptor = mascota.getPropietario();
		// Models
		Mensaje m = new Mensaje();
		m.setMensaje(mensaje);
		
		DAOFactory.getFactory().getMensajeDAO().create(m);
		
		m.setCoincidencia(coincidencia);
		m.setEmisor(propietarioEmisor);
		m.setReceptor(propietarioReceptor);
		
		
		DAOFactory.getFactory().getMensajeDAO().create(m);
		
		int idMiMascota = Integer.parseInt(request.getParameter("idMiMascota"));
		request.setAttribute("idMiMascota", idMiMascota);
		request.setAttribute("idMatch", idMascotaMatch);
		
		request.getRequestDispatcher("ListarMensajesController").forward(request, response);


	}

}
