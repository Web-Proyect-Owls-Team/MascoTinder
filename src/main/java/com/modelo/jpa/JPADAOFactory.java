 package com.modelo.jpa;

import com.modelo.dao.DAOFactory;
import com.modelo.dao.PropietarioDAO;


public class JPADAOFactory extends DAOFactory {

	@Override
	public PropietarioDAO getPropietarioDAO() {
	
		return new JPAPropietarioDAO();
	}

	



}
