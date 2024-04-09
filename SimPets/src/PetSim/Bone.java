package PetSim;

public class Bone {
	private int lengthOfBone;
	
	//Constructor
	public Bone () {
		// Bone default length
		lengthOfBone = 4;
	}
	
	public String toString() {
		String displayString = lengthOfBone + " inches";
		return displayString;
	}

	public int getLengthOfBone() {
		return lengthOfBone;
	}

	public void setLengthOfBone(int argLengthOfBone) {
		lengthOfBone = argLengthOfBone;
	}
	
	public int getChewed() {
		if(lengthOfBone > 0) {
			lengthOfBone -= 1;
		}
		return lengthOfBone;
		
	}
	
	
}
