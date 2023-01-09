package com.nttdata;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.repository.Client;
import com.nttdata.services.ClientServiceI;

/**
 * Formación - Spring - Taller3
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */

@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {
	@Autowired
	ClientServiceI clientService;

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NTTDataMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Insertamos clientes
		clientService.insertClient("Luis", "De la Rosa", "45617288P", LocalDate.now());
		clientService.insertClient("Pedro", "Martínez", "75821923F", LocalDate.now());
		clientService.insertClient("Sonia", "Bonillo", "36652839J", LocalDate.now());
		clientService.insertClient("Carla", "Trujillo", "84863579E", LocalDate.now());

		// Buscamos cliente por nombre y apellido
		System.out.println(clientService.getClientByFullName("Sonia", "Bonillo"));

		// Buscamos todos los clientes
		List<Client> clients = clientService.searchAll();

		System.out.println(clients);

	}

}
