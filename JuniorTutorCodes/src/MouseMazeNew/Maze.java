package MouseMazeNew;

public class Maze {
	
	private Position[][] grid;
	// [i][j] : i = Row, j = Column
	public Maze() {
		grid = new Position[10][10];
		fillMaze();
	}
	
	public Maze(int length, int height) {
		grid = new Position[length][height];
		fillMaze();
	}
	
	public Position getPos(int i, int j) {
		return grid[i][j];
	}
	
	private void fillMaze() {
		String coord = "A1"; // A1 B1 C1 D1 
		String firstPosition = "A";
		String secondPosition = "1";
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				//firstPosition;
				
				coord = Character.toString(firstPosition.codePointAt(0) + j) + Integer.toString(i+1); // Increments Column
				if(Integer.toString(i+1).equals("10")) {
					coord = coord.substring(0, 1) + "0";
				}
				grid[i][j] = new Position(coord, i, j);
				//System.out.print(grid[i][j] + " ");
			}
			//System.out.println("");
		}
	}
	
	public String toString() {
		String output = "\n\t";
		
		char column = 'A';
		char row = '1';
		for(int k = 0; k < grid[0].length; k++) { // Top level of Column
			output += " " + column + "  ";
			column++;
		}
		output += "\n";
		output += "       +";
		for(int i = 0; i < grid.length; i++) {
			if(i == grid.length - 1) {
				output += "---+";
			} else {
				output += "----";	
			}
		}
		output += "\n";
		for(int i = 0; i < grid.length; i++) {
			if(i+1 == 10) {
				output += "     " + (i+1) + "|"; // \b \t \n \f \r
			} else {
				output += "      " + (i+1) + "|"; // \b \t \n \f \r
			}
			
			for(int j = 0; j < grid[i].length; j++) {
				
				//output += grid[i][j]; // Coordinate
				output += "   ";
				if(grid[i][j].getRightWall() == true) { // True means has no Right wall
					output += " ";
				} else {
					if(j == grid[i].length -1) { // Far Right Wall
						
					} else { // Not the Far Right Wall
						output += "|";
					}
					
				}
			}
			// Is there a Vertical Wall? Check for each coordinate ABOVE
			output += "|\n       ";
			for(int j = 0; j < grid[i].length; j++) {
				if(i == grid.length - 1) {
					if(j == grid[i].length-1) {
						output += "---+";
					} else if (j == 0) {
						output += "+----";
					} else {
						output += "----";
					}
					continue;
				}
				if(j == 0) {
					output += "|";
				}
				if(grid[i][j].getBottomWall() == true) { // There is NO Bottom Wall
					if(j == grid[i].length-1) {
						output += "   |";
					} else {
						output += "   +";
					}
				} else {
					if(j == grid[i].length-1) {
						output += "---|";
					} else {
						output += "---+";	
					}
					
				}
			}
			output += "\n";
		}
		
		return output;
	}
	
	public void setWall(int i, int j, int wall, boolean state) {
		if(wall == 0) {
			grid[i][j].setTopWall(state);
		} else if(wall == 1) {
			grid[i][j].setRightWall(state);
		} else if(wall == 2) {
			grid[i][j].setBottomWall(state);
		} else if (wall == 3) {
			grid[i][j].setLeftWall(state);
		}
	}
}
