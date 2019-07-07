package stack;

public class driver {

	public static void main(String[] args) 
	{
		stack st = new stack(4);
		
		System.out.println(st.empty());// check is stack empty
		st.push(1);
		System.out.println(st.empty());
		System.out.println(st.peak());
		st.push(2);
		System.out.println(st.peak());
		st.push(3);
		System.out.println(st.peak());
		st.push(4);
		System.out.println(st.peak());
		st.push(5);
		
		
	
	}

}
