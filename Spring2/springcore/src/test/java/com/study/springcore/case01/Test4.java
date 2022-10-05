package com.study.springcore.case01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
			
		CPU cpu3 = ctx.getBean("cpu3", CPU.class);
		CPU cpu4 = ctx.getBean("cpu4", CPU.class);
		CPU cpu5 = ctx.getBean("cpu5", CPU.class);
		CPU cpu6 = ctx.getBean("cpu6", CPU.class);
		
		RAM ram1 = ctx.getBean("ram1", RAM.class);
		RAM ram2 = ctx.getBean("ram2", RAM.class);
		RAM ram3 = ctx.getBean("ram3", RAM.class);
		RAM ram4 = ctx.getBean("ram4", RAM.class);
		
		HD hd1= ctx.getBean("hd1", HD.class);
		HD hd2= ctx.getBean("hd2", HD.class);
		HD hd3= ctx.getBean("hd3", HD.class);
		
		//DIY 自組電腦
		Computer computer = ctx.getBean("computer", Computer.class);
		computer.setCpu(cpu6);
		computer.setRam(ram3);
		computer.setHd(hd3);
		System.out.println(computer);

		//品牌電腦
		Computer acer = ctx.getBean("acer", Computer.class);
		System.out.println(acer);
		Computer ibm = ctx.getBean("ibm", Computer.class);
		System.out.println(ibm);
		
		//電腦陣列
		//List<Double> computers =  Arrays.asList(computer.getPrice(), acer.getPrice(), ibm.getPrice());
		Computer [] computers = {computer, acer, ibm};
		//總價
		double sum=0;
		for(Computer com: computers)
		{
			sum += com.getPrice();
		}
		System.out.println("$ "+ sum);
		
		//用lambda 結合Stream語法
		//double sum = computers.stream().reduce((double) 0, Double::sum);
//		double sum =Arrays.stream(computers).mapToDouble(Computer::getPrice).sum();
//		System.out.println("$ " + sum);
			
	}

}
