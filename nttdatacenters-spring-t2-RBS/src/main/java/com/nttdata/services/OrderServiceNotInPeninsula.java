package com.nttdata.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.repository.Order;
import com.nttdata.repository.Product;

/**
 * Formación - Spring - Taller2
 * 
 * Servicio Pedido Península (Implementación)
 * 
 * @author NTT Data Sevilla
 *
 */

@Service("orderNotInPeninsula")
public class OrderServiceNotInPeninsula implements OrderServiceI {

	@Override
	public Order makeAnOrder(Long orderId, String addressee, String orderAddress) {
		// Crear pedido
		Order newOrder = new Order();
		newOrder.setOrderId(orderId);
		newOrder.setAddressee(addressee);
		newOrder.setOrderAddress(orderAddress);
		newOrder.setInPeninsula(false);

		return newOrder;
	}

	@Override
	public void addProductToAnOrder(Order order, List<Product> products) {
		// Agregar producto a pedido
		order.setProductList(products);

	}

	@Override
	public void breakdownOrder(Order order) {
		// Desglosar pedido
		String breakdown = order.toString();
		double totalPrice = calculateTotalPrice(order);
		System.out.println(breakdown + "\nImporte total del pedido: " + totalPrice + "\n");

	}

	@Override
	public double calculatePricePVP(Product product) {
		// Calcular precio PVP producto
		return product.getPriceExcludingTax() * 0.04 + product.getPriceExcludingTax();
	}

	@Override
	public double calculateTotalPrice(Order order) {
		// Calcular precio total pedido
		Double totalPrice = 0.0;
		double pricePVP;
		for (Product product : order.getProductList()) {
			pricePVP = product.getPriceExcludingTax() * 1.04;
			product.setPricePVP(pricePVP);
			totalPrice += pricePVP;
		}
		return totalPrice;
	}

}
