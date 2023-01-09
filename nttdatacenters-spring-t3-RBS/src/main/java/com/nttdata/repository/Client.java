package com.nttdata.repository;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Formación - Spring - Taller3
 * 
 * Entidad Tabla Cliente
 * 
 * @author NTT Data Sevilla
 *
 */

@Entity
@Table(name = "T_CLIENT")
public class Client implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador */
	private Long clientId;

	/** Nombre */
	private String name;

	/** Apellidos */
	private String surnames;

	/** Fecha Nacimiento */
	private LocalDate bornDate;

	/** DNI */
	private String dni;

	/**
	 * @return the clientId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surnames
	 */
	@Column(name = "SURNAMES")
	public String getSurnames() {
		return surnames;
	}

	/**
	 * @param surnames the surnames to set
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * @return the bornDate
	 */
	@Column(name = "BORNDATE")
	public LocalDate getBornDate() {
		return bornDate;
	}

	/**
	 * @param bornDate the bornDate to set
	 */
	public void setBornDate(LocalDate bornDate) {
		this.bornDate = bornDate;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", name=" + name + ", surnames=" + surnames + ", bornDate=" + bornDate
				+ ", dni=" + dni + "]";
	}

}
