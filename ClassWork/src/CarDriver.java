
public class CarDriver {
	public static void main(String[] args) {
		//Create the cars
		Car c1 = new Car("Nissan", "Rogue", "blue");
		
		
		//Print the cars
		System.out.println(c1);
		//Print the number of cars
		System.out.println("Number of cars created: " + Car.NUM_CARS);
		
		Car c2 = new Car("Honda", "Civic", "Silver");
		Car c3 = new Car("Cadillac", "Catera", "Gold");
		
		System.out.println(c2);
		System.out.println(c3);
		
		//Print the number of cars
		System.out.println("Number of cars created: " + Car.NUM_CARS);
	}
}
