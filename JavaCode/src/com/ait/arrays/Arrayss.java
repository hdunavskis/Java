package com.ait.arrays;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.text.StyleContext.SmallAttributeSet;

public class Arrayss {

	static Scanner sc = new Scanner(System.in); 
	public static void exercise() {
		int[] a = {10,20,30,40,50};
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		for (int i : a) {
			System.out.println(i);
		}
	}
	public static void exercise2() {
		
		int[] a = new int[5];
		
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Enter a value -->");
			a[i] = sc.nextInt();
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		for (int i : a) {
			System.out.println(i);
		}
		
	}
	public static void histogram() {
		int[] a = {19,3,15,7,11,9,13,5,17,1};
		
		System.out.println("Element\tValue\tHistogram");
		for (int i = 0; i < a.length; i++) {
			
			System.out.print(i + "\t");
			System.out.print(a[i] + "\t");
			while(a[i] != 0) {
				System.out.print("*");
				a[i]--;
			}
			System.out.println();
		}
	}
	public static void dynamicHistogram() {

		int numberOfElements = 0;
		
		System.out.println("How many elements in array? ");
		numberOfElements = sc.nextInt();
		
		int[] a = new int[numberOfElements];
		
		for (int i = 0; i < a.length; i++) {
			System.out.println("Please enter a value --> ");
			a[i] = sc.nextInt();
				
		}
		
		System.out.println("Element\tValue\tHistogram");
		
		for (int i = 0; i < a.length; i++) {
			
			System.out.print(i + "\t");
			System.out.print(a[i] + "\t");
			while(a[i] != 0) {
				System.out.print("*");
				a[i]--;
			}
			System.out.println();
		}
	}
	public static void frequency() {
		int[] a = {1,2,6,4,8,5,9,7,8,10,1,6,3,8,6,10,3,8,2,7};
		int[] f = new int[11];
		int count = 1;
		int number = 0;

		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			number = a[i];
			for (int j = i+1; j < a.length; j++) {

				if(a[i] != a[j]){
					i = j-1;
					break;
				}
				count++;
			}
			if(f[number] == 0) {
				f[number] = count;
			}

			count = 1;
		}


		System.out.println("Raiting\tFrequency");
		for (int i = 1; i < f.length; i++) {
			System.out.println(i + "\t"+ f[i]);
		}
	}
	public static void multiDimArray() {
		// {} number of columns. 1,2,3 - values in rows
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }};

		System.out.println("Values of array are : ");
		//ctrl+shift+f = format ctrl + i = indent
		/*
		 * for (int i = 0; i < array.length; i++) { for (int j = 0; j < array.length;
		 * j++) {
		 * 
		 * System.out.print(array[i][j]); } System.out.println(); }
		 */ 
		
		for(int[] row: array) {
			System.out.println(Arrays.toString(row));
		}
		// System.out.println(Arrays.deepToString(array));
	}
	public static void studentGrades() {
		
		int[][] studentGrades = {{77,68,86,73},{96,87,89,78},{70,90,86,81}};
		int lowest = studentGrades[0][0];
		int highest = studentGrades[0][0];
		double sum = 0;
		int count = 0;
		double averageFirst = 0;
		double averageSecond = 0;
		double averageThird = 0;
		
		
		System.out.println("The array is ");
		System.out.print("\t\t\t");
		for(int i = 0; i <= studentGrades.length; i++) {
			System.out.print("["+i+"]\t");
		}
		System.out.println("\n");
		for (int i = 0; i < studentGrades.length; i++) {
			System.out.print("stundetGrades[" + i + "]\t");
			for (int j = 0; j <= studentGrades.length; j++) {
				System.out.print(studentGrades[i][j] + "\t");
				
				if(studentGrades[i][j] > highest) {
					highest = studentGrades[i][j];
				}
				else if(studentGrades[i][j] < lowest) {
					lowest = studentGrades[i][j];
				}
				sum += studentGrades[i][j];
				count++;
			}
			if(i == 0) {
				averageFirst = sum / count;
				sum = 0;
				count = 0;
			}
			else if(i == 1) {
				averageSecond = sum / count;
				sum = 0;
				count = 0;
			}
			else {
				averageThird = sum / count;
			}
			System.out.println();
		}
		System.out.println("\nThe lowest grade is " + lowest);
		System.out.println("The highest grade is " + highest);
		System.out.println("The average for the first student is " + averageFirst);
		System.out.println("The average for the second student is " + averageSecond);
		System.out.println("The average for the third student is " + averageThird);
		
	}
	public static void statistics() {
		int array1[] = {9,3,44,17,15};
		int array2[] = {8,-6,89,17,12,6};
		System.out.println("The average is " + average(array1));
		System.out.println("Median value is " + median(array1));
		
		 System.out.println("Range == " + range(array1)); System.out.println();
		 System.out.println("The average is " + average(array2));
		 System.out.println("Median value is " + median(array2));
		 System.out.println("Range == " + range(array2));
	}
	public static int range(int[] a) {
		
		Arrays.sort(a);
		return a[a.length-1] - a[0];
	}
	public static double median(int[]a) {
		
		Arrays.sort(a);
		
		if(a.length % 2 == 0) {
			
			return (double)(a[a.length/2] + a[a.length/2-1])/2;
		}
		return (double) a[a.length/2];
	}
	public static double average(int[] a) {
		double sum = 0;
		
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum / a.length;
	}
	public static void main(String[] args) {
		//exercise();
		//exercise2();
		//histogram();
		//dynamicHistogram();
		//frequency();
		//multiDimArray();
		//studentGrades();
		statistics();
	}

}
