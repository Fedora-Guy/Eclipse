
public class Vehicle {
	protected Person[] passengers;
	protected String location;
	protected int capacity;
	protected String name;
	
	public Vehicle() {
		location = "HOME";
		capacity = 1;
		passengers = new Person[capacity];
	}
	
	public void setName(String argName) {
		name = argName;
	}
	
	public String toString() {
		int numPassengers = 0;
		for(Person p : passengers) {
			if (p != null) numPassengers++;
		}
		return name + " - Location: " + location + " - Num passengers: " + numPassengers + "/" + capacity;
	}
	
	public void getIn(Person argPerson) {
		if(argPerson.getLocation().equals(location)) {
			for(int i = 0; i < passengers.length; i++) {
				if( passengers[i] == null) {
					passengers[i] = argPerson;
					return;
					
				}
			}
			System.out.println("Person " + argPerson.getName() + " cannot get in the " + name + " because there is no room.");
		} else {
			System.out.println("Person " + argPerson.getName() + " cannot get in the " + name + " because they are in a different location.");
		}
	}
	
	public void getOut(Person argPerson) {
		for(int i = 0; i<passengers.length; i++) {
			if(passengers[i] != null && passengers[i].getName().equals(argPerson.getName())) {
				passengers[i] = null;
				return;
			}
		}
		
		System.out.println("Person " + argPerson.getName() + " is not in/on the " + name);
	}
	
	
}
