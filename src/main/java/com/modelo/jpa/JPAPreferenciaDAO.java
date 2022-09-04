package com.modelo.jpa;

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


	
	


	
}
