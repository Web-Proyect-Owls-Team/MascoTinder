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
	private Integer id;

	@Column(name = "mas_nombre")
	private String nombre;

	@Column(name = "mas_edad")
	private int edad;

	@Column(name = "mas_imagene")
	private String imagen;
	
	@Column(name = "mas_sexo")
	private String sexo;
	
	@Column(name = "mas_especie")
	private String especie;
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	private Propietario propietario;
	
	@OneToOne @JoinColumn
    private Preferencia preferencia;
	
	//Constructor sin parametros
	public Mascota() {
		
	}

	//Constructor con parametros
	public Mascota(int id, String nombre, int edad, String sexo, String especie, String imagen) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.especie = especie;
		this.imagen = imagen;
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
	public int edad() {
		return this.edad;
	}
	public void edad(int edad) {
		this.edad = edad;
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Propietario getPropietario() {
		return this.propietario;
	}
	public void setPropietario(Propietario propietario) {
		this.propietario=propietario;
	}
	
	public Preferencia getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(Preferencia preferencia) {
		this.preferencia = preferencia;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", anioNaciomiento=" + edad + ", imagen="
				+ imagen + ", sexo=" + sexo + ", especie=" + especie + ", Propietario=" + propietario + "]";
	}
	
	

}
