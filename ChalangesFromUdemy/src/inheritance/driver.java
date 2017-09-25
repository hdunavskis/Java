package inheritance;
//main class inheritance
public class driver {

	public static void main(String[] args) {
	
		TypeOfVehicle car = new TypeOfVehicle("Estate", "Car", 4, 4, "automatic", "Audi", "A6");
		
		car.moving(10);
		car.stearing("Straight");
		car.moving(20);
		car.moving(10);
		car.moving(30);
		car.moving(60);
	}

}