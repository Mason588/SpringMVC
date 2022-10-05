package com.study.springcore.case08.proxy.sta;

// Person靜態代理
public class PersonProxy implements Person{
	//被代理物件
	private Person person;
	
	public PersonProxy(Person person) {
		this.person = person;
	}
	@Override
	public void work() {
		//公用邏輯-前
		System.out.println("Wear Face Mask");
		try {
				person.work();
			}catch(Exception e) {
				//公用邏輯 - 例外發生
				System.err.println("Buy Face Mask");
				System.err.println("Wear Face Mask again");
			}
	
		//公用邏輯 - 後
		System.out.println("Take off Face Mask");
	}

}
