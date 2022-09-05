package com.modelo.jpa;

import javax.persistence.Query;

import com.modelo.dao.MensajeDAO;
import com.modelo.entidades.Mensaje;


public class JPAMensajeDAO extends JPAGenericDAO<Mensaje, Integer>  implements MensajeDAO{

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

}
