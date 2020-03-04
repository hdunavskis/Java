package com.ait.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {	
	int year;
	int month;
	int day;
	double value;
	

	public Driver(int year, int month, int day, double value) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.value = value;
	}


	public static void main(String[] args) {
		List<Driver> d = Arrays.asList(
				new Driver(2017, 1,1,405.91),
				new Driver(2017, 1,8,405.98),
				new Driver(2017, 1,1,406.14),
				new Driver(2017, 1,1,406.48),
				new Driver(2017, 1,1,406.20),
				new Driver(2017, 1,1,406.03)
				);
		
		d.sort((r1, r2) -> r1.value < r2.value?-1:1);
		
		d.forEach(r -> System.out.println(r.value));
	}

}
