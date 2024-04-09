package MouseMazeNew;
import java.util.Scanner;
import java.util.Stack;
// Mouse Maze Main
public class MouseMazeMain {

	public static void main(String[] args) {
		
		Maze maze = new Maze();
		Scanner scan = new Scanner(System.in);
		// Scan In Open Walls
		String input = "", coord1 = "", coord2 = "";
		boolean bool = true;
		boolean invalid = false;
		int wall = 0; // 0 for up, 1 for right, 2 for down, 3 for left
		System.out.println("Awaiting Input:");
		while(bool) {
			coord1 = ""; 
			coord2 = "";
			if(invalid) {
				System.out.println("Your input of : \"" + input + "\" is not a valid input.");
				System.out.println("A proper input is: \"A1 B1\" of two coordinates next to another.");
				invalid = false;
				continue;
			}
			// See if the input is of correct length
			input = scan.nextLine();
			if(input.equalsIgnoreCase("done")) {
				break;
			}
			if(input.equalsIgnoreCase("print")) {
				System.out.println(maze);
				continue;
			}
			
			// See if the input is a Coord "A1 B1" next to another Coordinate
			coord1 = input.substring(0, input.indexOf(" ")); // "A1"
			coord2 = input.substring(input.indexOf(" ") + 1); // "B1"
			
			char col1 = coord1.charAt(0); // 'A'
			char row1 = coord1.charAt(1); // '1'
			int col1Index = Character.getNumericValue(col1) - 10; // 'A' - 10 = 0;
			int row1Index = Character.getNumericValue(row1) - 1; // '1' - 1 = 0;
			
			char col2 = coord2.charAt(0); // 'B' OR 'A'
			char row2 = coord2.charAt(1); // '1' OR '2'
			int col2Index = Character.getNumericValue(col2) - 10; // 'B' - 10 = 1; OR 'A' - 10 = 0;
			int row2Index = Character.getNumericValue(row2) - 1; // '1' - 1 = 0; OR '2' - 1 = 1;
			
			if(coord1.endsWith("10")) {
				row1Index = 9;
			}
			if(coord2.endsWith("10")) {
				row2Index = 9;
			}
			// Check to verify that the two coordinates ARE next to each other.
			// I.g. is abs(col1-col2) <= 1 OR abs(row1-row2) <=1 (BUT not both equal to 0);
			if((Math.abs(col1Index-col2Index) > 1 || Math.abs(row1Index-row2Index) > 1 ) || (Math.abs(col1Index-col2Index) == 1 && Math.abs(row1Index-row2Index) == 1)) {
				System.out.println("Coords are not adajcent to each other");
				invalid = true;
				continue;
			}
			if((Math.abs(col1Index-col2Index) == 0 && Math.abs(row1Index-row2Index) == 0)) {
				System.out.println("Coords are the same");
				invalid = true;
				continue;
			}
			if((row1Index-row2Index) == -1) { // up
				wall = 0;
			} else if((col1Index-col2Index) == -1) { // 'A' - 'B' / right
				wall = 1;
			} else if (row2Index-row1Index == -1){ // down
				wall = 2;
			} else if ((col2Index-col1Index) == -1) { // left
				wall = 3;
			}
			
			switch(wall) {
				case 0: // Remove the wall between A1 A2 ~ coord1 BottomWall coord2 TopWall
						maze.setWall(row1Index, col1Index, 2, true); // A1's BottomWall
						maze.setWall(row2Index, col2Index, 0, true); // A2's topWall
						break;
				case 1: // Remove the wall between A1 B1 ~ coord1 RightWall coord2 LeftWall
						maze.setWall(row1Index, col1Index, 1, true); // A1's rightWall
						maze.setWall(row2Index, col2Index, 3, true); // B1's leftWall
						break;
				case 2: // Remove the wall between A2 A1 ~ coord1 TopWall coord2 BottomWall
						maze.setWall(row1Index, col1Index, 0, true); // A2's topWall
						maze.setWall(row2Index, col2Index, 2, true); // A1's bottomtWall	
						break;
				case 3: // Remove the wall between B1 A1 ~ coord1 LeftWall coord2 RightWall
						maze.setWall(row1Index, col1Index, 3, true); // B1's leftWall
						maze.setWall(row2Index, col2Index, 1, true); // A1's rightWall
						break;
				default:
						
						break;
			}
		}
		
		// Print Out the Maze to verify it is Correct
		System.out.println(maze);
		boolean[][] path = new boolean[10][10]; // The Path the user goes through
		Stack<Position> myStack = new Stack<>();
		myStack.push(maze.getPos(0,0));
		// NOW work on solver (Start at Last Saved current position
		Position currentPosition = myStack.peek();
		int previousPositionRow = 0;
		int previousPositionColumn = 0;
		int direction = 0; // 0 for up, 1 for right, 2 for down, 3 for left
		path[0][0] = true;
		while(!(currentPosition.equals(maze.getPos(9, 9)))) {
			currentPosition = myStack.peek();
			switch(currentPosition.getDirection()) {
				case 0: // up 
					if(currentPosition.getTopWall()) { // No wall is there
						
						if(path[currentPosition.getRow()-1][currentPosition.getColumn()] == true) { // Already attempted this path
							
						} else { // Have not attempted this path
							myStack.push(maze.getPos(currentPosition.getRow()-1, currentPosition.getColumn()));
							path[currentPosition.getRow()-1][currentPosition.getColumn()] = true;
						}
					} else { // A Wall is there
						currentPosition.setDirection(1);
					}
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				default:
					break;
			}
			
			
			
		}
		
	}

}
