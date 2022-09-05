package com.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Coincidencia")

public class Coincidencia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "con_like")
	private boolean like;
	
	@ManyToOne
	@JoinColumn(name = "pretendiente")
	private Mascota pretendiente;
	

	@OneToMany(mappedBy = "coincidencia")
	private List<Mensaje> mensajes;

	@ManyToOne
	@JoinColumn(name = "pretendido")
	private Mascota pretendido;

	
	public Coincidencia() {
	}
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public Mascota getPretendiente() {
		return pretendiente;
	}

	public void setPretendiente(Mascota mascota) {
		this.pretendiente = mascota;
	}

	public boolean getLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	public Mascota getPretendido() {
		return pretendido;
	}
	public void setPretendido(Mascota pretendido) {
		this.pretendido = pretendido;
	}
	@Override
	public String toString() {
		return "Coincidencia [id=" + id + ", like=" + like + ", pretendiente=" + pretendiente + ", pretendido="
				+ pretendido + "]";
	}
	
	
   
}
