package Constructors;

public class VipCustomer {
	private String name;
	private String creditLimit;
	private String email;
	
	public VipCustomer(){//default values if empty constructor is called
		this("DefaultName", "Default creditLimit", "Default email");
	}
	public VipCustomer(String name, String email){
		
		this(name, "2ndConstructor credit Limit", email);
		
	}
	public VipCustomer(String name, String creditLimit, String email){
		
		this.name = name;
		this.creditLimit = creditLimit;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String getCreditLimit() {
		return creditLimit;
	}
	public String getEmail() {
		return email;
	}

}
