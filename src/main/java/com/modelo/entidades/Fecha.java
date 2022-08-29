package com.modelo.entidades;

import java.io.Serializable;

public class Fecha implements Serializable{
	
    private static final long serialVersionUID = 1L;
    
	// Clase que construya una fecha 
    private int dia;
    private int mes;
    private int anio;

    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //Constructor que recibe una fecha en formato String
    public Fecha(String fecha) {
        String[] fechaSeparada = fecha.split("-");
        this.dia = Integer.parseInt(fechaSeparada[0]);
        this.mes = Integer.parseInt(fechaSeparada[1]);
        this.anio = Integer.parseInt(fechaSeparada[2]);
    }
    
    // Getters y setters
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    // Imprimir la fecha de nacimiento
   @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }


}
