package com.nttdata.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.repository.Client;
import com.nttdata.repository.ClientRepositoryI;

/**
 * Formación - Spring - Taller3
 * 
 * Servicio Cliente (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

@Service
public class ClientServiceImpl implements ClientServiceI {

	@Autowired
	ClientRepositoryI repositoryI;

	@Override
	public Client getClientByFullName(String name, String surnames) {
		// Buscar por nombre y apellidos
		return repositoryI.findByNameAndSurnames(name, surnames);
	}

	@Override
	public void insertClient(String name, String surnames, String dni, LocalDate bornDate) {
		// Añadir cliente
		Client newClient = new Client();
		newClient.setName(name);
		newClient.setSurnames(surnames);
		newClient.setBornDate(bornDate);
		newClient.setDni(dni);
		repositoryI.save(newClient);
	}

	@Override
	public List<Client> searchAll() {
		// consultar todos los clientes
		return (List<Client>) repositoryI.findAll();
	}

}
