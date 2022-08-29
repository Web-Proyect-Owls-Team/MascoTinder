package com.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import Modelo.entidades.Persona;

@Entity(name = "Propietario")
public class Propietario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pro_nombre")
	private String nombre;
	
	@Column(name = "pro_usuario")
	private String usuario;
	
	@Column(name = "pro_clave")
	private String clave;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "mascota")	
	private List<Mascota> mascotas;

	public Propietario() {
		
	}

	public Propietario(Integer id, String nombre, String usuario, String clave) {
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	//geter y setter para  mascotas
	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas){
		this.mascotas = mascotas;
	}
	
	
}
