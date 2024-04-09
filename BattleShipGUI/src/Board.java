import java.util.Random;


public class Board {
	
	private Piece[][] grid;
	private int numSunk;
	private static Random random = new Random();
	public Board() {
		grid = new Piece[10][10];
		Water water = new Water();
		for(int i = 0; i<10; i++) {
			for(int j = 0; j<10; j++) {
				grid[i][j] = water;
			}
		}
		Ship[] ships = new Ship[5];
		ships[0] = new Ship("aircraft carrier", 5, 'A');
		ships[1] = new Ship("battleship", 4, 'B');
		ships[2] = new Ship("cruiser", 3, 'C');
		ships[3] = new Ship("submarine", 3, 'S');
		ships[4] = new Ship("pt boat", 2, 'P');
//		for(Ship s : ships) {
//			placeShips(s, water);
//		}
		for(Ship s : ships) {
			placeShip(s, water, random);
		}
//		grid[4][4] = grid[4][5] = grid[4][6] = grid[4][7] = grid[4][8] = ships[0];
//		grid[6][6] = grid[7][6] = grid[8][6] = grid[9][6] = ships[1];
//		grid[2][1] = grid[3][1] = grid[4][1] = ships[2];
//		grid[5][3] = grid[5][4] = grid[5][5] = ships[3];
//		grid[9][7] = grid[9][8] = ships[4];
		numSunk = 0;
	}
	
	public boolean gameOver() {
		return numSunk == 5;
	}
	
	public void fireAt(Coordinates coordinates) {
		Piece piece = grid[coordinates.x][coordinates.y];
		grid[coordinates.x][coordinates.y] = piece.fireAt();
		if(piece.isSunk()) {
			numSunk++;
		}
	}
	
	public void placeShips(Ship ship, Water water) {
		int size = ship.getSize();
		Random random = new Random();
		int direction = random.nextInt(4); // 0 = goes up, 1 = goes down, 2 = goes left, 3 = goes right
		int gridX = random.nextInt(10); // Starts here X
		int gridY = random.nextInt(10); // Starts here Y
		boolean testPlacement = false;
		while (!testPlacement) { // make sure ships can actually be placed there
			testPlacement = true;
			try {
				switch(direction) {
				case 0:
					for(int i = size; i > 0; i--) {
						if(grid[gridY-i][gridX] != water) {
							gridX = random.nextInt(10); // Starts here X
							gridY = random.nextInt(10); // Starts here Y
							testPlacement = false;
						}
					}
					break;
				case 1:
					for(int i = size; i > 0; i--) {
						if(grid[gridY+i][gridX] != water) {
							gridX = random.nextInt(10); // Starts here X
							gridY = random.nextInt(10); // Starts here Y
							testPlacement = false;
						}
					}
					break;
				case 2:
					for(int i = size; i > 0; i--) {
						if(grid[gridY][gridX-i] != water) {
							gridX = random.nextInt(10); // Starts here X
							gridY = random.nextInt(10); // Starts here Y
							testPlacement = false;
						}
					}
					break;
				case 3:
					for(int i = size; i > 0; i--) {
						if(grid[gridY][gridX+i] != water) {
							gridX = random.nextInt(10); // Starts here X
							gridY = random.nextInt(10); // Starts here Y
							testPlacement = false;
						}
					}
					break;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				gridX = random.nextInt(10); // Starts here X
				gridY = random.nextInt(10); // Starts here Y
				testPlacement = false;
			}
		}
		
		switch(direction) {
		case 0:
			for(int i = size; i > 0; i--) {
				grid[gridY-i][gridX] = ship;
			}
			break;
		case 1:
			for(int i = size; i > 0; i--) {
				grid[gridY+i][gridX] = ship;
			}
			break;
		case 2:
			for(int i = size; i > 0; i--) {
				grid[gridY][gridX-i] = ship;
			}
			break;
		case 3:
			for(int i = size; i > 0; i--) {
				grid[gridY][gridX+i] = ship;
			}
			break;
		}
		
	}
	
	private void placeShip(Ship ship, Water water, Random random) {
		Coordinates coordinates;
		boolean horizontal;
		do {
			coordinates = Coordinates.getRandomCoordinates(random);
			horizontal = random.nextBoolean();
		} while (!canPlace(ship, coordinates, horizontal, water));
		place(ship, coordinates, horizontal);
	}
	
	private void place(Ship ship, Coordinates coordinates, boolean horizontal) {
		int x = coordinates.x;
		int y = coordinates.y;
		
		for(int i = 0; i < ship.getSize(); i++) {
			if(horizontal)
				grid[y][x+i] = ship;
			else
				grid[y+i][x] = ship;
		}
	}
	
	private boolean canPlace(Ship ship, Coordinates coordinates, boolean horizontal, Piece water) {
		int x = coordinates.x;
		int y = coordinates.y;
		
		try {
			for(int i = 0; i < ship.getSize(); i++) {
				if(horizontal) {
					if(grid[y][x+i] != water )
						return false;
				} else {
					if(grid[y+i][x] != water )
						return false;
				}
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
		
		return true;
	}
	
	
	public String toString() {
		String s = "   A  B  C  D  E  F  G  H  I  J\n";
		for(int i = 0; i < 10; i++) {
			s+= String.format("%2d", (i+1));
			for(int j = 0; j <10; j++) {
				s+= " " + grid[i][j];
			}
			s+= "\n";
		}
		return s;
	}
	
	public Piece[][] returnGrid() {
		return grid;
	}
}
