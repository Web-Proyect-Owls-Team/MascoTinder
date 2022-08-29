package com.modelo.dao;

import com.modelo.entidades.Mascota;
import com.modelo.jpa.JPAGenericDAO;

public interface MascotaDAO extends GenericDAO<Mascota, Integer>{
	
	
	public Mascota getMascotaByID(int id);

}
