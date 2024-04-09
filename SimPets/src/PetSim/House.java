package PetSim;

public class House {
	public static void main(String[] args) {
		
		System.out.println("Welcome to my pet simulator");
		
		Cat garfield = new Cat("Garfield");
		Cat tom = new Cat("Tom");
		Dog goofy = new Dog("Goofy");
		Dog scooby = new Dog("Scooby-Doo");
		
		System.out.println(garfield);
		System.out.println(tom);
		
		garfield.talk();
		tom.talk();
		
		scooby.talk();
		goofy.talk();
		
		garfield.giveBone(goofy);
		garfield.giveBone(goofy);
		System.out.println(goofy);
		
		goofy.chew();
		goofy.chew();
		goofy.chew();
		goofy.chew();
		goofy.chew();
		
		scooby.chew();
		
		garfield.giveBone(goofy);
		
		scooby.biteCat(tom);
		
	}
}
