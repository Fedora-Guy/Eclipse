
public class SudokuSolver {
	
	private int[][] grid = new int[9][9];
	private int[][] duplicateGrid = new int[9][9];
	private int[] cellData = new int[81];
	private int[][] columnData = new int[9][9];
	private int[][] rowData = new int[9][9];
	private int[][][] boxData = new int[9][3][3];
	
	public SudokuSolver(int[][] grid) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				this.grid[i][j] = grid[i][j];
				duplicateGrid[i][j] = 0;
				cellData[(i * grid.length)+j] = 0;
				columnData[i][j] = 0;
				rowData[i][j] = 0;
				for(int k = 0; k < 9; k++) {
						boxData[k][i%3][j%3] = 0;
				}
			}
		}
	}
	
	// SUDOKU BOARD FOR TESTING
	/*Rows					Columns			[i][]
	 * 		0	1	2		3	4	5		6	7	8 
	 * 		Box 0			Box 3			Box 6
	 * 	0	0	9	18		27	36	45		54	x	x
	 * 	1	x	x	x		x	1	x		x	x	x
	 * 	2	x	x	x		x	x	x		x	x	x
	 * 		Box 1			Box 4			Box 7
	 * 	3	3	12	x		30	39	x		57	x	x
	 * 	4	x	x	x		31	40	x		x	x	x
	 * 	5	x	x	x		32	41	x		x	x	x
	 * 		Box 2			Box 5			Box 8
	 * 	6	6	15	x		33	x	x		x	x	x
	 * 	7	x	x	x		x	x	x		x	x	x
	 *  8	x	x	x		x	x	x		x	x	x
	 * []
	 * [j]
	 */
	
	public int[][] Solve() {
		boolean possibleSolution = false;
		
		while(possibleSolution != true) {
			
			// Attempt 1: Check each Digit, see if there are any spots where a digit has to be.
			// Check each cell for where each number is.
			
			for(int i = 0; i < 9; i++) { 
				for(int j = 0; j < 9; j++) {
					if(grid[i][j] != 0) {
						
						// COLUMN
						columnData[i][j] = grid[i][j];
						// Make sure this digit doesn't already exist Above or Below it.
						for(int k = 0; k < 9; k++) {
							if(columnData[i][j] == columnData[i][k] && j != k) {
								System.out.println("Duplicate in Column: " + i + " error: " + columnData[i][j]);
								duplicateGrid[i][j] = columnData[i][j];
								duplicateGrid[i][k] = columnData[i][k];
							}
						}
						// ROW
						rowData[i][j] = grid[i][j];
						// Make sure this digit doesn't already exist to the Left or Right of it.
						for(int k = 0; k < 9; k++) {
							if(rowData[i][j] == rowData[k][j] && i != k) {
								System.out.println("Duplicate in Row: " + j + " error: " + rowData[i][j]);
								duplicateGrid[i][j] = rowData[i][j];
								duplicateGrid[k][j] = rowData[k][j];
							}
						}
						// BOX
						// (( ( i * 9 + j) - (j % 3 + (i % 3) * 9) ) / 3) % 3 + (i - (i%3)) - BOX ID
						int x = (( ( i * 9 + j) - (j % 3 + (i % 3) * 9) ) / 3) % 3 + (i - (i%3));
						boxData[x][i%3][j%3] = grid[i][j];
						// Make sure this digit doesn't already exist in it's current box.
						for(int k = 0; k < 3; k++) {
							for(int l = 0; l < 3; l++) {
								if((boxData[x][i%3][j%3] == boxData[x][k%3][l%3]) && i%3 !=k && j%3 != l) {
									System.out.println("Duplicate in Box: " + x + " error: " + boxData[x][i%3][j%3]);
									duplicateGrid[i][j] = boxData[x][i%3][j%3];
									duplicateGrid[i][j] = boxData[x][k%3][l%3];
									 System.out.println("Conflicting i: " + i + ", j: " + j);
									 System.out.println("Conflicting k: " + k + ", l: " + l);
									// System.out.println("Problem children: " + boxData[x][i%3][j%3] + ", " + boxData[x][k%3][l%3]);
								}
							}
						}
						
						cellData[(i * grid.length)+j] = grid[i][j];
						
					}
				}
			}

			
			possibleSolution = true;
		}
		int[][] newGrid = new int[18][9];
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 9; j++) {
				if(i < 9) {
					newGrid[i][j] = grid[i][j];
				} else if (i >= 9) {
					newGrid[i][j] = duplicateGrid[i-9][j];
				}
			}
		}
		return newGrid;
	}
}
