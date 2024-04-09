
public class StudentDriver {
	public static void main(String[] args) {
		System.out.println("Welcome to my student simulator");
		
		// Create some students
		Student student1 = new Student();
		Student student2 = new Student("Karen");
		Student student3 = new Student("Andy", 2);
		// Set some of the values for this student (incorrect way, will fix later)
		student1.age = 20;
//		student2.age = 19;
//		student1.name = "Alice";
//		student2.name = "George";
		
		// Print some information
//		System.out.println(student1.name + " is " + student1.age + " years old");
//		System.out.println(student2.name + " is " + student2.age + " years old");
//		System.out.println(student3.name + " is " + student3.age + " years old");
		
		System.out.println(student2.toString());
	}
}
