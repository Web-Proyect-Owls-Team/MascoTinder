package com.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.FotoDAO;
import com.modelo.entidades.Foto;

public class JPAFotoDAO  extends JPAGenericDAO<Foto, Integer> implements FotoDAO {

	

	public JPAFotoDAO() {
		super(Foto.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Foto> getFotoByIdMascota(int idMascota) {
		// Foto por ID de Mascota
		ArrayList<Foto> foto = new ArrayList<Foto>();
		// Query
		String sentenciaJPQL = "SELECT g from Foto g WHERE g.mascota.id = :mascota_id";
		Query q = this.em.createQuery(sentenciaJPQL);
		q.setParameter("mascota_id", idMascota);
		List<?> a = q.getResultList();
		// Prepare List
		for (int i = 0; i < a.size(); i++ ) {
			Foto gal = (Foto) a.get(i);
			foto.add(gal);
		}	
		return foto;
		
	}

}
