

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< Updated upstream:src/main/java/controladores/ListarMascotasControler.java
import com.cmc.modelos.JPAMascotaDAO;
import com.cmc.modelos.JPAPropietarioDAO;
=======
import com.modelo.jpa.JPAMascotaDAO;
import com.modelo.jpa.JPAPropietarioDAO;

>>>>>>> Stashed changes:src/main/java/com/controlador/ListarMascotasController.java

/**
 * Servlet implementation class ListarMascotasControler
 */
@WebServlet("/ListarMascotasControler")
public class ListarMascotasControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarMascotasControler() {
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
