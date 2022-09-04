package com.modelo.dao;

import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public interface CoincidenciaDAO extends GenericDAO<Coincidencia, Integer>{
	
	public void darLike(Mascota m);
	
	public Coincidencia getCoincidencia(int idPretendido, int idPretendiente);

}
