package arrays;

public class sumOfArray {

	public static int sum(int[]a) {
		
		int sum = 0;
		for(int i = 0; i < a.length; ++i) {
			sum += a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		
		int [] array = {1,2,3};
		
		System.out.println(sum(array));
	}

}
