package com.modelo.dao;

import java.util.List;

import com.modelo.entidades.Foto;

public interface FotoDAO extends GenericDAO<Foto, Integer> {
	
	List<Foto> getFotoByIdMascota(int idMascota);
}
