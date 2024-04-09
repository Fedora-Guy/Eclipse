
public class Motorcycle extends MotorVehicle {
	public Motorcycle() {
		capacity = 2;
		passengers = new Person[capacity];
	}

	public String toString() {
		return "Motorcycle - " + super.toString();
	}
}
