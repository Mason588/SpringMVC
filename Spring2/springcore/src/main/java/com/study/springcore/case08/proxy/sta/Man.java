package com.study.springcore.case08.proxy.sta;

import org.w3c.dom.ls.LSOutput;

public class Man implements Person{

	
	
	
	@Override
	public void work() {
		//公用邏輯(之前要做的準備)
		System.out.println("Wear Face Mask");
		//業務邏輯
		System.out.println("Go Work");
		//業務邏輯 - 有例外發生
		System.out.println(10/0);
		//公用邏輯(例外)
		System.out.println("If no Face Mask, You must buy a Wear Face Mask");
		//公用邏輯(之後要做的處理)
		System.out.println("Take off  Mask");
		
	}

}
