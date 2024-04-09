
public class Person {
	private String name, location;
	
	public Person(String argName) {
		name = argName;
		location = "HOME";
	}
	
	public String toString() {
		String displayString = name + ": " + location;
		return displayString;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String argLocation) {
		location = argLocation;
	}

	public String getName() {
		return name;
	}
	
}