package com.ait.inheritance;

public class Product {
	protected static int count = 0;
	private String t;
	public static String pString= "StaticString";
	
	Product(){
		
	}
	public int getC() {
		return count;
	}
	
	protected void setT(String t) {
		this.t = t;
	}
	
	public String getT() {
		return "Product getT()";
	}
	public static String getT(int x) {
		return "Product getT()";
	}
	public int test() {
		return 5;
	}
}
