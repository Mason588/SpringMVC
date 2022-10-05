package com.study.springcore.case08;

import java.time.LocalDate;
import java.time.Period;

public class TestTime {

	public static void main(String[] args) {
		LocalDate StartDate = LocalDate.of(2015,2,20);
		LocalDate endDate = LocalDate.of(2017,1,15);
		
		Period period = Period.between(StartDate, endDate);
		System.out.println("Year:" +period.getYears()
						   +"\nMonths: " + period.getMonths());

	}

}
