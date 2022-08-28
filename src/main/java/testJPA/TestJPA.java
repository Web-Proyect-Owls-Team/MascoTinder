package testJPA;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Propietario;

public class TestJPA {

	public static void main(String[] args) {
		crearPersona();

	}
	
	public static void crearPersona() {
		Propietario p = new Propietario();
		p.setClave("daniel123");
		p.setNombre("Daniel Cadena");
		p.setUsuario("danrylusxd");
		
		DAOFactory.getFactory().getPropietarioDAO().create(p);
	}

}
