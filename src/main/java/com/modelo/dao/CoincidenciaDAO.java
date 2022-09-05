package com.modelo.dao;

import java.util.ArrayList;

import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;

public interface CoincidenciaDAO extends GenericDAO<Coincidencia, Integer>{
	
	public void darLike(Mascota m);
	
	public Coincidencia getCoincidencia(int idPretendido, int idPretendiente);
	
	public ArrayList<Coincidencia> getCoincidenciasAsPretendiente(Mascota m);
	
	public ArrayList<Coincidencia> getCoincidenciasAsPretendido(Mascota m);
	
	public Coincidencia getCoincidenciabById(int id);

}
