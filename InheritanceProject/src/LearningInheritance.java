
public class LearningInheritance {

	public static void main(String[] args) {
		
		Person[] people = new Person[10];
		people[0] = new Person("Alice");
		people[1] = new Person("Bob");
		people[2] = new Person("Carol");
		people[3] = new Person("Doug");
		people[4] = new Person("Ernie");
		people[5] = new Person("Fawn");
		people[6] = new Person("George");
		people[7] = new Person("Harry");
		people[8] = new Person("Isabella");
		people[9] = new Person("Jessica");
		
		Bicycle bicycle = new Bicycle();
		bicycle.setName("Schwinn");
		Car car = new Car();
		car.setName("DeLorean");
		Motorcycle motorcycle = new Motorcycle();
		motorcycle.setName("Harley");
		Bus bus = new Bus();
		bus.setName("Mystery Machine");
		
		
		bicycle.getIn(people[0]);
		bicycle.getIn(people[1]);
		bus.getIn(people[2]);
		bus.getIn(people[3]);
		bus.getIn(people[4]);
		bus.getIn(people[5]);
		bus.getIn(people[6]);
		bus.getOut(people[4]);
		bus.getOut(people[8]);
		
		System.out.println(bicycle);
		System.out.println(car);
		System.out.println(motorcycle);
		System.out.println(bus);
		
//		for(Person p : people) {
//			System.out.println(p);
//		}
		
		
		
	}

}
