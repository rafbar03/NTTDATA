package com.nttdata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Formación - Spring - Taller3
 * 
 * Repositorio Tabla Cliente (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

@Repository
public interface ClientRepositoryI extends CrudRepository<Client, Long> {

	/**
	 * Buscar por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return client
	 */
	public Client findByNameAndSurnames(String name, String surnames);
}
