package inheritance;
//inheritance
public class Car extends Vehicle{
	
	private int wheels;
	private int doors;
	private String gearBox;
	
	
	public Car(String typeOfVehicle, String nameOfVehicle, int wheels, int doors, String gearBox) {
		
		super(typeOfVehicle, nameOfVehicle);
		
		this.wheels = wheels;
		this.doors = doors;
		this.gearBox = gearBox;
		
	}

	public int getWheels() {
		return wheels;
	}

	public int getDoors() {
		return doors;
	}

	public String getGearBox() {
		return gearBox;
	}
	
	
	

}
