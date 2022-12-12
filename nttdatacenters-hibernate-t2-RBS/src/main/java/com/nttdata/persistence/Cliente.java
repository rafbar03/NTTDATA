package com.nttdata.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

/**
 * Formación - Hibernate - Taller2
 * 
 * Entidad de tabla Cliente
 * 
 * @author NTT Data Sevilla
 *
 */

@Entity
@Table(name = "T_CLIENT")
public class Cliente extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long clientId;

	/** Nombre del cliente */
	private String name;

	/** Primer apellido del cliente */
	private String firstSurname;

	/** Segundo apellido del cliente */
	private String secondSurname;

	/** DNI */
	private String dni;

	/** Contratos relacionados */
	private List<Contract> contractList;

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
	 * @return the firstSurname
	 */
	@Column(name = "FIRSTSURNAME")
	public String getFirstSurname() {
		return firstSurname;
	}

	/**
	 * @param firstSurname the firstSurname to set
	 */
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	/**
	 * @return the secondSurname
	 */
	@Column(name = "SECONDSURNAME")
	public String getSecondSurname() {
		return secondSurname;
	}

	/**
	 * @param secondSurname the secondSurname to set
	 */
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	/**
	 * @return the dni
	 */
	@Column(name = "DNI", nullable = false, unique = true, length = 9)
	@NotEmpty
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
	@Transient
	public Long getId() {
		return this.clientId;
	}

	@Override
	public String toString() {
		return "Cliente [clientId=" + clientId + ", name=" + name + ", firstSurname=" + firstSurname
				+ ", secondSurname=" + secondSurname + ", dni=" + dni + "]";
	}

	/**
	 * @return the contractList
	 */
	@OneToMany(mappedBy = "cliente")
	public List<Contract> getContractList() {
		return contractList;
	}

	/**
	 * @param contractList the contractList to set
	 */
	public void setContractList(List<Contract> contractList) {
		this.contractList = contractList;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}
}
