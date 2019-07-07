package strings;

public class substringComparisons {

	public static String compare(String s, int k) {
		
		String smallest = s.substring(0,k);
		String largest = s.substring(0,k);
		
		for(int i = 1; i <= s.length()-k; i++) {
			
			if(smallest.compareTo(s.substring(i,i+k)) > 0) {
				smallest = s.substring(i,i+k);
			}
			else if(largest.compareTo(s.substring(i,i+k)) < 0) {
				largest = s.substring(i,i+k);
			}
		}
		return smallest + "\n" + largest;
	}
	public static void main(String[] args) {
		String a = "welcometojava";
		int b = 3;
		
		System.out.println(compare(a,b));
	}

}
