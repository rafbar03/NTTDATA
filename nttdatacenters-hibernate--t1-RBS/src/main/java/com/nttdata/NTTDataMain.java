package com.nttdata;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.Cliente;
import com.nttdata.services.ClientManagementServiceI;
import com.nttdata.services.ClientManagementServiceImpl;

/**
 * Formación - Hibernate - Taller1
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */

public class NTTDataMain {

	/**
	 * Método principal.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/** logGER **/
		final Logger log = LoggerFactory.getLogger("salida");

		log.info("PRIMERA TRAZA");
		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);

		// Auditoría.
		final String updateUser = "NTT_CLIENTE";
		final Date updateDate = new Date();

		log.info("GENERAMOS CLIENTES");
		// Creación clientes.
		final Cliente cliente1 = new Cliente();
		cliente1.setName("Luis");
		cliente1.setFirstSurname("Ruiz");
		cliente1.setSecondSurname("Martínez");
		cliente1.setDni("34512699R");
		cliente1.setUpdatedUser(updateUser);
		cliente1.setUpdatedDate(updateDate);

		final Cliente cliente2 = new Cliente();
		cliente2.setName("Pedro");
		cliente2.setFirstSurname("Hernández");
		cliente2.setSecondSurname("Sánchez");
		cliente2.setDni("73724821K");
		cliente2.setUpdatedUser(updateUser);
		cliente2.setUpdatedDate(updateDate);

		final Cliente cliente3 = new Cliente();
		cliente3.setName("Manuel");
		cliente3.setFirstSurname("López");
		cliente3.setSecondSurname("Codón");
		cliente3.setDni("51370802M");
		cliente3.setUpdatedUser(updateUser);
		cliente3.setUpdatedDate(updateDate);

		final Cliente cliente4 = new Cliente();
		cliente4.setName("Daniel");
		cliente4.setFirstSurname("García");
		cliente4.setSecondSurname("Buzón");
		cliente4.setDni("15613548F");
		cliente4.setUpdatedUser(updateUser);
		cliente4.setUpdatedDate(updateDate);

		log.info("INSERTAMOS CLIENTES");
		// Insercción clientes.
		clientService.insertClient(cliente1);
		clientService.insertClient(cliente2);
		clientService.insertClient(cliente3);
		clientService.insertClient(cliente4);

		log.info("CONSULTA DE TODOS LOS CLIENTES");
		// Consulta general.
		List<Cliente> clientesList = clientService.searchAll();
		log.info("Muestra todos los clientes: ");
		for (final Cliente cliente : clientesList) {
			System.out.println(cliente.getClientId() + " " + cliente.getName() + " " + cliente.getFirstSurname() + " "
					+ cliente.getSecondSurname() + " " + cliente.getDni());
		}

		log.info("ACTUALIZACIÓN DE CLIENTE");
		// Aztualizar.
		cliente2.setSecondSurname("Serrano");
		clientService.updateClient(cliente2);

		log.info("CONSULTA DE TODOS LOS CLIENTES");
		// Consulta general.
		log.info("Muestra todos los clientes: ");
		for (final Cliente cliente : clientesList) {
			System.out.println(cliente.getClientId() + " " + cliente.getName() + " " + cliente.getFirstSurname() + " "
					+ cliente.getSecondSurname() + " " + cliente.getDni());
		}

		log.info("CONSULTA POR NOMBRE Y APELLIDOS");
		// Consulta por nombre y apellidos.
		Cliente searchBySurnamesAndName = clientService.searchByFullName("Pedro", "Hernández", "Serrano");
		System.out.println("Consulta por nombre y apellidos");
		System.out.println(searchBySurnamesAndName);

		log.info("ELIMINACIÓN DE CLIENTE");
		// Eliminamos un cliente.
		clientService.deleteClient(cliente3);

		log.info("CONSULTAMOS CLIENTE POR ID");
		// Consulta por id.
		Cliente searchId = clientService.searchById((long) 3);
		System.out.println(searchId);

		// Cierre de sesión.
		session.close();

		log.info("FIN DE TRAZA");
	}
}