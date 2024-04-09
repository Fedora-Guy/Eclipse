
// Class Represents: The Player's location in the game
// Player interacts with this class when using the up or down arrows.
public class PlayerLocation {
	// Attributes
	
	private int location = 0;
	
	// Getters and Setters for the Attributes
	
	public void changeLocation(int argLocation) {
		location = argLocation;
	}
	
	public int getLocation() {
		return location;
	}
}
