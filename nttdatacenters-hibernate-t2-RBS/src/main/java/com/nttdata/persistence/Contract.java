package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Taller2
 * 
 * Entidad de tabla Contract
 * 
 * @author NTT Data Sevilla
 *
 */

@Entity
@Table(name = "T_CONTRACT")
public class Contract extends AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;

	/** Identificador (PK) */
	private Long contractId;

	/** Fecha de vigencia */
	private Date validityDate;

	/** Fecha de caducidad */
	private Date expirationDate;

	/** Precio mensual */
	private double monthlyPrice;

	/** Cliente relacionado (FK) */
	private Cliente cliente;

	/**
	 * @return the contractId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	/**
	 * @param contractId the contractId to set
	 */
	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	/**
	 * @return the validityDate
	 */
	@Column(name = "VALIDITYDATE")
	public Date getValidityDate() {
		return validityDate;
	}

	/**
	 * @param validityDate the validityDate to set
	 */
	public void setValidityDate(Date validityDate) {
		this.validityDate = validityDate;
	}

	/**
	 * @return the expirationDate
	 */
	@Column(name = "EXPIRATIONDATE")
	public Date getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * @return the monthlyPrice
	 */
	@Column(name = "MONTHLYPRICE")
	public double getMonthlyPrice() {
		return monthlyPrice;
	}

	/**
	 * @param monthlyPrice the monthlyPrice to set
	 */
	public void setMonthlyPrice(double monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	/**
	 * @return the client
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the client to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Transient
	public Long getId() {
		return this.contractId;
	}

	@Transient
	public Class<?> getClase() {
		return Contract.class;
	}

	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", validityDate=" + validityDate + ", expirationDate="
				+ expirationDate + ", monthlyPrice=" + monthlyPrice + "]";
	}

}
