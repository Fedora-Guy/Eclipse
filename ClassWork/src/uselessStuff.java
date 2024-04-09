import java.util.Scanner;
public class uselessStuff {
	public static void main(String[] args) {
		// stdin = scanner.in
		int total;
		Scanner stdin = new Scanner(System.in);
		int numberOfEmployees = stdin.nextInt();
		int payPerHour = 0;
		total = 0;
		int hours = 0;
		for (int j = 0; j < numberOfEmployees; j++) {
			payPerHour = stdin.nextInt();
			for(int i = 0; i < 5; i++) {
				hours += stdin.nextInt();
			}
			payPerHour *= hours;
			total = payPerHour;
			hours = 0;
		}
		System.out.println(total);
		// '3 4 5 5 5 5 5 5 4 4 4 4 4 100 1 0 0 0 0' 300 (4600)
		// 3 employees
		// 1st employee = 4 per hour
		// 5 hours per day ( 25 * 4 = 100)
		// 2nd employee = 5 per hour
		// 4 hours per day (20 * 5 = 100)
		// 3rd employee = 100 per hour
		// 1 hour on 1 day (100 * 1 = 100)
		
	}
}
