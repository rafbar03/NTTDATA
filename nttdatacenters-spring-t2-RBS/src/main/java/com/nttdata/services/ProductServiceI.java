package com.nttdata.services;

import com.nttdata.repository.Product;

/**
 * Formación - Spring - Taller2
 * 
 * Servicio Producto (Interfaz)
 * 
 * @author NTT Data Sevilla
 *
 */

public interface ProductServiceI {

	/**
	 * Crear producto.
	 * 
	 * @param productId
	 * @param name
	 * @param priceExcludingTax
	 */
	public Product createProduct(Long productId, String name, Double priceExcludingTax);
}
