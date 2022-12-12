package com.nttdata.persistence;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller2
 * 
 * DAO de tabla Contract (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	/** Sesión base de datos */
	private Session session;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Contract searchByClientId(Long cliente) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		return (Contract) session.createQuery("FROM Contract WHERE CLIENT_ID='" + cliente + "'").getSingleResult();
	}

}
