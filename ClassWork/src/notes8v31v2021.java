import java.util.Scanner;

import javax.swing.JOptionPane;

public class notes8v31v2021 {
	public static void main(String[] args) {
//		// Review of Question 2
//		
////		// Create Variables
//		int a = 4;
//		int b = 7;
//		int c = 8;
//		int result = a * (b+c);
//		
//		//Print the equation
//		System.out.println(a + "(" + b + " + " + c + ") = " + result);
//		System.out.println("4(7 + 8) = 60");
//		
//		// Printf (Print Formatting stuff)
//		double costOfItem = 5234.6465;
//		System.out.print("***");
//		System.out.printf("%8.3e", costOfItem);
//		System.out.println();
//		System.out.printf("%,.2f", costOfItem);
//		System.out.println();
//		
//		String name1 = "Kathy";
//		String name2 = "Amy";
//		System.out.printf("%15s", name1);
//		System.out.println();
//		System.out.printf("%15s", name2);
//		
//		
//		// Scanner Stuff
//		Scanner s = new Scanner(System.in);
//		System.out.println("Please enter your age:");
//		int age = s.nextInt();
//		
//		System.out.println("You are " + age + " years old");
//		
//		System.out.println("Please enter your full name");
//		String firstName = s.next();
//		String lastName = s.next();
//		System.out.println("Hello " + lastName + " " + firstName);
//		System.out.println("Again plz");
//		String fullName = s.nextLine();
//		System.out.println(fullName);
//		
//		String firstName2= JOptionPane.showInputDialog("Please enter your first name");
//		String lastName2 = JOptionPane.showInputDialog("Please enter your last name");
//		String fullName2 = firstName2 + " " + lastName2;
////		System.out.println("Hello " + fullName);
//		JOptionPane.showConfirmDialog(null, fullName2);
//		JOptionPane.showMessageDialog(null, "Hello " + fullName2);
//		JOptionPane.setRootFrame(null);
//		s.close();
		String[] x = {"Alice", "Bob", "Carol"};
		String[] y = x;

		x[1] = "David";

		System.out.println(x[1]);
		System.out.println(y[1]);
	}

}