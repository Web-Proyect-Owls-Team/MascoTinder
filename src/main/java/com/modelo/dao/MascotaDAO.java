package com.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public interface MascotaDAO extends GenericDAO<Mascota, Integer>{
	
	
	Mascota getMascotaByID(int id);
	
	List<Mascota> getMascotasByIdPropietario(int idPropietario);
	
	List<Mascota> getProspectos(Mascota m);
	
	
}
