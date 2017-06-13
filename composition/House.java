package composition;
//composition
public class House {
	
	private Room singleRoom;
	
	public House(Room singleRoom){
		this.singleRoom = singleRoom;
	}
	
	public void getContents(){
		
		singleRoom.addContents();
	}

	public Room getSingleRoom() {
		return singleRoom;
	}

}
