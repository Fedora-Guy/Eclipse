
public class Car extends MotorVehicle {
	public Car() {
		capacity = 4;
		passengers = new Person[capacity];
	}
	
	public String toString() {
		return "Car - " + super.toString();
	}
}
