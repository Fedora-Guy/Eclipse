
public class Bus extends MotorVehicle {
	public Bus() {
		capacity = 10;
		passengers = new Person[capacity];
	}

	public String toString() {
		return "Bus - " + super.toString();
	}
}
