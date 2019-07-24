package com.ait.assessment;

import java.util.Scanner;

public class AssessmentTwo {

	static Scanner sc = new Scanner(System.in);
	
	public static void multiplicationTableFor() {
		int number = 0;
		final int timesToLoop = 12;
		System.out.println("Display the multiplication table for?");
		number = sc.nextInt();
		
		for (int i = 1; i <= timesToLoop; i++) {
			System.out.println(number + " X " + i + " = " + (number*i));
		}
	}
	public static void multiplicationTableWhile() {
		int number = 0;
		int i = 1;
		System.out.println("Display the multiplication table for?");
		number = sc.nextInt();
		
		while(i < 13) {
			
			System.out.println(number + " X " + i + " = " + (number*i));
			i++;
		}
	}
	
	public static void oddNumbers() {
		int low = 0;
		int high = 0;
		
		System.out.println("Printing odd numbers!");
		System.out.println("Enter lower imit!");
		low = sc.nextInt();
		System.out.println("Enter upper limit!");
		high = sc.nextInt();
		
		
		for (int i = low; i < high; i++) {
			if(i % 2 == 0) {
				continue;
			}
			else {
				System.out.print(i + " ");
			}
		}
	}
	public static void doWhhile() {
		int low = 0;
		int high = 0;
		
		System.out.println("Printing odd numbers!");
		System.out.println("Enter lower imit!");
		low = sc.nextInt();
		System.out.println("Enter upper limit!");
		high = sc.nextInt();
		
		do {
			System.out.println("Cube of " + low + " is " + (int)Math.pow(low, 3));
			low++;
		}while(low <= high);
	}
	public static void lotteryOdds() {
		int n = 0;
		int k = 0;
		double odds = 1;
		int div = 1;
		
		System.out.println("Calculating Lottery Odds");
		System.out.println("How many numbers do you need to draw? ");
		k = sc.nextInt();
		System.out.println("What is the highest number you can draw? ");
		n = sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			odds *= n-i;
			System.out.println(odds);
			div *=i+1;
		}
		System.out.println(odds / (double)div);
	}
	
	public static void main(String[] args) {
		//multiplicationTableFor();
		//multiplicationTableWhile();
		//oddNumbers();
		//doWhhile();
		lotteryOdds();
	}

}
