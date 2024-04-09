
// Class Represents: The Mismatched Brick in the Top Floor Wall
// The Player interacts with this class when they click on the brick, then subsequently when they click on the spot where the brick was.
public class MismatchedWall {
	
	// Attributes
	
	private boolean removedBrick;
	private int timecode1;
	private int timecode2;
	
	// Constructors 
	
	public MismatchedWall() {
		removedBrick = false;
		timecode1 = (int)(Math.random() * (12 - 1) + 1);
		timecode2 = (int)(Math.random() * (60));


	}
	
	// If there is a need to hard code a value to test it, use this constructor
	public MismatchedWall(boolean argRemovedBrick, int argTimecode1, int argTimecode2) {
		removedBrick = argRemovedBrick;
		timecode1 =  argTimecode1;
		timecode2 =  argTimecode2;
	}

	// Getters and Setters for the Attributes
	
	public boolean getRemovedBrick() {
		return removedBrick;
	}

	public void setRemovedBrick(boolean argRemovedBrick) {
		removedBrick = argRemovedBrick;
	}

	public int getTimecode1() {
		return timecode1;
	}

	public void setTimecode1(int argTimecode1) {
		timecode1 = argTimecode1;
	}

	public int getTimecode2() {
		return timecode2;
	}

	public void setTimecode2(int argTimecode2) {
		timecode2 = argTimecode2;
	}
	
	// toString method {Might be implemented with a text field at the bottom if I have time + figure out why MouseEntered/MouseExited don't work
	public String toString() {
		String displayString = "";
		if(removedBrick == false) {
			displayString = "One of the Bricks appear to be sticking out.";
		} else {
			displayString = "The spot behind the brick wall contains a digit code.";
		}
		return displayString;
	}
	
	
}
