package com.modelo.jpa;
import com.*;
import com.modelo.dao.MascotaDAO;
import com.modelo.entidades.Mascota;

public class JPAMascotaDAO extends JPAGenericDAO<Mascota, Integer> implements MascotaDAO{

	public JPAMascotaDAO() {
		super(Mascota.class);
	}

	@Override
	public Mascota getMascotaByID(int id) {
		Mascota mascota = new Mascota();
		return mascota;
	}

}
