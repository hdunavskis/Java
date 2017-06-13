package BankAccount;
//constructors main class

public class driver {

	public static void main(String[] args) {
		// new instance of Account is created
		Account account = new Account("Helmuts", "email", 12345, 1 );
		
		account.withdrawal(50);
		account.deposit(50);
		account.withdrawal(51);
		account.withdrawal(-1);
		account.withdrawal(45);
		

	}

}
