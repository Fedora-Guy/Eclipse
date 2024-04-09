package PetSim;

import java.util.Random;

public class Dog {
	private String name;
	private Bone bone;
	private boolean hasBone;
	
	public Dog (String argName) {
		name = argName;
		bone = null;
		hasBone = false;
	}
	
	public String toString() {
		String displayString = name + ": ";
		if(hasBone == true)
			displayString += "I am happy because I have a bone.";
		else
			displayString += "I am dreaming of a bone.";
		return displayString;
	}
	
	public String getName() {
		return name;
	}
	
	public void talk() {
		System.out.println(name + ": Woof");
	}
	
	public void receiveBone(Bone argBone) {
		if (hasBone) {
			System.out.println(name + ": I already have a bone.");
		}
		else {
			bone = argBone;
			hasBone = true;
			System.out.println(name + ": Thanks for the bone.");
		}
	}
	
	public void chew() {
		if(hasBone) {
			int newLength = bone.getChewed();
			System.out.println(name + ": Chomp");
			if(newLength == 0) {
				bone = null;
				hasBone = false;
				System.out.println(name + ": I just finished my bone. I need a new one please.");
			} else {
				System.out.println(bone);
			}
		} else {
			System.out.println(name + ": I don't have a bone to chew. Boo Hoo.");
		}
		
	}
	
	public void boneGetStolen(Cat argCat) {
		if(hasBone) {
			Random r = new Random();
			if(r.nextDouble() > .5) {
				bone = null;
				hasBone = false;
				System.out.println(name + ": My bone was stolen");
			} else {
				System.out.println(name + ": I caught " + argCat.getName() + " stealing my bone");
				biteCat(argCat);
			}
		} else {
			System.out.println(name + ": I don't have a bone");
		}
		
	}
	
	public void biteCat(Cat argCat) {
		System.out.println(name + ": I am biting " + argCat.getName() + ".");
		argCat.getBitten();
	}

	public void getAnnoyed(Cat argCat) {
		System.out.println(name + ": I am being annoyed by " + argCat.getName());
		if(hasBone) {
			talk();
		} else {
			biteCat(argCat);
		}
	}
}
