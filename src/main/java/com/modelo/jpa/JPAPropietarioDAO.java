package com.modelo.jpa;

import java.util.List;

import javax.persistence.Query;

import com.modelo.dao.PropietarioDAO;
import com.modelo.entidades.Propietario;

public class JPAPropietarioDAO extends JPAGenericDAO<Propietario, Integer> implements PropietarioDAO {

	public JPAPropietarioDAO() {
		super(Propietario.class);
	}

	@Override
	public Propietario autorizarPropietario(String usuario, String clave) {
		System.out.println(usuario + " " + clave + " from JPAAPropietarioDAO");

		Propietario propietarioAutorizado = null;
		String sentenceJPQL = "SELECT p from Propietario p WHERE p.usuario= :param_usuario AND p.clave= :param_clave";
		Query query = this.em.createQuery(sentenceJPQL);
		query.setParameter("param_usuario", usuario);
		query.setParameter("param_clave", clave);
		try {
			propietarioAutorizado = (Propietario) query.getSingleResult();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return propietarioAutorizado;

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Propietario> get() {
		List<Propietario> propietarios = null;
		String sentenceJPQL = "SELECT p from Propietario p ORDER BY p.usuario ASC";
		Query query = this.em.createQuery(sentenceJPQL);
		try {
			propietarios = query.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return propietarios;
	}

}
