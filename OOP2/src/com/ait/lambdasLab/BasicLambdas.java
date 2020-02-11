package com.ait.lambdasLab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {
	
	public void consumer() {
		Printable<String> printable = new Printable<String>() {
			
			@Override
			public void print(String s) {
				System.out.println(s);
				
			}
		};
		printable.print("test");
		
		
		Printable<String> printable2 = print -> System.out.println(print);
		printable2.print("TestLambda");
		
		Consumer<String> consumer = System.out::println;
		consumer.accept("consumer");
	}
	
	public void supplier() {
		Retrievable<Integer> retrievable = new Retrievable<Integer>() {
			
			@Override
			public Integer retrieve() {
				return 77;
			}
		};
		System.out.println(retrievable.retrieve());
		
		Retrievable<Integer> ret = () -> new Integer(77);
		System.out.println(ret.retrieve());
		
		Supplier<Integer> supp = () -> new Integer(77);
		System.out.println(supp.get());
		
		
	}
	public void predicate() {
		Evaluate<Integer> evaluate = new Evaluate<Integer>() {
			
			@Override
			public boolean checkINegative(Integer t) {
				
				return t > 0;
			}
		};
		System.out.println(evaluate.checkINegative(-1));
		System.out.println(evaluate.checkINegative(1));
		
		Evaluate<Integer> ev = e -> e > 0;
		System.out.println(ev.checkINegative(-1));
		System.out.println(ev.checkINegative(1));
		
		Predicate<Integer> predicate = p -> p > 0;
		System.out.println(predicate.test(-1));
		System.out.println(predicate.test(1));
	}
	public void function() {
		Function<Integer, String> function = new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				
				return "test " + Integer.toString(t);
			}
			
		};
		System.out.println(function.apply(5));
		
		Function<Integer, String> fun = f -> "test " + Integer.toString(f);
		System.out.println(fun.apply(5));
		
		Function<Integer, String> ff = f -> "test " + Integer.toString(f);
		System.out.println(ff.apply(5));
	}
	private static List<Person> getPeople(){
		Person p = new Person(21, "name", 6.3);
		Person p1 = new Person(15, "name2", 6.1);
		Person p2 = new Person(3, "name1", 6.4);
		Person p3 = new Person(50, "name3", 6.2);
		List<Person> pList = new ArrayList<>();
		pList.add(p);
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		return pList;
	}
	private static void sortAge(List<Person> listOfPeople) {
		System.out.println("Before sort");
		
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
		
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getAge().compareTo(o2.getAge());
			}
		};
		Collections.sort(listOfPeople, comparator);
		System.out.println("\nAfter sort");
		
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
	}
	private static void sortName(List<Person> listOfPeople) {
		System.out.println("Before sort");
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
		
		Comparator<Person> comparator = new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				
				return o1.toString().compareTo(o2.toString());
			}
		};
		Collections.sort(listOfPeople, comparator);
		System.out.println("\nAfter sort");
		
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
		
	}
	private static void sortHeight(List<Person> listOfPeople) {
		System.out.println("Before sort");
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
		
		Comparator<Person> comparator = new Comparator<Person>() {
			
			@Override
			public int compare(Person o1, Person o2) {
				
				return o1.getHeight().compareTo(o2.getHeight());
			}
		};
		Collections.sort(listOfPeople, comparator);
		System.out.println("\nAfter sort");
		
		for (Person person : listOfPeople) {
			System.out.println(person.toString());
		}
		
	}
	private static void sortAgeUsingLambdas(List<Person> listOfPeople) {
		System.out.println("Before sorting");
		
		listOfPeople.forEach(p -> System.out.println(p));
		
		listOfPeople.sort((person1, person2) -> person1.getAge().compareTo(person2.getAge()));
		
		System.out.println("\nAfter sort");
		listOfPeople.forEach(p -> System.out.println(p));
	}
	private static void sortNameUsingLambdas(List<Person> listOfPeople) {
		System.out.println("Before sorting");
		
		listOfPeople.forEach(p -> System.out.println(p));
		
		listOfPeople.sort((person1, person2) -> person1.toString().compareTo(person2.toString()));
		
		System.out.println("\nAfter sort");
		listOfPeople.forEach(p -> System.out.println(p));
	}
	private static void sortHeightUsingLambdas(List<Person> listOfPeople) {
		System.out.println("Before sorting");
		
		listOfPeople.forEach(p -> System.out.println(p));
		
		listOfPeople.sort((person1, person2) -> person1.getHeight().compareTo(person2.getHeight()));
		
		System.out.println("\nAfter sort");
		listOfPeople.forEach(p -> System.out.println(p));
	}
	public static void main(String[] args) {
	
		List<Person> listPeople;
		//new BasicLambdas().consumer();
		//new BasicLambdas().supplier();
//		new BasicLambdas().predicate();
		//new BasicLambdas().function();
		listPeople = new ArrayList<Person>(getPeople());
		
		//sortAge(listPeople);
		//sortName(listPeople);
		//sortHeight(listPeople);
		//sortAgeUsingLambdas(listPeople);
		//sortNameUsingLambdas(listPeople);
		sortHeightUsingLambdas(listPeople);
	}

}
