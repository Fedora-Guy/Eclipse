import java.util.Scanner;

public class HotDogStand {
	private int hotDogStandID;
	private int hotDogsSold;
	private static int totalHotDogsSold = 0;
	
	public HotDogStand (int a, int b) {
		hotDogStandID = a;
		hotDogsSold = b;
	}
	
	public void justSold() {
		hotDogsSold++;
		totalHotDogsSold++;
	}
	
	public int getSold() {
		return hotDogsSold;
	}
	
	public static int getTotalHotDogsSold() {
		return totalHotDogsSold;
	}
	
	public static void main(String[] args){ 
		String response = "";
		int cartNumber;
		HotDogStand hDS1 = new HotDogStand(0, 0);
		HotDogStand hDS2 = new HotDogStand(1, 0);
		HotDogStand hDS3 = new HotDogStand(2, 0);
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter commad:");
			response = s.nextLine();
			
			if(response.equals("sold")) {
				System.out.print("Enter Cart Number:");
				cartNumber = s.nextInt();
				s.nextLine();
				
				if(cartNumber == 0) {
					hDS1.justSold();
				} else if (cartNumber == 1) {
					hDS2.justSold();
				} else if (cartNumber == 2) {
					hDS3.justSold();
				} 
			} else if (response.equals("print")) {
				System.out.print("Enter Cart Number:");
				cartNumber = s.nextInt();
				s.nextLine();
				
				if(cartNumber == 0) {
					System.out.print("Cart sold: " + hDS1.getSold());
				} else if (cartNumber == 1) {
					System.out.print("Cart sold: " + hDS2.getSold());
				} else if (cartNumber == 2) {
					System.out.print("Cart sold: " + hDS3.getSold());
				} 
			} else if (response.equals("print-all")) {
				System.out.print("Total sold: " + getTotalHotDogsSold());
			} else {
				System.exit(0);
			}
			
			
			
		}
		
		
		
	}
	
	
	
}