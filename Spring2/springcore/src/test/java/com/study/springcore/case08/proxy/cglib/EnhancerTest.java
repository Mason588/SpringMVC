package com.study.springcore.case08.proxy.cglib;

public class EnhancerTest {

	public static void main(String[] args) {
		//使用子類別(加強)來代替
		Customer customer = new EnhancerCustomer();
		System.out.println(customer.buy("bread"));

	}

}
