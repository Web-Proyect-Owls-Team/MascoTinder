package com.modelo.jpa;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import com.modelo.dao.MascotaDAO;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Preferencia;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO{

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	@Override
	public Mascota getMascotaByID(int id) {
		// Considera el verificar tambien el id del usuario para evitar traer cualquier mascota si se modifica el html
		Mascota mascota = null;
		String sentenciaJPQL = "SELECT m from Mascota m WHERE m.id = :id";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id", id);
		mascota = (Mascota) q.getSingleResult();
		return mascota;
	}


	@Override
	public List<Mascota> getMascotasByIdPropietario(int idPropietario) {

		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();	
		// Query
		String sentenciaJPQL = "SELECT m from Mascota m WHERE m.propietario.id = :propietario_id";
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
