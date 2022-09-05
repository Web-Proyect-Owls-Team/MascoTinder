package com.modelo.dao;

import java.util.ArrayList;

import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mensaje;

public interface MensajeDAO extends GenericDAO<Mensaje, Integer> {
	
	Mensaje getMensajeByIdPropietario(int idPropietario);
	void setMensajeByIDPropietario(int idPropietario);
	
	ArrayList<Mensaje> getMensajesByCoincidencia(Coincidencia id);

}
