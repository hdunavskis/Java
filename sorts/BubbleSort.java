package sorts;

public class BubbleSort {

	public static void bubbleSort (int [] array)
	{
		int i,j, temp;
		
		for(i =0; i < array.length; i++)
			{
				for(j=1; j < array.length-i; j++)
				{
					if(array[j] < array[j-1])
					{
						temp = array[j];
						array[j] = array[j-1];
						array[j-1] = temp;
					}
				}
			}
	}
	
	public static void main(String[] args) {
		int[] array = new int[5];
		
		array[0] = 1;
		array[1] = 5;
		array[2] = 9;
		array[3] = 2;
		array[4] = 4;
		
	
		bubbleSort(array);
		for(int i =0; i< array.length; i++)
		{
			System.out.print(array[i] + "\t");
		}
		
		
		

	}

}
