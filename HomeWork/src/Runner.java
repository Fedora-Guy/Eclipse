
public class Runner {
	private String name; // Name of the Runner
	private int runDistance; // Number that they ran last week in miles
	
	public Runner (String argName, int argRunDistance) {
		name = argName;
		runDistance = argRunDistance;
	}
	
	// Prints Class Description
	public String toString() {
		String displayString = name + ": " + runDistance;
		return displayString;
	}

	public String getName() {
		return name;
	}

	public void setName(String argName) {
		name = argName;
	}

	public int getRunDistance() {
		return runDistance;
	}

	public void setRunDistance(int argRunDistance) {
		runDistance = argRunDistance;
	}
	
	
}
