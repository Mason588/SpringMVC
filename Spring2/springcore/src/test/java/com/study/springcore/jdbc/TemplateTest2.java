package com.study.springcore.jdbc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.aop.Calc;
import com.study.springcore.jdbc.entity.Emp;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empDao = ctx.getBean("empDao", EmpDao.class);
		int rowcount = 0;
		int[] rowcounts = null;
		
		//測試單筆新增I
		//rowcount = empDao.addOne1("Nio", 23);
		//System.out.println("Test one insert1"+ rowcount);
		//測試單筆新增II
		//rowcount = empDao.addOne2("test2", 20);
		//System.out.println("Test one insert II: "+ rowcount);
		//測試多筆新增 I
		/*List<Object[]> rows = new ArrayList<>();
		rows.add(new Object[] {"Betty",36});
		rows.add(new Object[] {"Pika",3});
		rows.add(new Object[] {"Elsa",32});
		rowcounts = empDao.multiAdd1(rows);
		System.out.println("test multi add I" + Arrays.toString(rowcounts));
		*/
		
		//測試多筆新增 II
		/*List<Emp> emps = new ArrayList<>();
		emps.add(new Emp("Bobo",25));
		emps.add(new Emp("Bob",26));
		emps.add(new Emp("Amy",27));
		rowcounts = empDao.multiAdd2(emps);
		System.out.println("test multi add II: " + Arrays.toString(rowcounts));
		*/
		//測試修改
		/*
		rowcount = empDao.updateById(1, "Tom", 33);
		System.out.println("test-test update I: " + rowcount);
		*/
		//測試刪除
		//rowcount = empDao.deleteById(50);
		//System.out.println("test-test delete I: " + rowcount);
	}
}