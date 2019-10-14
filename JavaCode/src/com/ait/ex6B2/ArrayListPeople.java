package com.ait.ex6B2;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPeople {
	
	static Scanner sc = new Scanner(System.in);
	public static void add(ArrayList<Person> p) {
		
		String name;
		int age;
		
		System.out.println("Enter the persons name --> ");
		name = sc.next();

		System.out.println("Enter the persons age --> ");
		age = sc.nextInt();
		
		if(personThereAlready(p,name) != -1) {	
			Person per = new Person(age, name);

			p.add(per);
			whatWouldYouLikeToDo();
		}
		else {
			System.out.println(name + " is already in the list...");
			whatWouldYouLikeToDo();
		}
		
	}
	public static int  personThereAlready(ArrayList<Person> p, String name) {
		
		for(int i = 0; i < p.size(); i++) {
			if(p.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
	public static void display(ArrayList<Person>p) {
		
		p.forEach(r -> System.out.println(r.toString()));
		whatWouldYouLikeToDo();
	}
	public static void update(ArrayList<Person>p) {
		
		System.out.println("Enter the persons name you wish to change --> ");
		for (Person person : p) {
			if(person.getName().equalsIgnoreCase(sc.next())) {
				System.out.println("Enter new name -->");
				person.setName(sc.next());
				System.out.println("Enter new age -->");
				person.setAge(sc.nextInt());
				System.out.println("The updated persons list : " + person.toString());
			}
		}
		whatWouldYouLikeToDo();
	}
	public static void whatWouldYouLikeToDo() {
		System.out.println("What do you want to do?\n");
	}
	public static void deletePerson(ArrayList<Person> p) {
		
		System.out.println(p);
		System.out.println("Enter the persons name you wish to delete -->");
		final String name = sc.next();
		
		if (personThereAlready(p, name) != -1) {
			p.removeIf(obj -> obj.getName().equalsIgnoreCase(name));
		}
		whatWouldYouLikeToDo();
	}
	public static void main(String[] args) {
		
		ArrayList<Person> people = new ArrayList<Person>();
		
		int userInput = 0;
		
		String message = "";
		message += "1. Add\n";
		message += "2. Update\n";
		message += "3. Delete a person\n";
		message += "4. Delete everyone\n";
		message += "5. Find a person\n";
		message += "6. Display\n";
		message += "7. Exit";
		
		System.out.println("People Register\n");
		while(userInput != 7) {
			
			System.out.println(message);
			userInput = sc.nextInt();
			
			if(userInput == 1) {
				add(people);
			}
			else if(userInput == 2) {
				update(people);
			}
			else if(userInput == 3) {
				deletePerson(people);
			}
			else if(userInput == 4) {
				
			}
			else if(userInput == 5) {
				
			}
			else if(userInput == 6) {
				display(people);
			}
		}
		
		people.forEach(obj -> System.out.println(obj));
	}

}
