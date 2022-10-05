package com.study.springcore.case08.proxy.cglib;

// Enhancer 增強型的 Customer
public class EnhancerCustomer extends Customer {
	@Override
	public String buy(String data) {
		return super.buy(" "+data) + " Please show id!";
	}

}
