package com.study.springcore.case02;

public class LifeCycle {
	public LifeCycle() {
		System.out.println("LifeCycle() Constructor :The prepare task before file open, fileName? path=?" );
	}
	
	public void init() {
		System.out.println("init() Method");
	}
	
	public void service() {
		System.out.println("service () business Logic Method: Read File");
		System.out.println("service () business Logic Method: Anaylyze File");
		System.out.println("service () business Logic Method: Make a strategic decision  File");
		System.out.println("service () business Logic Method: File Write...");
	}
	public void destroy() {
		System.out.println("destroy() Method : Close File...");
	}
}
