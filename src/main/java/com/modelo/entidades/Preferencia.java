package com.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Preferencia")
public class Preferencia implements Serializable{

	@Override
	public String toString() {
		return "Preferencia [id=" + id + ", edadMinima=" + edadMinima + ", edadMaxima=" + edadMaxima + ", sexo=" + sexo
				+ ", especie=" + especie + ", mascota=" + mascota + "]";
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pre_edadMinima")
	private int edadMinima;
	
	@Column(name = "pre_edadMaxima")
	private int edadMaxima;
	
	@Column(name = "pre_sexo")
	private String sexo;
	
	@Column(name = "pre_especie")
	private String especie;
	
	@OneToOne( cascade = CascadeType.ALL, mappedBy = "preferencia") @JoinColumn
    private Mascota mascota;

	public Preferencia() {
		super();
	}

	public Preferencia(int id, int edadMinima, int edadMaxima, String sexo, String especie) {
		super();
		this.id = id;
		this.edadMinima = edadMinima;
		this.edadMaxima = edadMaxima;
		this.sexo = sexo;
		this.especie = especie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	
}
