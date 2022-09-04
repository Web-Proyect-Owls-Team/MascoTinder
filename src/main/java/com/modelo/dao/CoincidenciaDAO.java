package com.modelo.dao;

import java.util.List;

import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public interface CoincidenciaDAO extends GenericDAO<Coincidencia, Integer>{
	
	public void darLike(Mascota m);
	
	public Coincidencia getCoincidencia(int idPretendido, int idPretendiente);
	
	public List<Mascota> getCoincidencias (Mascota m, boolean conLike);

}
