package ventureSmith;

public class Town extends MapPoint {
		
	public Town(int loc[], String name) {
		super(loc, name);
	}
	
	public String checkType() {
		return "Town";
	}
	
}
