
public class Car {
	private String model;
	private String brand;
	private String color;
	public static int NUM_CARS = 0;
	
	Car(String argModel, String argBrand, String argColor) {
		this.model = argModel;
		this.brand = argBrand;
		this.color = argColor;
		NUM_CARS += 1;
	}
	
	public String toString() {
		String displayString = model + " - " + brand + " (" + color + ")";
		return displayString;
	}
}
