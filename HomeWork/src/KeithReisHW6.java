
public class KeithReisHW6 {
	public static void main(String [] args) {
		// Question 1
		
		// My Birthday month
		int birthdayMonth = 10;
		// Summer Vacation months
		int summerVacation1 = 7;
		int summerVacation2 = 8;
		
		for(int i = 1; i <= 12; i++) {
			System.out.println("Month " + i);
			if(i == birthdayMonth) {
				System.out.println("My birthday is in this month!!!");
			}
			if(i == summerVacation1 || i == summerVacation2) {
				System.out.println("Summer Vacation!!!");
			}
		}
	}
}
