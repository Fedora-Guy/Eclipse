import java.util.Scanner;

public class ImportImages {
	
	private Scanner scan = new Scanner(System.in);
	private String importing = "";
	
	public ImportImages() {
		System.out.println("Do you wish to import images? \"Yes\" or \"No\"");
		while(scan.hasNextLine()) {
			String response = scan.nextLine();
			if(response.equalsIgnoreCase("Yes")) {
				System.out.println("Gotcha");
				importing = "Yes";
				break;
			} else if (response.equalsIgnoreCase("No")) {
				System.out.println("Okay, running program.");
				importing = "No";
				break;
			} else {
				System.out.println("Please respond with either \"Yes\" or \"No\"");
			}
		}
		
	}
	
	
	
}
