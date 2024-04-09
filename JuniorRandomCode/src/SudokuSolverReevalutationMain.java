import java.util.Scanner;

public class SudokuSolverReevalutationMain {
	
	public static void main(String[] args) {
		
		// Steps:
		// 1. Create Sudoku grid
		// 2. Fill it in with known values
		// 3. Test for valid grid
		// 4. Start solution process
		// 5. Test if solution is valid
		// 6. Repeat step 4 until 5 is true
		// 7. Output Grid
		
		// [Row][Column]; 0-8
		int[][] SudokuGrid = new int[9][9];
		
		// Set all values of Grid to 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				SudokuGrid[i][j] = 0;
				if(j == 2) {
					SudokuGrid[i][j] = 0;
				}
			}
		}
		SudokuGrid[1][0] = 0;
		SudokuGrid[2][0] = 0;
		print(SudokuGrid);
		
		// Step 2 ~ Fill it in with known values
		SudokuGrid = getNumbers(SudokuGrid);
		print(SudokuGrid);
		
		// Step 3 ~ Test if it is currently a valid grid
		System.out.print(validGrid(SudokuGrid));
	}
	
	// Print out SudokuGrid
	public static void print(int[][] SudokuGrid) {
		// Print out SudokuGrid
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(SudokuGrid[i][j]);
				if((j+1) % 3 == 0 && j != 8) {
					System.out.print(" | ");
				}
			}
			
			System.out.println();
			if((i+1) % 3 == 0) {
				System.out.println("---------------");
			}
			
		}
	}
	
	public static int[][] getNumbers(int[][] SudokuGrid) {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		System.out.println("Input each number in this order: \"X Y Number\"");
		System.out.println("Type \"Done\" when all numbers have been inserted");
		while(true) {
			int x = -1, y = -1, number = -1;
			String currentLine = scan.nextLine();
			if(currentLine.equalsIgnoreCase("Done")) {
				break;
			}
			for(char a : currentLine.toCharArray()) {
				if(Character.isDigit(a)) {
					if(x == -1) {
						x = Character.digit(a, 10);
					} else if(y == -1) {
						y = Character.digit(a, 10);
					} else {
						number = Character.digit(a, 10);
					}
				}
				
			}
			if( (x >= 0 && x < 9) && (y >= 0 && y < 9) && (number >= 1 && number <= 9)) {
				SudokuGrid[x][y] = number;
			}
		}
		print(SudokuGrid);
		System.out.println("If the outputted Grid does not match, type \"Redo\"");
		System.out.println("Otherwise, please type \"Done\" again");
		while(!done) {
			String newLine = scan.nextLine();
			if(newLine.equalsIgnoreCase("Done")) {
				scan.close();
				return SudokuGrid;
			} else if (newLine.equalsIgnoreCase("Redo")) {
				return getNumbers(SudokuGrid);
			} else {
				System.out.println("Please use either \"Done\"or \"Redo\". \'" + newLine + "\' is not a value answer");
			}
		}
		scan.close();
		return new int[0][0];
	}
	
	public static boolean validGrid(int[][] SudokuGrid) 
	{
		boolean valid = true;
		
		// Check if there are more than 9 of any numbers
		for(int number = 1; number <= 9; number++) { 
			int amountNumber = 0;
			for(int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(SudokuGrid[i][j] == number) {
						amountNumber++;
					}
				}
			}
			if(amountNumber > 9) {
				valid = false;
			}
		}
		
		// Check if there are any duplicate numbers in the same ROW [x]
		for(int number = 1; number <= 9; number++) {
			int amountNumber = 0;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(SudokuGrid[i][j] == number) {
						amountNumber++;
					}
				}
				if(amountNumber > 1) {
					valid = false;
				}
				amountNumber = 0;
			}
		}
		
		// Check if there are any duplicate numbers in the same COLUMN [y]
		for(int number = 1; number <= 9; number++) {
			int amountNumber = 0;
			for(int j = 0; j < 9; j++) {
				for(int i = 0; i < 9; i++) {
					if(SudokuGrid[i][j] == number) {
						amountNumber++;
					}
				}
				if(amountNumber > 1) {
					valid = false;
				}
				amountNumber = 0;
			}
		}
		
		// Check if there are any duplicate numbers in the same BOX
		/*
		 * Box Numbers:
		 * 0 | 1 | 2
		 * 3 | 4 | 5
		 * 6 | 7 | 8
		 *  
		 * 0,0 0,1 0,2 | 0,3 0,4 0,5 |
		 * 1,0 1,1 1,2 | 1,3 1,4 1,5 |
		 * 2,0 2,1 2,2 | 2,3 2,4 2,5 |
		 */
		
		// set up a Box Array [Box #] [Each number in the box]
		int[][] SudokuBox = new int[9][9];
		for(int box = 0; box < 9; box++) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					
					SudokuBox[box][j] = SudokuGrid[i][j];
				}
			}
		}
		
		
		for(int number = 1; number <= 9; number++) {
			for(int box = 0; box < 9; box++) {
				for(int i = 0; i < 9; i++) {
					if(SudokuBox[box][i] == number) {
						
					}
				}
				
			}
		}
		
		if(valid) {
			return true;
		} else {
			return false;
		}
	}
	
}
