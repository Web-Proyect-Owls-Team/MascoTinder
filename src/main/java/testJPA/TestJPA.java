package testJPA;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Propietario;

public class TestJPA {

	public static void main(String[] args) {
		// crearPersona();
		crearMascota();

	}
	
	public static void crearPersona() {
		Propietario p = new Propietario();
		p.setClave("daniel123");
		p.setNombre("Daniel Cadena");
		p.setUsuario("danrylusxd");
		
		DAOFactory.getFactory().getPropietarioDAO().create(p);
	}
	
	public static void crearMascota() {
		Mascota m = new Mascota();
		m.setNombre("Michi");
		
		DAOFactory.getFactory().getMascotaDAO().create(m);
	}

}
