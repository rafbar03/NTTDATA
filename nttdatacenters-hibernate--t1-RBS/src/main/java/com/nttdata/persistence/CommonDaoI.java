package com.nttdata.persistence;

import java.util.List;

/**
 * Formación - Hibernate - Taller1
 * 
 * DAO genérico (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface CommonDaoI<T> {

	/**
	 * Inserta un registro en BBDD.
	 * 
	 * @param obj
	 */
	public void insert(final T obj);

	/**
	 * Búsqueda de todos los registros en BBDD.
	 * 
	 * @return List<T>
	 */
	public List<T> searchAll();

	/**
	 * Localiza un registro por ID en BBDD.
	 * 
	 * @param id
	 */
	public T searchById(final Long id);

	/**
	 * Elimina un registro en BBDD.
	 * 
	 * @param obj
	 */
	public void delete(final T obj);

	/**
	 * Actualiza un registro en BBDD.
	 * 
	 * @param obj
	 */
	public void update(final T obj);
}
