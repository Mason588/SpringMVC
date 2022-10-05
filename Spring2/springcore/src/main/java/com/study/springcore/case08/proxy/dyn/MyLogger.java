package com.study.springcore.case08.proxy.dyn;

import java.util.Arrays;

//Aspect 切面程式 
public class MyLogger {
	//前置通知
	public static void before(Class cls,String methodName,Object[] args) {
		System.out.printf("Before Info %s %s %s\n", cls, methodName, Arrays.toString(args));
	}
	//異常通知
	public static void throwing(Class cls,String methodName,Exception errMessage) {
		System.out.printf("Error Info %s %s %s\n", cls, methodName, errMessage);
		//想看更細部的錯誤
		errMessage.printStackTrace(System.err);
	}
	
	//後置通知
	public static void end(Class cls,String methodName,Object result) {
		System.out.printf("After Info %s %s %s\n", cls, methodName, result);
	}
}
