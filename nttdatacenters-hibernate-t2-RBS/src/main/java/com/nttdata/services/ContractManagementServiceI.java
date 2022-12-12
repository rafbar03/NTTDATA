package com.nttdata.services;

import java.util.List;

import com.nttdata.persistence.Contract;

/**
 * Formación - Hibernate - Taller2
 * 
 * Servicio de contrato (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ContractManagementServiceI {

	/**
	 * Método para insertar un contrato.
	 * 
	 * @param contract
	 */
	public void insertContract(final Contract contract);

	/**
	 * Método para modificar un contrato.
	 * 
	 * @param contract
	 */
	public void updateContract(final Contract contract);

	/**
	 * Método para eliminar un contrato.
	 * 
	 * @param contract
	 */
	public void deleteContract(final Contract contract);

	/**
	 * Método para consultar contrato por ID.
	 * 
	 * @param contractId
	 * @return Contract
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Método para consultar todos los contratos.
	 * 
	 * @return List<Contract>
	 */
	public List<Contract> searchAll();

	/**
	 * Método de búsqueda de contrato por id del cliente.
	 * 
	 * @param client
	 * @return Contract
	 */
	public Contract searchByClientId(Long client);
}

