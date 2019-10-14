package com.ait.arrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSample {

	public static void arrayListStringLiterals() {
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Zoe");
		names.add("Paul");
		names.add("Alan");
		names.add("Thomas");
		
		for (String n : names) {
			System.out.println(n);
		}
	}
	public static void arrayListStringFromScanner() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		int timesToLoop = 4;
		
		for (int i = 0; i < timesToLoop; i++) {
			System.out.println("Enter a ame to be added --> ");
			names.add(sc.next());
		}

		System.out.println(names.toString());
	}
	public static void arrayListStringsWithLoop() {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<String>();
		String userInput= " ";
		
		while(!userInput.equalsIgnoreCase("x")) {
			
			System.out.println("Enter a name to be added ('x' to exit) -->");
			userInput = sc.next();
			
			if(!userInput.equalsIgnoreCase("x")){
				names.add(userInput);
			}
		}

		for (String n : names) {
			System.out.println("The name is " + n);
		}
	}
	public static void arrayListInteger() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>(3);
		int userInput = 0;
		
		while(userInput != -1) {
			
			System.out.println("Enter an integer to be added (-1 to exit) -->");
			userInput = sc.nextInt();
			
			if(userInput != -1){
				numbers.add(userInput);
			}
		}

		System.out.println(numbers.toString());
		for (int n : numbers) {
			System.out.println("The number is s" + n);
		}
	}
	public static void arrayListPerson() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> people = new ArrayList<Person>();
		char userInput = ' ';
		
		
		while(Character.toLowerCase(userInput) != 'n') {
			Person p = new Person();
			
			System.out.println("Enter name --> ");
			p.setName(sc.next());
			
			System.out.println("Enter address --> ");
			p.setAddress(sc.next());
			
			System.out.println("Enter age --> ");
			p.setAge(sc.nextInt());
			
			people.add(p);
			System.out.println("Would you wish to create more people (y/n)?");
			userInput = sc.next().charAt(0);
		}
		
		for (Person person : people) {
			System.out.println(person.toString());
		}
		
	}
	public static void main(String[] args) {
		//arrayListStringLiterals();
		//arrayListStringFromScanner();
		//arrayListStringsWithLoop();
		//arrayListInteger();
		arrayListPerson();
	}

}
