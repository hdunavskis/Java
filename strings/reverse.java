package strings;

public class reverse {
	
public static String reverse(String a) {
		String reversed = "";
		
		for(int i = a.length()-1; i >= 0; i--) {
			reversed = reversed + a.charAt(i);
		}
		
		return reversed;
	}
	
	public static void main(String[] args) {
		String a = "test";

		System.out.println(reverse(a));
	}

}
