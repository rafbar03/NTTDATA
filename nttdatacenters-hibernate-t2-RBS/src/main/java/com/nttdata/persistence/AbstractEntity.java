package com.nttdata.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Formación - Hibernate - Taller2
 * 
 * Entidad abstracta
 * 
 * @author NTT Data Sevilla
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** Serial Version */
	private static final long serialVersionUID = 1L;
	/** Auditoría | Usuario que actualiza */
	private String updatedUser;
	/** Auditoría | Día actualizado */
	private Date updatedDate;

	/**
	 * @return the updatedUser
	 */
	@Column(name = "AUDIT_UPDATED_USER", nullable = false)
	public String getUpdatedUser() {
		return updatedUser;
	}

	/**
	 * @param updatedUser the updatedUser to set
	 */
	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}

	/**
	 * @return the updatedDate
	 */
	@Column(name = "AUDIT_UPDATED_DATE", nullable = false)
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * GET ID
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();
}
