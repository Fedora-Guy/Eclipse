package MouseMazeNew;

public class Position {
	
	private boolean topWall = false;
	private boolean rightWall = false; // False means there is a wall
	private boolean bottomWall = false;
	private boolean leftWall = false;
	private int direction = 0;
	private String coord;
	private int row = 0;
	private int column = 0;
	
	public Position(String coord, int row, int column) {
		this.coord = coord;
		this.row = row;
		this.column = column;
	}
	
	public boolean getTopWall() {
		return topWall;
	}
	
	public boolean getRightWall() {
		return rightWall;
	}
	
	public boolean getBottomWall() {
		return bottomWall;
	}
	
	public boolean getLeftWall() {
		return leftWall;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public String getCoord() {
		return coord;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setTopWall(boolean state) {
		topWall = state;
	}
	
	public void setRightWall(boolean state) {
		rightWall = state;
	}
	
	public void setBottomWall(boolean state) {
		bottomWall = state;
	}
	
	public void setLeftWall(boolean state) {
		leftWall = state;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public String toString() {
		return coord;
	}
}
