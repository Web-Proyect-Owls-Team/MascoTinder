package com.modelo.jpa;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.MascotaDAO;
import com.modelo.entidades.Mascota;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO{

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	@Override
	public Mascota getMascotaByID(int id) {
		Mascota mascota = new Mascota();
		return mascota;
	}


	@Override
	public List<Mascota> getMascotasByIdPropietario(int idPropietario) {

		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();	
		// Query
		String sentenciaJPQL = "SELECT m from Mascota m WHERE m.Propietario.id = :propietario_id";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("propietario_id", idPropietario);
		List<?> a = q.getResultList();
		// Prepare List
		for (int i = 0; i < a.size(); i++ ) {
			Mascota mas = (Mascota) a.get(i);
			mascotas.add(mas);
		}
		return mascotas;
	}

}
