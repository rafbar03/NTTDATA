package com.nttdata.repository;

/**
 * Formación - Spring - Taller2
 * 
 * Clase Producto
 * 
 * @author NTT Data Sevilla
 *
 */

public class Product {

	/** Identificador */
	protected Long productId;

	/** Nombre */
	protected String name;

	/** Precio PVP */
	protected double pricePVP;

	/** Precio sin impuestos */
	protected double priceExcludingTax;

	
	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the pricePVP
	 */
	public double getPricePVP() {
		return pricePVP;
	}

	/**
	 * @param pricePVP the pricePVP to set
	 */
	public void setPricePVP(double pricePVP) {
		this.pricePVP = pricePVP;
	}

	/**
	 * @return the priceExcludingTax
	 */
	public double getPriceExcludingTax() {
		return priceExcludingTax;
	}

	/**
	 * @param priceExcludingTax the priceExcludingTax to set
	 */
	public void setPriceExcludingTax(double priceExcludingTax) {
		this.priceExcludingTax = priceExcludingTax;
	}

	@Override
	public String toString() {
		return "\nproductId=" + productId + ", name=" + name + ", priceExcludingTax=" + priceExcludingTax + "";
	}
	
	
}
