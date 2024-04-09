import java.util.Scanner;

// Write a program to assign passengers seats in an airplane. Assume a small airplane with seat numberings as follows:
// 1 A B C D
// 2 A B C D
// 3 A B C D
// 4 A B C D
// 5 A B C D
// 6 A B C D
// 7 A B C D


public class airplaneCode {
	public static void main(String [] args) {
		String[][] airplane = {{"1", "A", "B", "C", "D"}, {"2", "A", "B", "C", "D"}, {"3", "A", "B", "C", "D"}, 
				{"4", "A", "B", "C", "D"}, {"5", "A", "B", "C", "D"}, {"6", "A", "B", "C", "D"}, {"7", "A", "B", "C", "D"}};
		Scanner s = new Scanner(System.in);
		String response = "";
		boolean seatsAvailable = false;
		
//		"A".compareTo("A");
//		System.out.println("\"A\".compareTo(\"A\") : " + "A".compareTo("A"));
//		"A".compareTo("B");
//		System.out.println("\"A\".compareTo(\"B\") : " + "A".compareTo("B"));
//		"A".compareTo("C");
//		System.out.println("\"A\".compareTo(\"C\") : "+ "A".compareTo("C"));
//		"A".compareTo("D");
//		System.out.println("\"A\".compareTo(\"D\") : "+ "A".compareTo("D"));
////		 (Math.abs("A".compareTo("D"))+1); str.substring(1)
//		System.out.println("(Math.abs(\"A\".compareTo(str.substring(1))+1)\") : "+ (Math.abs("A".compareTo("D"))+1));
		
		System.out.println("if(arr[row][col].equals(\"X\")) { \n\tSystem.out.println(\"This seat is already taken, try again!\");\n} else {\n\tarr[row][col] = \"X\";\n}");
		
		while(seatsAvailable) {
			
			for(int row = 0; row < airplane.length; row++) {
				for(int col = 0; col < airplane[row].length; col++) {
					System.out.print(airplane[row][col] + " ");
				}
				System.out.println();
			}
			System.out.println("Which seat would you like?");
			response = s.nextLine();
			if(response.equalsIgnoreCase("end")) {
				System.out.println("User ended program");
				seatsAvailable = false;
			}
			
			for(int row = 0; row < airplane.length; row++) {
				for(int col = 0; col < airplane[row].length; col++) {
					if(response.equalsIgnoreCase(row + airplane[row][col])) {
						System.out.println("seat " + response.toUpperCase() + " is all yours. Have a great day!");
						airplane[row][col] = "X";
						break;
					}
				}
//				"A".compareTo(str.substring(1,2));
				
				"A".compareTo("A");
				System.out.println("\"A\".compareTo(\"A\") : " + "A".compareTo("A"));
				"A".compareTo("B");
				System.out.println("\"A\".compareTo(\"B\") : " + "A".compareTo("B"));
				"A".compareTo("C");
				System.out.println("\"A\".compareTo(\"C\") : "+ "A".compareTo("C"));
			}
			
			System.out.println("\"" +  response + "\" is an invalid seat identifer");
			
		}
		
		s.close();
//		System.out.println("Thank you for playing AirPlane Seat Simulator! Have a great day!");
	}
}
