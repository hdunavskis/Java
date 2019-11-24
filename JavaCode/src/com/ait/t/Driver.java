package com.ait.t;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver{
	
	public void t (int x, int y) {
		try {
			if(x > y) {
				System.out.println("test");
			}
		}catch(ArithmeticException e) {
			e.printStackTrace();
		}catch(Exception t) {
			t.printStackTrace();
		}
	}

	public static void main(String[]args) throws ParseException, InterruptedException {
		/*
		 * DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); // format for the
		 * date string Date date = formatter.parse("29/10/19"); // create the Date
		 * 
		 * C c = new C(); System.out.println(c.getDate());
		 */
		
		//Thread.sleep(2000);
		
		//System.out.println(c.getDate());
		
	
		
	}

}
