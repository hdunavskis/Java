package composition;

public class driver {

	public static void main(String[] args) {
		
			
		Room room = new Room(new Chair(4,5), new Table(2, "wooden"), new Bed("Double", "Royal"));
		House house = new House(room);
		
		house.getContents();
		//have to have getters in order to access maneBed method this way. 
	
		house.getSingleRoom().getBed().makeBed();

	}

}
