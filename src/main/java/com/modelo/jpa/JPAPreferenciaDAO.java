package com.modelo.jpa;

import javax.persistence.Query;

import com.modelo.dao.PreferenciaDAO;
import com.modelo.entidades.Preferencia;

public class JPAPreferenciaDAO extends JPAGenericDAO<Preferencia, Integer> implements PreferenciaDAO {

	public JPAPreferenciaDAO() {
		super(Preferencia.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Preferencia getPrefereciaByID(int id) {
		// TODO Auto-generated method stub
		Preferencia preferencia = new Preferencia();
		return preferencia;
	}

	@Override
	public Preferencia getPreferenciaByIDMascota(int idMascota) {
		// TODO Auto-generated method stub
		
		Preferencia preferencia =  null;
		
		String sentenciaJPQL = sentenciaJPQL = "SELECT p from Preferencia p WHERE p.mascota.id = :mascota_id";
		
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("mascota_id", idMascota);
		
		preferencia = (Preferencia)q.getSingleResult();
		
		return preferencia;
	}

	
}
