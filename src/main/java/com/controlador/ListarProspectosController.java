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
		
		int idMascota = Integer.parseInt(request.getParameter("idMascota"));
		Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
		request.setAttribute("mascota", mascota);
		
		//request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);
		listarProspectos(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);
		listarProspectos(request, response);

	}
	
	private void listarProspectos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		        // Obtener Parametros
				HttpSession misession = request.getSession(true);
				int idPropietario = Integer.parseInt(misession.getAttribute("id").toString());
				
				//Guradar todas las mascotas de la base de datos exepto las del id del propietario.
				ArrayList<Mascota> posiblesProspectos = (ArrayList<Mascota>) DAOFactory.getFactory().getMascotaDAO().getProspectosByIdPropietarios(idPropietario);
				
				//Obtención de la mascota para filtrar los prospectos por sus preferencias
				int idMascota = Integer.parseInt(request.getParameter("idMascota"));
				Mascota mascota = DAOFactory.getFactory().getMascotaDAO().getMascotaByID(idMascota);
				
				//Lista de Prospectos.
				
				ArrayList<Mascota> prospectos = new ArrayList<Mascota>();
				
				//Filtrar
				for(int i = 0; i < posiblesProspectos.size(); i++ ) {
					System.out.println("El size " + posiblesProspectos.size());
					System.out.println( "Prospecto Mascota" + posiblesProspectos.get(i));
					boolean mismaEspecie = mascota.getPreferencia().getEspecie().equals(posiblesProspectos.get(i).getEspecie());
					
					if(mismaEspecie) {
						System.out.println("Mascota misma especie");
						if(mascota.getPreferencia().getSexo().equals(posiblesProspectos.get(i).getSexo())) {
							System.out.println("Mascota sexo aprobado");
							if(mascota.getPreferencia().getEdadMaxima()>= posiblesProspectos.get(i).getEdad() &&
									mascota.getPreferencia().getEdadMinima()<= posiblesProspectos.get(i).getEdad()) {
								System.out.println("Mascota con edad adecuada");
								prospectos.add(posiblesProspectos.get(i));
								
							}
						}
					}
				}
				
				System.out.println("En total coinciden " + prospectos.size());
				//misession.setAttribute("Prospectos", prospectos);
				request.setAttribute("prospectos", prospectos);
				
				request.getRequestDispatcher("jsp/listarProspectos.jsp").forward(request, response);
				
				
				
	}

}
