package com.modelo.jpa;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import com.modelo.dao.MascotaDAO;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO{

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	@Override
	public Mascota getMascotaByID(int id) {
		// Considere el verificar tambien el id del usuario para evitar traer cualquier mascota si se modifica el html
		Mascota mascota = null;
		String sentenciaJPQL = "SELECT m from Mascota m WHERE m.id = :id";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id", id);
		mascota = (Mascota) q.getSingleResult();
		return mascota;
	}


	@Override
	public List<Mascota> getMascotasByIdPropietario(int idPropietario) {
		
		String sentenciaJPQL= "SELECT m from Mascota m WHERE m.propietario.id = :id";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id", idPropietario);
		return listarMascotas(q);
	
	}

	@Override
	public List<Mascota> getProspectos(Mascota m) {
		
		int idPropietario = m.getPropietario().getId();
		int maxAge = m.getPreferencia().getEdadMaxima();
		int minAge = m.getPreferencia().getEdadMinima();
		String sex = m.getPreferencia().getSexo();
		String species = m.getPreferencia().getEspecie();
		
		String sentenciaJPQL = "SELECT m from Mascota m WHERE "
								+ "m.propietario.id != :id AND "
								+ "m.sexo = :sexo AND "
								+ "m.especie = :especie AND "
								+ "m.edad <= :maxEdad AND "
								+ "m.edad >= :minEdad";
		
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id", idPropietario);
		q.setParameter("sexo", sex);
		q.setParameter("especie", species);
		q.setParameter("maxEdad", maxAge);
		q.setParameter("minEdad", minAge);
		ArrayList<Mascota> posibleProspectos = (ArrayList<Mascota>) listarMascotas (q);  
		return posibleProspectos;
	}
	
	
	private List<Mascota> listarMascotas(Query q) {
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		List<?> aux = q.getResultList();
		for(int i = 0; i < aux.size(); i++) {
			Mascota auxMascota = (Mascota) aux.get(i);
			mascotas.add(auxMascota);
		}
		return mascotas;
	}



}
