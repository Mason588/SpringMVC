package com.study.springcore.case08.proxy.dyn;

public class CalcImpl implements Calc{

	@Override
	public int add(int x, int y) {
		int result = x+y;
		return result;
	}

	@Override
	public int div(int x, int y) {
		int result = x/y;
		return result;
	}

}
