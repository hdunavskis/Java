package com.ait.t;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
	
	public static void main(String[]args) throws ParseException, InterruptedException {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); // format for the date string
		Date date = formatter.parse("29/10/19"); // create the Date

		C c = new C();
		System.out.println(c.getDate());
		
		Thread.sleep(2000);
		
		System.out.println(c.getDate());
	}

}
