package com.nttdata;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nttdata.persistence.Cliente;
import com.nttdata.services.ClientManagementServiceI;
import com.nttdata.services.ClientManagementServiceImpl;
import com.nttdata.persistence.Contract;
import com.nttdata.services.ContractManagementServiceI;
import com.nttdata.services.ContractManagementServiceImpl;

/**
 * Formación - Hibernate - Taller2
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

		/** LOGGER **/
		final Logger log = LoggerFactory.getLogger("salida");

		log.info("PRIMERA TRAZA");
		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);
		final ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);
		
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
		
		log.info("GENERAMOS CONTRATOS");
		// Creación contratos.
		final Contract contract1 = new Contract();
		contract1.setCliente(cliente1);
		contract1.setValidityDate(new Date());
		contract1.setExpirationDate(new Date());
		contract1.setMonthlyPrice(10);
		contract1.setUpdatedUser(updateUser);
		contract1.setUpdatedDate(updateDate);
		
		final Contract contract2 = new Contract();
		contract2.setCliente(cliente2);
		contract2.setValidityDate(new Date());
		contract2.setExpirationDate(new Date());
		contract2.setMonthlyPrice(12.3);
		contract2.setUpdatedUser(updateUser);
		contract2.setUpdatedDate(updateDate);
		
		final Contract contract3 = new Contract();
		contract3.setCliente(cliente3);
		contract3.setValidityDate(new Date());
		contract3.setExpirationDate(new Date());
		contract3.setMonthlyPrice(9.99);
		contract3.setUpdatedUser(updateUser);
		contract3.setUpdatedDate(updateDate);
		
		final Contract contract4 = new Contract();
		contract4.setCliente(cliente4);
		contract4.setValidityDate(new Date());
		contract4.setExpirationDate(new Date());
		contract4.setMonthlyPrice(15);
		contract4.setUpdatedUser(updateUser);
		contract4.setUpdatedDate(updateDate);
		
		log.info("INSERTAMOS CLIENTES");
		// Insercción clientes.
		clientService.insertClient(cliente1);
		clientService.insertClient(cliente2);
		clientService.insertClient(cliente3);
		clientService.insertClient(cliente4);
		
		log.info("INSERTAMOS CONTRATOS");
		// Insercción contratos.
		contractService.insertContract(contract1);
		contractService.insertContract(contract2);
		contractService.insertContract(contract3);
		contractService.insertContract(contract4);

		log.info("CONSULTA DE TODOS LOS CLIENTES");
		// Consulta general clientes.
		List<Cliente> clientesList = clientService.searchAll();
		log.info("Muestra todos los clientes: ");
		for (final Cliente cliente : clientesList) {
			System.out.println(cliente.getClientId() + " " + cliente.getName() + " " + cliente.getFirstSurname() + " "
					+ cliente.getSecondSurname() + " " + cliente.getDni());
		}
		
		log.info("CONSULTA DE TODOS LOS CONTRATOS");
		// Consulta general contratos.
		List<Contract> contractsList = contractService.searchAll();
		log.info("Muestra todos los contratos: ");
			System.out.println(contractsList);


		log.info("ELIMINACIÓN DE UN CONTRATO");
		// Eliminamos un contrato.
		contractService.deleteContract(contract2);
		
		
		log.info("ACTUALIZACIÓN DE CLIENTE");
		// Aztualizar cliente.
		cliente4.setSecondSurname("De la Rosa");
		clientService.updateClient(cliente4);

		log.info("CONSULTA POR NOMBRE Y APELLIDOS");
		// Consulta por nombre y apellidos.
		Cliente searchBySurnamesAndName = clientService.searchByFullName("Daniel", "García", "De la Rosa");
		System.out.println("Consulta por nombre y apellidos");
		System.out.println(searchBySurnamesAndName);

		
//		log.info("ELIMINACIÓN DE CLIENTE");
//		// Eliminamos un cliente.
//		clientService.deleteClient(cliente3);


		log.info("CONSULTAMOS CLIENTE POR ID");
		// Consulta cliente por id.
		Cliente searchId = clientService.searchById((long) 4);
		System.out.println(searchId);

		log.info("ACTUALIZACIÓN DE CONTRATO");
		// Aztualizar contrato.
		contract1.setMonthlyPrice(12);
		contractService.updateContract(contract1);
		
		log.info("CONSULTAMOS CONTRATO POR ID DE CLIENTE");
		// Consulta contrato por id de cliente.
		Contract searchByClientId  = contractService.searchByClientId((long) 1);
		System.out.println(searchByClientId);
		
		log.info("CONSULTAMOS CONTRATO POR ID");
		// Consulta contrato por id.
		Contract searchById  = contractService.searchById((long) 5);
		System.out.println(searchById);
		
		// Cierre de sesión.
		session.close();

		log.info("FIN DE TRAZA");
	}
}