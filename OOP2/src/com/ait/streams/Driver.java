package com.ait.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

class Purchase {
	 String item;
	 double price;
	
	public Purchase(String item, double price) {
		this.item = item;
		this.price = price;
	}
}

public class Driver {

	
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(9,10,13,76,8,-9);
		long largerThanTen = numbers
				.stream()
				.filter(n -> n > 10)
				.count();
		System.out.println(largerThanTen);
		
		
		List<String> names = Arrays.asList("Andrew", "Brian", "Charlie", "Aaron", "Ed");
		long startsWithA = names
				.stream()
				.map(l -> l.toUpperCase())
				.filter(n -> n.startsWith("A"))
				.count();
		System.out.println(startsWithA);
		
		
		List<Double> temperatures = Arrays.asList(98.4, 100.2, 87.9, 102.8);
		long overHundred = temperatures
				.stream()
				.filter(h -> h > 100)
				.count();
		System.out.println(overHundred);
		
		
		Map<String, Integer> dog = new HashMap<>();
		dog.put("Spot", 1);
		dog.put("Rex", 4);
		dog.put("Charlie", 8);
		
		long overFour = dog
				.entrySet()
				.stream()
				.filter(d -> d.getValue() > 4)
				.count();
		System.out.println(overFour);
		
		
		boolean bol = names.stream().map(n -> n.toUpperCase()).anyMatch(n -> n.startsWith("S"));
		
		if(bol) {
			long amount = names
					.stream()
					.map(p -> p.toUpperCase())
					.filter(p -> p.startsWith("S"))
					.count();
			System.out.println(amount);
		}
		 
		
		
		List<Purchase> purchase = Arrays.asList(new Purchase("Shirt", 100.1), new Purchase("Shoes", 149.9), new Purchase("Jumper", 90.3));
		
		OptionalDouble d = purchase
				.stream()
				.mapToDouble(t -> t.price)
				.filter(v -> v >= 100.0 && v <= 200.0)
				.average();
		if(d.isPresent()) {
			System.out.println(d.getAsDouble());	
		}
		else {
			System.out.println("Average is not present");
		}
		
	}

}
