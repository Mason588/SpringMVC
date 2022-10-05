package com.study.springcore.case01;

public class CPU {
	private Double ghz;
	
	
	
	public CPU() {
		System.out.println("Create CPU Object");
	}
	
	public CPU(Double ghz) {
		this.ghz = ghz;
	}

	public Double getGhz() {
		return ghz;
	}

	public void setGhz(Double ghz) {
		this.ghz = ghz;
	}

	@Override
	public String toString() {
		return "CPU [ghz=" + ghz + "]";
	}
	
	
	
	
}
