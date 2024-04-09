import java.util.Scanner;
import javax.swing.JOptionPane;

public class KeithReisHW3 {
	public static void main (String[] args) {
		// Question 1
		int grade = Integer.parseInt(JOptionPane.showInputDialog("What's your grade?"));
		if( grade >= 90) {
			System.out.println("A");
		}else if (grade >= 80 ) {
			System.out.println("B");
		}else if (grade >= 70 ) {
			System.out.println("C");
		}else if (grade >= 65 ) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		// Question 2
		
		int grade2 = Integer.parseInt(JOptionPane.showInputDialog("What's your grade?"));
		if( grade2 >= 90) {
			System.out.print("A");
			if (grade2 == 100)
				System.out.println("+");
			else if(grade2 <= 92) 
				System.out.println("-");
		}else if (grade2 >= 80 ) {
			System.out.print("B");
			if (grade2 == 100)
				System.out.println("+");
			else if(grade2 <= 92) 
				System.out.println("-");
		}else if (grade2 >= 70 ) {
			System.out.print("C");
			if (grade2 == 100)
				System.out.println("+");
			else if(grade2 <= 92) 
				System.out.println("-");
		}else if (grade2 >= 65 ) {
			System.out.print("D");
		} else {
			System.out.print("F");
		}
		
		// Question 3
		Scanner s = new Scanner(System.in);
		System.out.println("What is your character's health? [1-100]");
		int health = s.nextInt();
		System.out.println("What is your damage your character receieved? [1-100]");
		int damage = s.nextInt();
		if (damage >= health) {
			System.out.println("Your character is going to die. "
					+ "Do you wish to use a force field spell? [Yes or No]");
			String answer = s.next();
			if(answer.equalsIgnoreCase("Yes")) {
				System.out.println("You cast force field and live. Your character has " + health + " hit points remaning.");
			}
			else {
				System.out.println("You did not use the spell. Your character is dead... Great choice.");
				health = 0;
			}
		} else {
			health -= damage;
			System.out.println("Your character has " + health + " hit points remaining.");
		}
		System.out.println("Thanks for playing");
		s.close();
	}

}
