package sorts;

public class SelectionSorting {

	static void selectSort(int[] array)
		{
			int temp = 0,i,j,index = 0;
			for(i = 0; i < array.length-1; i++)
			{
				index = i;
				for(j = i+1; j < array.length; j++)
					{
						if(array[index] > array[j])
							{
								index = j;
							}
								
					}
				if(index != i)
					{
						temp = array[index];
						array[index] = array[i];
						array[i] = temp;
						
					}
			}			
		}
	
	public static void select(int[]array)
	{
		int i, j, temp;
		
		for(i = 0; i < array.length; i ++)
		{
			for(j = i; j >0; j--)
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
		
	
		select(array);
		for(int i =0; i< array.length; i++)
		{
			System.out.print(array[i] + "\t");
		}
		
		
		

	}

}
