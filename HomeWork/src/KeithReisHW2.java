import java.util.Scanner;

import javax.swing.JOptionPane;

public class KeithReisHW2 {
	public static void main (String[] args) {
		
		// Question 1
		int x = 1;
		System.out.print(x); // 1
		x += 1;
		System.out.print(" " + x); // 2
		x += 1;
		System.out.print(" " + x); // 3
		x += 1;
		System.out.print(" " + x); // 4
		x += 1;
		System.out.print(" " + x); // 5
		x += 1;
		System.out.print(" " + x); // 6
		x += 1;
		System.out.print(" " + x); // 7
		x += 1;
		System.out.print(" " + x); // 8
		x += 1;
		System.out.print(" " + x); // 9
		x += 1;
		System.out.println(" " + x); // 10
		
		// Question 2
		String firstName = JOptionPane.showInputDialog("What is your first name?");
		String lastName = JOptionPane.showInputDialog("What is your last name?");
		String fullName = firstName + " " + lastName;
		System.out.println("Your first name is " + firstName);
		System.out.println("Your last name is " + lastName);
		System.out.println("Your full name is " + fullName);
		
		
		// Question 3
		Scanner s = new Scanner(System.in);
		System.out.println("What is the baseball player's name?");
		String name = s.nextLine();
		System.out.println("How many times has " + name + " been at bat?");
		int atBats = s.nextInt();
		System.out.println("How many times has " + name + " hit the ball?");
		int numberOfHits = s.nextInt();
		double battingAverage = (double)numberOfHits / (double) atBats;
		System.out.print(name + " has a batting average of ");
		System.out.printf("%.3f", battingAverage);
		s.close();
		
	}

}
