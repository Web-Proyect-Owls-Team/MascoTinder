package com.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.eclipse.persistence.descriptors.changetracking.AttributeChangeTrackingPolicy;

import com.controlador.ListarCoincidenciasController;
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

	@Override
	public List<Mascota> getCoincidencias(Mascota m, boolean conLike) {
		
		int idMascotaPretendiente = m.getId();
		
		String sentenciaJPQL = "SELECT c from Coincidencia c WHERE c.Pretendiente.id = : id_pretendiente AND"
		+ "c.conlike = : con_like";
		
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id_pretendiente", idMascotaPretendiente);
		q.setParameter("con_like", conLike);
		
		ArrayList<Mascota> mascotasCoincidentes = new ArrayList<Mascota>();
		
		List<?> aux = q.getResultList();
		
		for(int i = 0; i < aux.size();i++) {
			
			Coincidencia coincidencia = (Coincidencia) aux.get(i);
			int idPretendido = coincidencia.getIdPretendido();
			
			mascotasCoincidentes.add(buscarPretendido(idPretendido));
			
		}
		
		
		
		return mascotasCoincidentes;
		
		
	}
	
	public Mascota buscarPretendido(int idPretendido){
		
		String sentenciaJPQL = "SELECT m from Mascota m WHERE m.id = : id";
		
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("id", idPretendido);
		
		Mascota mascota = (Mascota)q.getSingleResult();
		
		
		return mascota;
		
	}

	



	
	
	

}
