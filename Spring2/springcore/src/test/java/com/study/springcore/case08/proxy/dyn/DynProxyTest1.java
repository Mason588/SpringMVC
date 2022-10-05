package com.study.springcore.case08.proxy.dyn;

import org.springframework.objenesis.instantiator.sun.MagicInstantiator;

import com.study.springcore.case08.proxy.sta.Person;
import com.study.springcore.case08.proxy.sta.Woman;

public class DynProxyTest1 {

	public static void main(String[] args) {
		Person woman = (Person) new DynProxy(new Woman()).getProxy();
		woman.work();
		
		Calc calc =(Calc)new DynProxy(new CalcImpl()).getProxy();
		System.out.println(calc.add(10, 20));

	}

}
