package com.study.springcore.case08.proxy.sta;

public class ProxyTest {
	public static void main(String[] args) {
		Person man = new PersonProxy(new Man());
		Person women = new PersonProxy(new Woman());
		
		man.work();
		women.work();
		
	} 
}
