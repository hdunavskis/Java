package stack;

public class stack 
{
	private int size; // maximum size of the stack
	private int top; // top position in the stack
	private int array[];
	
	public stack(int x)
	{
		size = x;
		array = new int[size];
		top = 0;
	}
	public void push(int x)
	{
		if(top < size)
		{
			array[top] = x;
			top++;
		}
		else
		{
			System.out.print("Stack overflow!!!");
		}
	}
	public boolean empty()
	{
		if(top == 0)
		{
			return true;
		}
		return false;
	}
	public int pop()
	{
		if(!empty())
		{
			int temp = array[top-1];
			array[top-1] = -1;
			top--;
			return temp;
		}
		return -1;
	}
	public int peak()
	{
		if(top > 0)
		{
			return array[top-1];
		}
		return -1;//if stack is empty return -1
	}

}
