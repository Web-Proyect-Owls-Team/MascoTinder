package com.modelo.dao;

import com.modelo.entidades.Propietario;

public interface PropietarioDAO extends GenericDAO<Propietario, Integer> {


	public Propietario autorizarPropietario(String usuario, String clave);

}
