package com.modelo.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.MensajeDAO;
import com.modelo.entidades.Coincidencia;
import com.modelo.entidades.Mascota;
import com.modelo.entidades.Mensaje;

public class JPAMensajeDAO extends JPAGenericDAO<Mensaje, Integer> implements MensajeDAO {

	public JPAMensajeDAO() {
		super(Mensaje.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mensaje getMensajeByIdPropietario(int idPropietario) {
		// Recuperar el mensaje por idPropietario
		String sentencia = "SELECT m FROM Mensaje m WHERE m.pretendido.id = :idPropietario";
		Query query = em.createQuery(sentencia);
		query.setParameter("idPropietario", idPropietario);
		Mensaje mensaje = (Mensaje) query.getSingleResult();
		return mensaje;
	}

	@Override
	public void setMensajeByIDPropietario(int idPropietario) {
		// Enviar mensaje por propietario

	}

	@Override
	public ArrayList<Mensaje> getMensajesByCoincidencia(Coincidencia c) {
		ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
		List<?> aux = c.getMensajes();
		for(int i = 0; i < aux.size(); i++) {
			Mensaje auxMensaje = (Mensaje) aux.get(i);
			mensajes.add(auxMensaje);
		}
		return mensajes;
	}

}
