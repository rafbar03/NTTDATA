package com.nttdata.services;

import java.util.List;
import org.hibernate.Session;
import com.nttdata.persistence.Contract;
import com.nttdata.persistence.ContractDaoI;
import com.nttdata.persistence.ContractDaoImpl;

/**
 * Formación - Hibernate - Taller2
 * 
 * Servicio de contrato (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

public class ContractManagementServiceImpl implements ContractManagementServiceI {

	/** DAO */
	private ContractDaoI contractDao;

	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	@Override
	public void insertContract(Contract contract) {
		// Verificación contracto no es nulo y ya existe.
		if ((contract != null && contract.getContractId() == null)) {
			// Inserción del cliente
			contractDao.insert(contract);
		}
	}

	@Override
	public void updateContract(Contract contract) {
		// Verificación contracto no es nulo y ya existe.
		if ((contract != null && contract.getContractId() != null)) {
			// Actualización del cliente
			contractDao.update(contract);
		}
	}

	@Override
	public void deleteContract(Contract contract) {
		// Verificación contracto no es nulo y ya existe.
		if ((contract != null && contract.getContractId() != null)) {
			// Eliminación del cliente
			contractDao.delete(contract);
		}
	}

	@Override
	public Contract searchById(Long contractId) {
		// Busqueda del contrato por id
		return contractDao.searchById(contractId);
	}

	@Override
	public List<Contract> searchAll() {
		// Consulta de todos los contratos
		return contractDao.searchAll();
	}

	@Override
	public Contract searchByClientId(Long client) {
		// Colsulta de los contratos por id del cliente
		return contractDao.searchByClientId(client);
	}

}
