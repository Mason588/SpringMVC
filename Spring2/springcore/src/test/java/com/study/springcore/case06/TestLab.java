package com.study.springcore.case06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.case06.RoundImpl;

public class TestLab {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext6.xml");
		 RoundImpl circleArea = ctx.getBean("roundBean", RoundImpl.class);
		 System.out.println(circleArea.getRoundArea());
	}

}
