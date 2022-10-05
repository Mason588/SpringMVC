package com.study.springcore.case02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext2.xml");
		LifeCycle lifeCycle = ctx.getBean("LifeCycle" ,LifeCycle.class );
		//初始方法會自動執行
		lifeCycle.service();
		
		((ClassPathXmlApplicationContext)ctx).close();
	}

}
