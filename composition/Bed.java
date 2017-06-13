package composition;
//composition
public class Bed {
	
	private String bedType;
	private String manufacturer;
	
	public Bed(String type, String manufacturer){
		
		this.bedType = type;
		this.manufacturer = manufacturer;
	}
	
	public void makeBed(){
		System.out.println("Bed is created");
	}
	
	public String getBedType(){
		return bedType;
	}
	
	public String getManufacturer(){
		return manufacturer;
	}
}
