import java.util.Scanner; 
public class HotDogStandCopy {
 
  
  private int id = 0; 
  private int hotdogsSold = 0; 
  private static int totalHotDogsSold;             // sold among all stands 
    
    public HotDogStandCopy(int id, int hotdogsSold) { 
    this.id = id; 
    this.hotdogsSold = hotdogsSold; 
    totalHotDogsSold += hotdogsSold; 
  }
  
  public void justSold() { 
    hotdogsSold++; 
    totalHotDogsSold++; 
  }
  public int getHotDogsSold() {
        return hotdogsSold; 
  }
  
  public static int getTotalHotDogsSold() { 
        return totalHotDogsSold;
  }
public int getid() {
return id;
  }
public static void main(String[] args) {
	HotDogStandCopy stand1 = new HotDogStandCopy(0, 0);  
	HotDogStandCopy stand2 = new HotDogStandCopy(1, 0);
	HotDogStandCopy stand3 = new HotDogStandCopy(2, 0);
	
	// user input 
	Scanner scanner = new Scanner(System.in);
	String choice; 
	while (true) {  
		System.out.print("Enter commad:");                        // First line of output 
		choice = scanner.nextLine(); 
		if (choice.equalsIgnoreCase("sold")) {
			System.out.print("Enter Cart Number:"); 
			int cartnumber = scanner.nextInt();
			scanner.nextLine();
			if (cartnumber == 0){
				 stand1.justSold();
			 }
			 else if (cartnumber == 1) {
				 stand2.justSold();			 }
			 else if (cartnumber == 2) {
				 stand3.justSold();	
			 }
		} else if (choice.equalsIgnoreCase("Print")) {
			System.out.print("Enter Cart Number:"); 
			 int cartnumber = scanner.nextInt();
			scanner.nextLine();
			 if (cartnumber == 0){
				 System.out.print("Cart sold: " + stand1.getHotDogsSold());
			 }
			 else if (cartnumber == 1) {
				 System.out.print("Cart sold: " + stand2.getHotDogsSold());      // print # sold at cart  
			 }
			 else if (cartnumber == 2) {
				 System.out.print("Cart sold: " + stand3.getHotDogsSold());      // print # sold at cart  
			 }
		 }
		 if (choice.equalsIgnoreCase("print-all")) {
			 System.out.print("Total sold: " + totalHotDogsSold); 
		 }
		if(choice.equalsIgnoreCase("Exit")) {

		}
	 }
 }
}