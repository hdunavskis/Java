package com.ait.lab6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class CalculateMode {
	private static Scanner scanner = new Scanner(System.in);
	
	public static int populateMap(int numberOfItems, Map<Integer, Integer> map) {
		
		int userInput = 0;
		
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println("Enter a number: ");
			userInput = scanner.nextInt();
			
			Integer value = map.containsKey(userInput)? map.get(userInput): 0;
			
			map.put(userInput, value + 1);
		}
		
		return highestFrequency(map);
		
	}
	public static int highestFrequency(Map<Integer, Integer> map) {
	
		int highestFrequency = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
						
			if (entry.getValue() > highestFrequency) {

				highestFrequency = entry.getValue();
			}
		}
		return highestFrequency;
	}
	public static int getKey(Map<Integer, Integer> map, int highestFrequency) {
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == highestFrequency) {
				return entry.getKey();
			}
		}
		return 0;
	}
	public static <K,V> Stream<Integer> allKeys(Map<Integer, Integer> map, Integer highestFrequency) {
		
		return map.entrySet()
				.stream()
				.filter(entry -> highestFrequency.equals(entry.getValue()))
				.map(Map.Entry::getKey);
	}
	public static void main(String[] args) {
		int numberOfItemsToImport;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		System.out.println("How many items to import?");
		numberOfItemsToImport = scanner.nextInt();

		int result = populateMap(numberOfItemsToImport, map);
		//System.out.println(getKey(map, result) + " occured " + result + " times");
		allKeys(map, result).forEach(key -> System.out.println(key + " occured " + result + " times"));
		
	}

}
