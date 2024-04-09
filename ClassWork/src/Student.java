
public class Student {
	String hairColor, eyeColor, name;
	int height, age;
	public Student() {
		name = "unknown";
		age = 18;
	}
	
	public Student(String s) {
		name = s;
		age = 19;
		eyeColor = "brown";
		height = 72;
		hairColor = "black";
	}
	public Student (String s, int a) {
		name = s;
		age = a;
		eyeColor = "Brown";
		height = 72;
		hairColor = "Black";
	}
	
	public String toString() {
		String displayString = name + " is " + age + " years old and has " + hairColor + " hair";
		return displayString;
	}
}
