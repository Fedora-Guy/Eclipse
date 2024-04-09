package tutoring_KeithReis;
import java.util.Scanner;

public class MouseMazeSolver {
	
	public static void main(String[] args) {
		
		boolean[][] board = new boolean[10][10];
		for(int i = 0; i < board.length;i++) {
			for(int j = 0; j < board[i].length; j++) {
					board[i][j] = false;
			}
		}
		Scanner scan = new Scanner(System.in);
		String s;
		board[2][2] = true; 
		while(true) {
			
			s = scan.nextLine();
			if(s.equalsIgnoreCase("done")) {
				break;
			}
			if(s.length() < 5) {
				System.out.println("Input a grid coordinate: \"A1_B2\"");
				continue;
			}
			String coord1 = s.substring(0,2); // A1
			String coord2 = s.substring(3,5); // A2 OR B1
			System.out.println(coord1 + "\n" + coord2);
			
			// Get the wall between the two Coords, change to true.
			// A = 0; B = 1; C = 2; ...; J = 9 - Column
			// 1 = 0; 2 = 1; 3 = 2; ...; 10 = 9 - Row
			//coord1 = coord1.toUpperCase();
			//board[(coord1.charAt(0))][(coord1.charAt(1))] = true;
			//char test = 't';
			
			char col1 = coord1.charAt(0);
			char row1 = coord1.charAt(1);
			int col1Index = Character.getNumericValue(col1) - 10;
			int row1Index = Character.getNumericValue(row1) - 1;
			
			char col2 = coord2.charAt(0);
			char row2 = coord2.charAt(1);
			int col2Index = Character.getNumericValue(col2) - 10;
			int row2Index = Character.getNumericValue(row2) - 1;
			
			// Check to verify that the two coordinates ARE next to each other.
			// I.g. is abs(col1-col2) <= 1 OR abs(row1-row2) <=1 (BUT not both equal to 0);
			if((Math.abs(col1Index-col2Index) > 1 || Math.abs(row1-row2) > 1 ) || (Math.abs(col1Index-col2Index) == 1 && Math.abs(row1Index-row2Index) == 1)) {
				System.out.println("Coords are not adajcent to each other");
				continue;
			}
			if((Math.abs(col1Index-col2Index) == 0 && Math.abs(row1Index-row2Index) == 0)) {
				System.out.println("Coords are the same");
				continue;
			}
			// Is this a Column (|) Or Row (---) Wall Change
			System.out.println(col1Index + " " + row1Index + " ; " + col2Index + " " + row2Index);
			System.out.println();
			board[col1Index][row1Index] = true;
			board[col2Index][row2Index] = true;
		}
		
		PrintBoard(board);
		scan.close();
	}
	
	public static void PrintBoard(boolean board[][]) {
		int column = 0;
		int row = 0;
		// Top Row of Characters
		char currentLetter = 'A';
		System.out.print("\t");
		for(int i = 1 ; i < board.length * 3; i++) {
			if(i%3 == 2) {
				System.out.print(currentLetter);
				currentLetter++;
			} else { 
				System.out.print(" ");
			}
		}
		System.out.println("");
		// Top Row of Dashes
		System.out.print("\t");
		for(int i = 0 ; i < board.length * 3; i++) {
			System.out.print("-");	
		}
		System.out.println();
		
		for(int i = 0; i <board.length; i++) { // column
			column = i;
			// Displays COORD and WALL
			if((i+1) < 10 ) {
				System.out.print( (i+1) + " \t");
			} else if((i+1) == 10) {
				System.out.print( (i+1) + "\t");
			}
				
				
			for(int j = 0; j < board[i].length; j++) { // row
				row = j;
				// Displays TRUE/FALSE AND VERTICAL WALL
				if(j == 0) {
					System.out.print("|");
				}
				if(board[i][j]) {
					if( j != 9 && board[i][j+1]) {
						System.out.print("  ");	
					} else {
						System.out.print("  |");
					}
						
				} else {
					if( j == 9) {
						System.out.print("f ");
					} else { 
						System.out.print("f |");
					}
				}
				if(j == 9) {
					System.out.print("|");
				}
			}	
			System.out.println("");
			System.out.print("\t");
			// DASHES OF HORIZONTAL WALLS
			if(i != board.length - 1) {
				for(int j = 0 ; j < board.length; j++ ) {
					System.out.print("-");
					System.out.print("-");
					System.out.print("-");
				}
			}
			
			System.out.println("");
		}
		
		// Bottom Row of Dashes
		System.out.print("\t");
		for(int i = 0 ; i < board.length * 3; i++) {
			System.out.print("-");	
		}
		System.out.println();
	}
}
