package com.ait.inheritance;

public class Paper extends Product{
	private String author;
	private String t;
	
	public Paper(){
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
	@Override
	public String getT() {
		return "Paper getT()";
	}

}
