package com.study.springcore.jdbc;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.study.springcore.aop.Calc;
import com.study.springcore.jdbc.template.EmpDao;

public class TemplateTest1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc-config.xml");
		EmpDao empdao = ctx.getBean("empDao", EmpDao.class);
		System.out.println(empdao.queryAll());
		
		//如何取得 eid=2 的員工姓名 ? (請使用 java 8 stream)
		List<Map<String,Object>>emps = empdao.queryAll();
		String ename = emps.stream()
					   .filter( e-> (e.get("eid")+"").equals("3"))
					   .findFirst()
					   .get().get("ename")+ "";
		System.out.println(ename);	
		
		//多筆查詢II
		System.out.println(empdao.queryListEmps());
		
		//多筆查詢III
		System.out.println(empdao.queryListEmps2());
				
		
	}

}
