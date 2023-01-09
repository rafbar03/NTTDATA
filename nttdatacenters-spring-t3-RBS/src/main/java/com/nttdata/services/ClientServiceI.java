package com.nttdata.services;

import java.time.LocalDate;
import java.util.List;

import com.nttdata.repository.Client;

/**
 * Formación - Spring - Taller3
 * 
 * Servicio Cliente (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ClientServiceI {

	/**
	 * Buscar por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return client
	 */
	public Client getClientByFullName(String name, String surnames);

	/**
	 * Añadir cliente
	 * 
	 * @param name
	 * @param surnames
	 * @param dni
	 * @param bornDate
	 * @return client
	 */
	public void insertClient(String name, String surnames, String dni, LocalDate bornDate);

	/**
	 * Métodod para consultar todos los registros.
	 * 
	 * @return List<Client>
	 */
	public List<Client> searchAll();

}
