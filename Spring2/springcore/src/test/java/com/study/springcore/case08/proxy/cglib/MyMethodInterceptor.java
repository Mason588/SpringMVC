package com.study.springcore.case08.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Callback;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Please Show id!");
		return proxy.invokeSuper(obj, args);
	}

}
