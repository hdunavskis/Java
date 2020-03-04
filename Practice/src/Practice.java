import java.util.function.DoubleSupplier;

class A{
	private int price;
	public int getPrice() {
		return price;
	}
}

public class Practice implements T{	

	
public static void main(String [] args) {
	A a = new A();
	DoubleSupplier sp = a::getPrice;

	
}

}
