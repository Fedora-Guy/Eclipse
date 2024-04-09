import java.util.Scanner;
public class PhoneNumber {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		String phoneNumber0;
		
		System.out.println("Enter a phone number with Letters"); // i.g. 555-GET-FOOD
		phoneNumber0 = kb.nextLine();
		phoneNumber0 = phoneNumber0.toUpperCase();
		phoneNumber0 = fill_Number(phoneNumber0); // Change to phoneNumber0
		System.out.print("Phone number: " + phoneNumber0); // Change to phoneNumber0 
		kb.close(); // not needed, but removes a warning.
	}
	
	public static String fill_Number(String phoneNumber0) {
		char ch = '_'; // Set it to this
		long phoneNumberFinal = 0;
		String phoneNumber = ""; // Add this
		
		for(int i = 0; i < phoneNumber0.length(); i++) {
			ch = phoneNumber0.charAt(i);
			if(Character.isLetter(ch)) {
				switch(ch) {
					case 'A': case 'B': case 'C' : phoneNumberFinal = 2; break;
					case 'D': case 'E': case 'F' : phoneNumberFinal = 3; break;
					case 'G': case 'H': case 'I' : phoneNumberFinal = 4; break;
					case 'J': case 'K': case 'L' : phoneNumberFinal = 5; break;
					case 'M': case 'N': case 'O' : phoneNumberFinal = 6; break;
					case 'P': case 'Q': case 'R' : case 'S' : phoneNumberFinal = 7; break;
					case 'T': case 'U': case 'V' : phoneNumberFinal = 8; break;
					case 'W': case 'X': case 'Y' : case 'Z' : phoneNumberFinal = 9; break;
				}
				phoneNumber += phoneNumberFinal; // Change the statement to this
			}
			else if(Character.isDigit(ch)) {
				phoneNumber += ch; // Change the statement to this
			}
			else {
				phoneNumber += "-"; // Change the statement to this
			}
		}
		return phoneNumber; // Change the statement to this
	}
}
