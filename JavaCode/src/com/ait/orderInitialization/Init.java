package com.ait.orderInitialization;

public class Init {
	
	
	
	Init(int x){
		System.out.println("1 - arg const");
	}
	Init(){
		System.out.println("no arg const");
	}
	{
		System.out.println("1st instance init");
		System.out.println("2st instance init");
	}
	static {
		System.out.println("1nd static init");
	}
	
	public static void main(String[] args) {
		new Init();
		new Init(7);
	}
	static {
		System.out.println("2nd static init");
	}
}
