package com.study.springcore.case03;

public class Product {
	private Double price;
	private Double discount;
	
	public Product() {}
	
	public Product(Double price, Double discount) {
		this.price = price;
		this.discount = discount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		if(this.discount > 0) {
			this.price = price * this.discount;
		}
		
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Product [price=" + price + ", discount=" + discount + "]";
	}
	
	
}
