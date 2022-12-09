package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Cliente;

/**
 * Formación - Hibernate - Taller1
 * 
 * Servicio de cliente (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ClientManagementServiceI {

	/**
	 * Método para insertar un cliente.
	 * 
	 * @param client
	 */
	public void insertClient(final Cliente client);

	/**
	 * Método para modificar un cliente.
	 * 
	 * @param client
	 */
	public void updateClient(final Cliente client);

	/**
	 * Método par eliminar un cliente.
	 * 
	 * @param client
	 */
	public void deleteClient(final Cliente client);

	/**
	 * Métodod consultar por ID.
	 * 
	 * @param id
	 * @return Client
	 */
	public Cliente searchById(final Long id);

	/**
	 * Métodod para consultar todos los registros.
	 * 
	 * @return List<Client>
	 */
	public List<Cliente> searchAll();

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
