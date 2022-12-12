package com.nttdata.persistence;

/**
 * Formación - Hibernate - Taller2
 * 
 * DAO de tabla Contract (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ContractDaoI extends CommonDaoI<Contract> {

	/**
	 * Método de búsqueda id del cliente.
	 * 
	 * @param clientId
	 * @return Contract
	 */
	public Contract searchByClientId(Long clientId);
}
