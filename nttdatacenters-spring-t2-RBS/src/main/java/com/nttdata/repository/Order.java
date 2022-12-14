package com.nttdata.repository;

import java.util.List;

/**
 * Formación - Spring - Taller2
 * 
 * Clase Pedido
 * 
 * @author NTT Data Sevilla
 *
 */

public class Order {

	/** Identificador */
	protected Long orderId;

	/** Destinatario */
	protected String addressee;

	/** Direccion de entrega */
	protected String orderAddress;

	/** Indicador Peninsula o Islas */
	protected boolean inPeninsula;

	/** Lista de productos */
	protected List<Product> productList;

	/**
	 * @return the orderId
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the addressee
	 */
	public String getAddressee() {
		return addressee;
	}

	/**
	 * @param addressee the addressee to set
	 */
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	/**
	 * @return the orderAddress
	 */
	public String getOrderAddress() {
		return orderAddress;
	}

	/**
	 * @param orderAddress the orderAddress to set
	 */
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	/**
	 * @return the inPeninsula
	 */
	public boolean isInPeninsula() {
		return inPeninsula;
	}

	/**
	 * @param inPeninsula the inPeninsula to set
	 */
	public void setInPeninsula(boolean inPeninsula) {
		this.inPeninsula = inPeninsula;
	}

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Order\norderId=" + orderId + "\naddressee=" + addressee + "\norderAddress=" + orderAddress
				+ "\ninPeninsula=" + inPeninsula + "\nproductList=" + productList + "\n";
	}

}
