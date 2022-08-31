package com.modelo.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "Preferencia")
public class Preferencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pre_edadMinima")
	private int edadMinima;
	
	@Column(name = "pre_edadMaxima")
	private int edadMaxima;
	
	@Column(name = "pre_sexo")
	private Sexo sexo;
	
	@Column(name = "pre_especie")
	private Especie especie;
	
	@OneToOne( cascade = CascadeType.ALL, mappedBy = "preferencia")
    private Mascota mascota;

	public Preferencia() {
		super();
	}

	public Preferencia(int id, int edadMinima, int edadMaxima, Sexo sexo, Especie especie) {
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	
	//Metodo que convierte un string a un enum
		public Sexo convertSexo(String sexo){
			if(sexo.equals("Macho")){
				this.sexo = Sexo.Macho;
			}else{
				this.sexo = Sexo.Hembra;
			}
			return this.sexo;
		}

		public Especie convertEspecie(String especie) {
			if(especie.equals("Perro")){
				this.especie = Especie.Perro;
			}else if(especie.equals("Gato")){
				this.especie = Especie.Gato;
			}else if(especie.equals("Kanguro")){
				this.especie = Especie.Kanguro;
			}else if(especie.equals("Ave")){
				this.especie = Especie.Ave;
			}else{
				this.especie = Especie.Otro;
			}
			return this.especie;
		}
	
}
