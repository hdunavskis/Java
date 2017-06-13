package inheritance;
//Vehicle class should be abstract class
public class Vehicle {
	
	private String typeOfVehicle;
	private String nameOfVehicle;
	private int speedOfVehicle = 0;
	
	public Vehicle(String typeOfVehicle, String nameOfVehicle){
		
		this.typeOfVehicle = typeOfVehicle;
		this.nameOfVehicle = nameOfVehicle;
	}
	public void stearing(String stearing){
		System.out.println("You are stearing " + stearing);
	}

	public void moving(int speed){
		if(speed > getSpeedOfVehicle()){
			System.out.println("You are increasing speed. New speed is " + speed);
			this.speedOfVehicle = speed;
			
		}
			
		else if( speed == getSpeedOfVehicle()){
			System.out.println("Moving with this same speed");
			this.speedOfVehicle = speed;
		}
			
		else{
			System.out.println("You are slowing down. New speed is " + speed);
			this.speedOfVehicle = speed;
		}
			
	}
	
	public void stop(){
		this.speedOfVehicle = 0;
		System.out.println("You have stopped");
	}
	
	public String getTypeOfVehicle(){
		return typeOfVehicle;
	}
	
	public String getNameOfVehicle(){
		return nameOfVehicle;
	}
	public int getSpeedOfVehicle(){
		return speedOfVehicle;
	}
}
