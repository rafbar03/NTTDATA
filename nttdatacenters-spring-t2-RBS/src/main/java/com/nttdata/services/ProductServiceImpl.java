package com.nttdata.services;

import org.springframework.stereotype.Service;

import com.nttdata.repository.Product;

/**
 * Formación - Spring - Taller2
 * 
 * Servicio Producto (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

@Service("productService")
public class ProductServiceImpl implements ProductServiceI {

	@Override
	public Product createProduct(Long productId, String name, Double priceExcludingTax) {
		// Crear Producto
		Product newProduct = new Product();
		newProduct.setProductId(productId);
		newProduct.setName(name);
		newProduct.setPriceExcludingTax(priceExcludingTax);

		return newProduct;
	}

}
