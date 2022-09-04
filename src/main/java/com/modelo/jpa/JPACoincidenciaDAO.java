package com.modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.CoincidenciaDAO;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public class JPACoincidenciaDAO   extends JPAGenericDAO<Coincidencia, Integer> implements CoincidenciaDAO{

	public JPACoincidenciaDAO() {
		super(Coincidencia.class);

	}

	@Override
	public void darLike(Mascota m) {
		
		
	}

	@Override
	public Coincidencia getCoincidencia(int idPretendido, int idPretendiente) {
		
		String sentenciaJPQL = "SELECT c from Coincidencia c WHERE c.idPretendido = :id_pretendiente AND "
				+ "c.pretendiente.id = :id_pretendido";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id_pretendiente", idPretendiente);
		q.setParameter("id_pretendido", idPretendido);
		List<?> a =  q.getResultList();
		if (a.size() != 0) {
			return (Coincidencia) a.get(0);
		}
		return null;
	}
	
	

}
