import java.util.Scanner;

public class KeithReisHW4 {
	public static void main (String [] args) {
		// Question 1
		Scanner a = new Scanner(System.in);
		System.out.println("What is your age?");
		int age = a.nextInt();
		System.out.println((age > 21 || age % 3 == 0) ? "Welcome to the secret club" : "Nothing to see here kid");
		System.out.println((age > 21 && age % 3 == 0) ? "Welcome to the double-secret club" : "Get lost!");
		// a.close(); 	Would normally put this here, but 
		//				having it here gives an error. 
		//				Instead I put it at the end.

		
		// Question 2
		Scanner m = new Scanner(System.in);
		System.out.println("What month is it?");
		int month = m.nextInt();
		switch (month)
		{
		case 0:
			System.out.println("In January it snowed an average of 5.8 days.");
			System.out.println("Each snowfall had an average of 15.8 inches (40.0 centimeters).");
			break;
		case 1:
			System.out.println("In February it snowed an average of 5.4 days.");
			System.out.println("Each snowfall had an average of 16.1 inches (41.0 centimeters).");
			break;
		case 2:
			System.out.println("In March it snowed an average of 2.0 days.");
			System.out.println("Each snowfall had an average of 7.1 inches (17.9 centimeters).");
			break;
		case 3:
			System.out.println("In April it snowed an average of 0.4 days.");
			System.out.println("Each snowfall had an average of 1.2 inches (2.9 centimeters).");
			break;
		case 9:
			System.out.println("In October it snowed an average of 0.1 days.");
			System.out.println("Each snowfall had an average of 1.2 inches (0.4 centimeters).");
			break;
		case 10:
			System.out.println("In November it snowed an average of 0.8 days.");
			System.out.println("Each snowfall had an average of 2.3 inches (5.8 centimeters).");
			break;
		case 11:
			System.out.println("In December it snowed an average of 2.6 days.");
			System.out.println("Each snowfall had an average of 6.9 inches (17.4 centimeters).");
			break;
		default:
			System.out.println("It did not snow at all in that month!");
		}
		m.close();
		
		a.close();
	}
}
