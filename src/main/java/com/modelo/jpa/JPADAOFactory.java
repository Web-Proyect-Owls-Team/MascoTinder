 package com.modelo.jpa;




import com.modelo.dao.CoincidenciaDAO;
import com.modelo.dao.DAOFactory;
import com.modelo.dao.FotoDAO;
import com.modelo.dao.MascotaDAO;
import com.modelo.dao.PreferenciaDAO;
import com.modelo.dao.PropietarioDAO;


public class JPADAOFactory extends DAOFactory {

	@Override
	public PropietarioDAO getPropietarioDAO() {
	
		return new JPAPropietarioDAO();
	}

	@Override
	public MascotaDAO getMascotaDAO() {
		
		return new JPAMascotaDAO();
	}

	@Override
	public PreferenciaDAO getPreferenciaDAO() {
		return new JPAPreferenciaDAO();
	}
	@Override
	public FotoDAO getFotoDAO() {
		// TODO Auto-generated method stub
		return new JPAFotoDAO();
	}


	@Override
	public CoincidenciaDAO getCoincidenciaDAO() {
		
		return new JPACoincidenciaDAO();
	}


}
