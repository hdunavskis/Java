package strings;

public class compareAddUpper {

	public static int stringSize(String a, String b) {
		return a.length() + b.length();
	}
	public static String alpha(String a, String b) {
		
		if(a.compareTo(b) <= 0) {
			return "No";
		}
		return "Yes";
		// result < 0 -> a comes first
		// result == 0 -> two strings are the same
		// results > 0 -> b comes first
	}
	public static void main(String[] args) {
		String A = "java";
		String B = "java";
		

		System.out.println(stringSize(A,B));
		System.out.println(alpha(A,B));
		A = Character.toUpperCase(A.charAt(0)) + A.substring(1);
		B = Character.toUpperCase(B.charAt(0)) + B.substring(1);
		System.out.println(A + " " + B);
	}

}
