package BankAccount;
//constructors
/*
 Account class with fields account number, balance, customer name, email and phone number
Getters and Setters for each field
1. Allow customer to deposit funds
2. Allow customer to withdraw funds 
 */
public class Account {
	
	private String name;
	private String email;
	private int phone;
	private int accountNumber;
	private double balance =0;
	
	
	public Account(String name, String email, int phone, int accountNumber){
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.accountNumber = accountNumber;
		//setName(name);
		//setEmail(email);
		//setPhone(phone);
		//setAccountNumber(accountNumber);
		//DO NOT USE SETTERS OR OTHER METTHODS IN CONSTRUCTOR APPART FROM CALLING ANOTHER CONSTRUCTOR
		
	}

	public void withdrawal(double ammount){
		//Validation to make sure that there is enough funds to withdraw 
		if(ammount < 0)
			System.out.println("Wrong value!");
		else if(balance < ammount)
			System.out.println("Not enough funds " + this.name + "Your balance is: " + this.balance);
		else{
			this.balance -= ammount;
			System.out.print("New balance after withdrawal " + this.name + " is " + this.balance);	
		}
	}
	public void deposit(double deposit){
		this.balance += deposit;
		System.out.print("Balance after deposit is : " + this.balance);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

}
