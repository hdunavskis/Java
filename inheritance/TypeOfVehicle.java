package inheritance;
//inheritance
public class TypeOfVehicle extends Car{

	private String make;
	private String model;
	
	public TypeOfVehicle(String typeOfVehicle, String nameOfVehicle, int wheels, int doors, String gearBox, String make, String model) {
		
		super(typeOfVehicle, nameOfVehicle, wheels, doors, gearBox);
		this.make = make;
		this.model = model;
		
	}

	@Override
	public void moving(int speed) {
		super.moving(speed);
		changingGear();
	}

	public void changingGear(){
		if(getGearBox().equalsIgnoreCase("automatic")){
			if(getSpeedOfVehicle() >=80){
				System.out.println("Current gear is : " + 6);
			}else if(getSpeedOfVehicle() >=60){
				System.out.println("Current gear is :" + 5);
			}else if(getSpeedOfVehicle() >=45){
				System.out.println("Current gear is : " + 4);
			}else if(getSpeedOfVehicle() >=30){
				System.out.println("Current gear is : " + 3);
			}else if (getSpeedOfVehicle() >=20){
				System.out.println("Current gear is : " + 2);
			}else{
				System.out.println("Current gear is :" + 1);
			}
		}
			
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}
	
}
