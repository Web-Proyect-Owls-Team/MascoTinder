package com.modelo.dao;

import java.util.List;

import com.modelo.entidades.Mascota;
import com.modelo.entidades.Preferencia;

public interface MascotaDAO extends GenericDAO<Mascota, Integer>{
	
	
	Mascota getMascotaByID(int id);
	
	List<Mascota> getMascotasByIdPropietario(int idPropietario);
	
	

}
