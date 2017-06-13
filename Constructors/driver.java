package Constructors;
//main class
public class driver {

	public static void main(String[] args) {
	VipCustomer customer = new VipCustomer();
	
	System.out.println(customer.getCreditLimit());
	System.out.println(customer.getEmail());
	System.out.println(customer.getName());
	
	VipCustomer customer2 = new VipCustomer("name", "1224", "email");

	System.out.println("\n" + customer2.getName());
	System.out.println(customer2.getCreditLimit());
	System.out.println(customer2.getEmail());
	
	VipCustomer customer3 = new VipCustomer("FirstName", "email");
	
	System.out.println("\n" + customer3.getName());
	System.out.println(customer3.getCreditLimit());
	System.out.println(customer3.getEmail());
	
	}

}
