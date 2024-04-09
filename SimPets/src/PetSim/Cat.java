package PetSim;

public class Cat {
	private int lives;
	private String name;
	
	
	public Cat (String argName) {
		name = argName;
		lives = 9;
	}
	
	public String toString() {
		String displayString = "The cat's name is " + name + "."
				+ "\n" + name + " has " + lives + " lives remaining.";
		return displayString;
	}
	
	
	public int getLives() {
		return lives;
	}

	public void setLives(int argLives) {
		lives = argLives;
	}

	public String getName() {
		return name;
	}

	public void setName(String argName) {
		name = argName;
	}

	public void talk() {
		System.out.println(name + ": Meow");
	}
	
	public void getBitten() {
		lives--;
		System.out.println(name + ": Meeeooowch!! I just got bitten ("+ lives +" lives remaining).");
	}
	
	public void annoyDog(Dog argDog) {
		System.out.println(name + "I am annoying " + argDog.getName());
		argDog.getAnnoyed(this);
	}
	
	public void giveBone(Dog argDog) {
		System.out.println(name + ": I am giving " + argDog.getName() + " a bone.");
		Bone bone = new Bone();
		argDog.receiveBone(bone);
	}
	
	public void stealBone(Dog argDog) {
		System.out.println(name + "I am stealing " + argDog.getName() + "'s bone");
		argDog.boneGetStolen(this);
	}
	
}
