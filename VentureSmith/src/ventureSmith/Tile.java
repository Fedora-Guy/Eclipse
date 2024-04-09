package ventureSmith;

public class Tile {
	
	boolean needsUpdates = false;
	String[] type = new String[2];
	int floor;
	int rand;
	
	public Tile(String[] type, boolean update, int floor) {
		this.type = type;
		this.needsUpdates = update;
		this.floor = floor;
		this.rand = (int) (4*Math.random());
	}
	
	public void updateTile(String[] type) {
		this.type = type;
	}
	
	public void updateFloor(int newFloor) {
		this.floor = newFloor;
	}
	
}
