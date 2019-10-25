package com.ait.inheritance;

public class Book extends Product{
	private String author;
	private String t;
	public static String pString= "BookStatic";
	
	public Book(){
		super();
		author = "";
		count++;
		
	}
	
	
	public void setT(String t) {
		this.t = t;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setAuthor(String author, int t) {
		this.author = author;
	}
	public void setAuthor(int t, String author) {
		this.author = author;
	}
	public double setAuthor(String author, double t) {
		return t;
	}
	@Override
	public String getT() {
		return "Book getT()";
	}
	
}
