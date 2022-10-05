package com.study.springcore.case01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CPU cpu = ctx.getBean("cpu1", CPU.class);
		cpu.setGhz(2.8);
		
		CPU cpu2 = ctx.getBean("cpu2", CPU.class);
		cpu2.setGhz(3.1);
		
		CPU cpu3 = ctx.getBean("cpu3", CPU.class);
		
		CPU cpu4 = ctx.getBean("cpu4", CPU.class);
		
		CPU cpu5 = ctx.getBean("cpu5", CPU.class);
		
		CPU cpu6 = ctx.getBean("cpu6", CPU.class);
		
		System.out.println(cpu.getGhz());
		System.out.println(cpu2.getGhz());
		System.out.println(cpu3.getGhz());
		System.out.println(cpu4.getGhz());
		System.out.println(cpu5.getGhz());
		System.out.println(cpu6.getGhz());
	}

}
