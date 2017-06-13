package encapsulation;

public class driver {

	public static void main(String[] args) {
		// Creates object called printer with 50 print credits (tonerLevel)
		Printer printer = new Printer(50); 
		// Method print is called - double side printing 2 pages.
		printer.print("duplex",2);
		//topUp method allows to top up toner level
		printer.topUp(60);
		//2 single pages printed
		printer.print("single", 2);
		

	}

}
