import java.util.HashMap;
import java.util.Map;

public class Circle extends Shape {

	private int age;
	private String name;
	
	public Circle(int age){
		this.age = age;
	}
	@Override
	public void someMethod() {
		System.out.println("ss");
		
		
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	

	/*
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + age; result = prime * result + ((name == null) ? 0
	 * : name.hashCode()); return result; }
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public static void main(String[] args) {
	
		Map<Circle, String> stuff = new HashMap<>();
		Circle c = new Circle(1);
		Circle c1 = new Circle(2);
		c.setName("CName");
		c1.setName("C1Name");
		stuff.put(c, c.getName());
		stuff.put(c1, c1.getName());
		
		//System.out.println(stuff.containsKey(c));
		
		//System.out.println(stuff.containsKey(c));
	//	System.out.println(stuff.get(c));
		System.out.println(stuff.get(c));
		System.out.println(stuff.get(c1));
		
		c.setName("CNewName");
		c1.setName("C1NewName");
		//c.setAge(22);
		System.out.println(stuff.get(c));
		System.out.println(stuff.get(c1));
		 
	}
	
}
