package com.nttdata;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;
import com.nttdata.services.OrderServiceI;
import com.nttdata.services.ProductServiceI;

/**
 * Formación - Spring - Taller2
 * 
 * Clase principal
 * 
 * @author NTT Data Sevilla
 *
 */

@SpringBootApplication
public class NTTDataMain implements CommandLineRunner {

	/** LOGGER **/
	final Logger log = LoggerFactory.getLogger("salida");

	/** SERVICES **/
	// Servicio de pedido península
	@Autowired
	@Qualifier("orderInPeninsula")
	private OrderServiceI orderInPeninsula;
	// Servicio de pedido fuera península
	@Autowired
	@Qualifier("orderNotInPeninsula")
	private OrderServiceI orderNotInPeninsula;
	// Servicio de producto
	@Autowired
	private ProductServiceI productService;

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

		log.info("PRIMERA TRAZA");

		log.info("GENERAMOS PRODUCTOS");
		Product product1 = productService.createProduct(1001L, "Cargador Móvil", 29.99);
		Product product2 = productService.createProduct(1002L, "iPhone XS", 350.00);
		Product product3 = productService.createProduct(1003L, "Camiseta Sevilla FC 22/23", 75.00);
		Product product4 = productService.createProduct(1004L, "Botas Fútbol Sala", 39.99);
		Product product5 = productService.createProduct(1005L, "Balón Fútbol Sala", 10.8);

		log.info("GENERAMOS LISTAS DE PRODUCTOS");
		List<Product> apple = new ArrayList<>();
		List<Product> football = new ArrayList<>();

		log.info("AÑADIMOS PRODUCTOS A LAS LISTAS");
		apple.add(product1);
		apple.add(product2);

		football.add(product3);
		football.add(product4);
		football.add(product5);

		log.info("GENERAMOS PEDIDOS");
		Order order1 = orderInPeninsula.makeAnOrder(001L, "Pedro", "Albacete");
		Order order2 = orderNotInPeninsula.makeAnOrder(002L, "Julio", "Ceuta");

		log.info("INSERTAMOS LISTA DE PRODUCTOS EN LOS PEDIDOS");
		orderInPeninsula.addProductToAnOrder(order1, apple);
		orderNotInPeninsula.addProductToAnOrder(order2, football);

		log.info("IMPRIMIMOS LOS DATOS DE LOS PEDIDOS");
		log.info("Desglose de pedidos:");
		log.info("Pedido1");
		orderInPeninsula.breakdownOrder(order1);
		log.info("Pedido2");
		orderNotInPeninsula.breakdownOrder(order2);
		log.info("FINAL TRAZA");

	}

}
