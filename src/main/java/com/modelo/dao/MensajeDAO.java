package com.modelo.dao;

import com.modelo.entidades.Mensaje;

public interface MensajeDAO extends GenericDAO<Mensaje, Integer> {
	
	Mensaje getMensajeByIdPropietario(int idPropietario);
	void setMensajeByIDPropietario(int idPropietario);

}
