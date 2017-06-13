package composition;

public class Chair {
	private int height;
	private int width;
	
	public Chair(int height, int width){
		
		this.height = height;
		this.width = width;
	}
	
	public void makeChair(){
		System.out.println("Chair is created");
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}
