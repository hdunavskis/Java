package sorts;

public class InsertSorting {

	static void insertSort(int[] array)
		{
			int temp = 0,i,j;
			for(i = 1; i < array.length; i++)
			{
				for(j = i; j > 0; j--)
					{
						if(array[j] < array[j-1])
							{
								temp = array[j-1];
								array[j-1] = array[j];
								array[j] = temp;
							}
								
					}
				
			}			
		}
	
	public static void insert(int[] array)
	{
		int i,j, temp;
		
		for(i =1; i < array.length; i++)
		{
			for(j =i; j > 0; j--)
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
		
		array[0] = 8;
		array[1] = 5;
		array[2] = 9;
		array[3] = 2;
		array[4] = 4;
		
	
		insert(array);
		for(int i =0; i< array.length; i++)
		{
			System.out.print(array[i] + "\t");
		}
		
		
		

	}

}
