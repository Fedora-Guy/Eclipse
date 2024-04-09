import java.util.Scanner;

public class InflationCalculator {
	public static void main (String[] args) {
		
//		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter price of the Item:");
		double priceOfItem = 50.0;
//		s.nextLine();
		
		System.out.println("Enter number of years in which it will be purchased:");
		double numberOfYears = (double)5;
//		s.nextLine();
		
		System.out.println("Enter percent of inflation per year:");
		double percentInflation = 7.0;
		
//		s.nextLine();
		
		
		double price = priceOfItem;
		
		for(double i = 0; i < numberOfYears; i ++) {
			double price2 = price;
			price = (price2 * percentInflation*0.01) + price2;
		}

		System.out.println(price);
			
//		s.close();
		
	}
}