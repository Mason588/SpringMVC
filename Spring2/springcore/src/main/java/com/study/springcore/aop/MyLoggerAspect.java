package com.study.springcore.aop;

import java.util.Arrays;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //數字越小越先執行(預設是 int的最大值)

public class MyLoggerAspect {
	//PointCut切入點,用來定義 JointPoint連接點
	@Pointcut(value="execution(* com.study.springcore.aop.CalcImpl.add(..))")
	public void pt() {
		
	}
	@Pointcut(value="execution(* com.study.springcore.aop.CalcImpl.div(..))")
	public void pt2() {
		
	}

	
	//前置通知: 運行在目標方法執行之前
	//要定義哪一個方法
	/*
	@Before(value ="pt()") //切入點表達式支援: &&、||、! 例如:pt() && !pt2() 
	public void before(JoinPoint joinpoint) {
		System.out.printf("%s %s %s\n" ,
						  "Before Info...", 
						   joinpoint.getSignature().getName(), 
						   Arrays.toString(joinpoint.getArgs()));
	}
	
	//後置通知: 不論目標方法是否有例外發生都會執行(會放在finally 中)
	@After(value="pt2()")
	public void after() {
		System.out.println("After info");
	}
	
	//返回通知: 可以在切面程式中得到目標方法的回傳值
	@AfterReturning(value="pt2()", returning="result")
	public void afterReturning(Object result) {
		System.out.println("return info");
	}
	
	//異常通知 : 可知道目標方法所發生的錯誤為何
	@AfterThrowing(value="pt2()", throwing="ex")
	public void AfterThrowing(Exception ex){
		System.out.println("error - ex = " + ex);
	}
	*/
	//環繞通知
	@Around(value="pt2() || pt()")
	public Object around(ProceedingJoinPoint joinpoint) {
		Object result = null;
		//1.前置通知
		System.out.println("surround info-before info");
		
		try {
			//2. 執行業務邏輯方法
			result = joinpoint.proceed();
			//3. 返回通知
			System.out.println("surround info:return info result="+result);
		} catch(Throwable e) {
			//4. 異常通知
			System.out.println("surround info:error info result="+e);
		} finally {
			//5. 後置通知
			System.out.println("surround after info result="+result);
		}
		return result;
	}
}
