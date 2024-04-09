import java.util.Scanner; 
public class HotDogStandCopy2 {
 
  
  private int id = 0; 
  private int hotdogsSold = 0; 
  private static int totalHotDogsSold;             // sold among all stands 
    
    public HotDogStandCopy2(int id, int hotdogsSold) { 
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
	 HotDogStandCopy2 stand1 = new HotDogStandCopy2(0, 0); // 1111 is Stand ID and 10 is # of hotdogs sold at cart 
	 HotDogStandCopy2 stand2 = new HotDogStandCopy2(1, 0);
	 HotDogStandCopy2 stand3 = new HotDogStandCopy2(2, 0);
  
  //stand1.justSold();
  //stand1.justSold();
  //stand1.justSold();
  
  //stand2.justSold();
  //stand2.justSold();
  //stand2.justSold();
  //stand2.justSold();
  //stand2.justSold();
  
  //stand3.justSold();
  //stand3.justSold();
  
  //System.out.printf("%-10s%10s\n", "ID", "DogsSold");
  //System.out.println("---------------------");
  //System.out.printf("%-10d%10d\n", stand1.getid(), stand1.getHotDogsSold());
  //System.out.printf("%-10d%10d\n", stand2.getid(), stand2.getHotDogsSold());
  //System.out.printf("%-10d%10d\n", stand3.getid(), stand3.getHotDogsSold());
  
  
  // user input 
  Scanner scanner = new Scanner(System.in);
  String choice; 
//System.out.print("Enter commad:");
while (true) {  
System.out.print("Enter commad:");                        // First line of output 
choice = scanner.nextLine(); 
if (choice.equalsIgnoreCase("sold")) {
System.out.print("Enter Cart Number:"); 
int cartnumber = scanner.nextInt(); 
scanner.nextLine(); // added culprit
 if (cartnumber == 0){
stand1.justSold();          // print # sold at cart 
}
else if (cartnumber == 1) {
stand2.justSold();      // print # sold at cart  
}
else if (cartnumber == 2) {
stand3.justSold();      // print # sold at cart  
}

// System.out.printf("\n After the increment, address of the variable is %u, ptr"); // culprit 
}
if (choice.equalsIgnoreCase("Print")) {
System.out.print("Enter Cart Number:"); 
int cartnumber = scanner.nextInt();
scanner.nextLine(); // added culprit
if (cartnumber == 0){
System.out.print("Cart sold: " + stand1.getHotDogsSold());          // print # sold at cart 
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
scanner.nextLine(); 
}
 
if(choice.equalsIgnoreCase("Exit"))
System.exit(0); 
 }
// while (!choice.equalsIgnoreCase("stop"));
// System.out.println("\nEnter Command: " +  + "Enter Cart Number: " + "Enter Cart Sold: " + );    
// Enter Command: Enter Cart Number: Enter Cart Sold: 
 } 
 }
