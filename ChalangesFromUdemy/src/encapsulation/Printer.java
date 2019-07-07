package encapsulation;
// Printer class that prints single page or double side page.
// User must topUpp toner to be able to print. 
//encapsulation
public class Printer {
	// variables are private and can not be accessible outside the class.
	private int tonerLevel = 0;
	private int pagesPrinted = 0;
	private final int price = 5;
	
	public Printer(int tonerLevel){
		if(tonerLevel <= 100 && tonerLevel > 0)
		this.tonerLevel = tonerLevel;
	}
	
	public void print(String type, int amount){
		//Validation to make sure there is enough toner to print.
		if(type.equalsIgnoreCase("single") && (amount*price) <= tonerLevel ){
			
				this.pagesPrinted +=amount;
				this.tonerLevel -= (amount * price);
				System.out.println("Pages is printed successfully. Remaining toner is : " + pagesPrinted + " total printed pages : " + pagesPrinted);
			}else if(type.equalsIgnoreCase("duplex") && (amount *(price*2) <= tonerLevel)){
			//Validation for double side printing
				this.pagesPrinted += (amount / 2);
				this.tonerLevel -= (price *2);
				System.out.println("Duplex page is printed successfully. Remaining toner is : " + tonerLevel + " total printed pages : " + pagesPrinted);
			}else{
				System.out.println("Not enogh toner to print!!!" + tonerLevel);
			}
		}
	public void topUp(int topUp){
		//Validation to not allow to top up more than 100 toner credits.
		if((topUp + tonerLevel) <= 100){
			this.tonerLevel += topUp;
			System.out.println("Top up was successfull. Toner level is : " + tonerLevel);
		}else{
			System.out.println("Please enter smaller number!");
		}
	}
	public int getPagesPrinted(){
		return pagesPrinted;
	}
	public int getTonerLevel(){
		return tonerLevel;
	}
	

}