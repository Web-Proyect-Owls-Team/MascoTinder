package com.modelo.dao;

import com.modelo.entidades.Preferencia;

public interface PreferenciaDAO extends GenericDAO<Preferencia, Integer> {

	public Preferencia getPrefereciaByID(int id);
	
	public Preferencia getPreferenciaByIDMascota(int idMascota);
}
