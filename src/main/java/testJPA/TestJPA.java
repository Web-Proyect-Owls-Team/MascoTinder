package testJPA;

import java.util.ArrayList;

import com.modelo.dao.DAOFactory;
import com.modelo.entidades.Foto;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Propietario;

public class TestJPA {

	public static void main(String[] args) {
		crearPersona();
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
		ArrayList<Foto> fotos = new ArrayList<>();
		Foto foto1 = new Foto();
		foto1.setFoto("fotoo");
		fotos.add(foto1);
		m.setFotos(fotos);
		DAOFactory.getFactory().getMascotaDAO().create(m);
		DAOFactory.getFactory().getFotoDAO().create(foto1);
		System.out.println("Mascot acreadaaa");
	}


}
