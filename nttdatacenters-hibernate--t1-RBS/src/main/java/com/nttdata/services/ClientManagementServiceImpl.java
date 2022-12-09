package com.nttdata.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.persistence.Cliente;
import com.nttdata.persistence.ClienteDaoI;
import com.nttdata.persistence.ClienteDaoImpl;

/**
 * Formación - Hibernate - Taller1
 * 
 * Servicio de cliente (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/** DAO */
	private ClienteDaoI clienteDao;

	/**
	 * Método constructor
	 * 
	 * @param session
	 */
	public ClientManagementServiceImpl(final Session session) {
		this.clienteDao = new ClienteDaoImpl(session);
	}

	@Override
	public void insertClient(Cliente client) {
		// Verificación cliente no es nulo y ya existe.
		if ((client != null && client.getClientId() == null)) {
			// Inserción del cliente
			clienteDao.insert(client);
		}
	}

	@Override
	public void updateClient(Cliente client) {
		// Verificación cliente no es nulo y ya existe.
		if ((client != null && client.getClientId() != null)) {
			// Actualización del cliente
			clienteDao.update(client);
		}
	}

	@Override
	public void deleteClient(Cliente client) {
		// Verificación cliente no es nulo y ya existe.
		if ((client != null && client.getClientId() != null)) {
			// Eliminación del cliente
			clienteDao.delete(client);
		}
	}

	@Override
	public Cliente searchById(Long id) {
		// Busqueda del cliente por id
		return clienteDao.searchById(id);
	}

	@Override
	public List<Cliente> searchAll() {
		// Consulta de todos los clientes
		return clienteDao.searchAll();
	}

	@Override
	public Cliente searchByFullName(String name, String firstSurname, String secondSurname) {
		// Colsulta de los clientes por nombre y apellidos
		return clienteDao.searchByFullName(name, firstSurname, secondSurname);
	}

}
