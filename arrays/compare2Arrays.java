package arrays;

public class compare2Arrays {

	public static int[] compare(int[]a, int[]b) {
		
		int []results = new int[2];
		
		for(int i = 0; i < a.length; ++i) {
			if(a[i] > b[i]) {
				results[0] += 1;
			}
			else if(b[i] > a[i]) {
				results[1] += 1;
			}
		}
		return results;
		
	}
	public static void main(String[] args) {
		int[] a = {17,28,30};
		int[] b = {99,16,8};
		
		int[] result = compare(a,b);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}

	}

}
