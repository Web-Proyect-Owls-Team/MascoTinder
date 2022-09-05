package com.modelo.dao;


import com.modelo.jpa.*;

public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract PropietarioDAO getPropietarioDAO();
    public abstract  MascotaDAO getMascotaDAO();
    public abstract PreferenciaDAO getPreferenciaDAO();
    public abstract FotoDAO getFotoDAO();
    public abstract CoincidenciaDAO getCoincidenciaDAO();
    public abstract MensajeDAO getMensajeDAO();

}