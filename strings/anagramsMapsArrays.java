package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class anagramsMapsArrays {

	public static String anagArray(String a, String b) {
		
		if(a.length() != b.length()) {
			return "Not Anagrams";
		}
		a = a.toUpperCase();
		b = b.toUpperCase();
		char stringA[] = a.toCharArray();
		char stringB[] = b.toCharArray();
		
		Arrays.parallelSort(stringA);
		Arrays.parallelSort(stringB);
		
		
		for(int i = 0; i < stringA.length; i++) {
			
			if(stringA[i] != stringB[i]) {
				return "Not Anagrams";
			}
		}
		return "Anagrams";
	}
	public static String anagramMaps(String a, String b) {
		
		if(a.length() != b.length()) {
			return "Not Anagram";
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		a = a.toUpperCase();
		b = b.toUpperCase();
	
		for(int i = 0; i < a.length(); i++) {
			
			if(map.containsKey(a.charAt(i))) {
				//if character is present in the map return the value and increment it by 1
				map.put(a.charAt(i), (map.get(a.charAt(0)) + 1));
			}
			else {
				map.put(a.charAt(i), 1);
			}
		}
		
		for(int k = 0; k < b.length() ; k++) {
			// check if the character is in the map
			if(map.containsKey(b.charAt(k))) { 
				Integer count = map.get(b.charAt(k));
				
				if(count == 0) {
					return "Not Anagram";
				}
				else {
					map.put(b.charAt(k), count-1);
				}
			}
			else {
				return "Not Anagram";
			}
		}
		return "Anagram";
		
		
	}
	public static String asciValues(String a, String b) {
		//this will not work for every case
		if(a.length() != b.length()) {
			return "Not Anagrams";
		}
		a = a.toLowerCase();
		b = b.toLowerCase();
		int sum = 0;
		
		for(int i = 0; i < a.length(); i ++) {
			sum += a.charAt(i);
			sum -= b.charAt(i);
		}
		if(sum != 0) {
			return "Not anagrams";
		}
		return "Anagrams";
	}
	public static void main(String[] args) {
		String a = "xyzw";
		String b = "xyxy";
		
		
		
		System.out.println(anagramMaps(a, b));
		//System.out.println(anagramMaps(a,b));
	}

}
