package com.modelo.entidades;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Mensaje
 *
 */
@Entity(name="Mensaje")

public class Mensaje implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMensaje;

	@Column(name="id_mensaje")
	private String mensaje;

	@ManyToOne
	@JoinColumn(name="id_Coincidencia")
	private Coincidencia coincidencia;

	@ManyToOne
	@JoinColumn(name="m_emisor")
	private Propietario emisor;

	@ManyToOne
	@JoinColumn(name="m_receptor")
	private Propietario receptor;

	

	public Mensaje() {
		super();
	}

	public int getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Coincidencia getCoincidencia() {
		return coincidencia;
	}

	public void setCoincidencia(Coincidencia coincidencia) {
		this.coincidencia = coincidencia;
	}

	public Propietario getEmisor() {
		return emisor;
	}

	public void setEmisor(Propietario emisor) {
		this.emisor = emisor;
	}

	public Propietario getReceptor() {
		return receptor;
	}

	public void setReceptor(Propietario receptor) {
		this.receptor = receptor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Mensaje [idMensaje=" + idMensaje + ", mensaje=" + mensaje + ", coincidencia=" + coincidencia + ", emisor="
				+ emisor + ", receptor=" + receptor + "]";
	}

	

   
}
