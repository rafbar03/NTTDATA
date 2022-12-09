package com.nttdata.persistence;

import org.hibernate.Session;

/**
 * Formación - Hibernate - Taller1
 * 
 * DAO de tabla Cliente (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI {

	/** Sesión base de datos */
	private Session session;

	/**
	 * Constructor
	 * 
	 * @param session
	 */
	public ClienteDaoImpl(Session session) {
		super(session);
		this.session = session;

	}

	@Override
	public Cliente searchByFullName(String name, String firstSurname, String secondSurname) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		return (Cliente) session.createQuery("FROM Cliente WHERE name='" + name + "' AND firstSurname='" + firstSurname
				+ "' AND secondSurname='" + secondSurname + "'").getSingleResult();
	}
}
