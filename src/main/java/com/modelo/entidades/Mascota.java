package com.modelo.entidades;

import java.io.File;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "Mascota")
public class Mascota  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "mas_nombre")
	private String nombre;

	@Column(name = "mas_anioNaciomiento")
	private Fecha anioNaciomiento;

	@Column(name = "mas_imagene")
	private File imagen;
	
	@Column(name = "mas_sexo")
	private Sexo sexo;
	
	@Column(name = "mas_especie")
	private Especie especie;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Propietario Propietario;
	
	@OneToOne @JoinColumn
    private Preferencia preferencia;
	
	//Constructor sin parametros
	public Mascota() {
		
	}

	//Constructor con parametros
	public Mascota(int id, String nombre, Fecha anioNaciomiento, Sexo sexo, Especie especie, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.anioNaciomiento = anioNaciomiento;
		this.sexo = sexo;
		this.especie = especie;
		this.imagen = new File(imagen);
	}
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Fecha getAnioNaciomiento() {
		return anioNaciomiento;
	}
	public void setAnioNaciomiento(Fecha anioNaciomiento) {
		this.anioNaciomiento = anioNaciomiento;
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
	public File getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = new File(imagen);
	}
	
	
	
	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
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

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", anioNaciomiento=" + anioNaciomiento + ", imagen="
				+ imagen + ", sexo=" + sexo + ", especie=" + especie + ", Propietario=" + Propietario + "]";
	}
	
	

}
