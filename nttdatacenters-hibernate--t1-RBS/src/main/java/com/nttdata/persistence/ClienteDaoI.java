package com.nttdata.persistence;

/**
 * Formación - Hibernate - Taller1
 * 
 * DAO de tabla Cliente (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ClienteDaoI extends CommonDaoI<Cliente> {

	/**
	 * Método de búsqueda por nombre y apellidos.
	 * 
	 * @param name
	 * @param firstsurname
	 * @param secondsurname
	 * @return List<Cliente>
	 */
	public Cliente searchByFullName(final String name, final String firstSurname, final String secondSurname);
}
