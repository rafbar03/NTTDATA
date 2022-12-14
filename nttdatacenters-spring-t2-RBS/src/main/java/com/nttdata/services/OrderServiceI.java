package com.nttdata.services;

import java.util.List;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;

/**
 * Formación - Spring - Taller2
 * 
 * Servicio Pedido (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface OrderServiceI {

	/**
	 * Crear pedido.
	 * 
	 * @param orderId
	 * @param addressee
	 * @param orderAddress
	 */
	public Order makeAnOrder(Long orderId, String addressee, String orderAddress);

	/**
	 * Agregar producto a pedido.
	 * 
	 * @param order
	 * @param products
	 */
	public void addProductToAnOrder(Order order, List<Product> products);

	/**
	 * Desglosar pedido.
	 * 
	 * @param order
	 */
	public void breakdownOrder(Order order);

	/**
	 * Calcular precio PVP producto.
	 * 
	 * @param product
	 */
	public double calculatePricePVP(Product product);

	/**
	 * Calcular precio total pedido.
	 * 
	 * @param order
	 */
	public double calculateTotalPrice(Order order);

}
