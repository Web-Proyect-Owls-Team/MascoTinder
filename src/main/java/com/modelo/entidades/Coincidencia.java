package com.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Coincidencia")

public class Coincidencia implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "id_pretendido")
	private int idPretendido;
	
	@Column(name = "con_like")
	private boolean like;
	
	@ManyToOne
	@JoinColumn(name = "pretendiente")
	private Mascota pretendiente;
	
	public Coincidencia() {
	}
	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPretendido() {
		return idPretendido;
	}

	public void setIdPretendido(int id) {
		this.idPretendido = id;
	}

	public Mascota getPretendiente() {
		return pretendiente;
	}

	public void setPretendiente(Mascota mascota) {
		this.pretendiente = mascota;
	}

	public boolean isLike() {
		return like;
	}
	public void setLike(boolean like) {
		this.like = like;
	}
	
	
   
}
