import java.text.NumberFormat;

public class NestedLoops {

	public static void main(String[] args) {
		final double monthlyPayment = 100.0;
		double monthlyRate;
		int months;
		double futureValue = 0.0;
		String rows;
		String table = "\t";
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMinimumFractionDigits(1);
		System.out.println("Monthly payment: " + monthlyPayment + "\n");
		
		for (double rate = 5.0; rate < 7.0; rate +=.5) {
			table += "\t" + percent.format(rate/100);
			
		}
		table+="\n\n";
		for (int years = 4; years > 0; years--) {
			rows = "\t" + years;
			
			for (double rate = 5.0;  rate < 7.0; rate+=.5) {
				months = years * 12;
				monthlyRate = rate/12/100;
				
				for (int i = 1; i <= months; i++) {
					futureValue = (futureValue + monthlyRate) * (1 + monthlyRate);
				}
				
				rows += "\t"+currency.format(futureValue);
			}
			table += rows+ "\n";
			rows = "";
			
		}
		System.out.println(table);
		
	}

}
