/* Name: Keith Reis
 * Program Name: HexagonalPuzzle
 * Due Date: 2/5/24
 * Description: Solve a 18 hexagonal puzzle Using A* (1) and Iterative-Deepening (2)
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

// Changes from last submission:
// I cleaned up Old Code/Comments. 
// Made a few changes to Main, but nothing to any Algorithm
// Added new comments to explain changes from original code

//TODO
// 1. To solve using A* use String "Astar" or "A*"
// 2. To solve using Iterative-Deepening use String "IDS"
// 2. To solve using Iterative-Deepening A* use String "IDAstar" or "IDA*" (might not work as intended)

public class Board {
	
	// Grid Layout
	//   x x x
	//  x 0 1 x
	// x 4 0 5 x
	//  x 3 2 x
	//   x x x
	
	// 	Print Out:
	//
	// 		1	2	3
	//	  4	  5	  6	  7
	//	8	9	x	10	11
	//	  12  13  14  15
	//		16	17	18 
	final static int SIZE = 18;
	final static int[] dxArray = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
	final static int[] dyArray = {2, 4, 6, 1, 3, 5, 7, 0, 2, 4, 6, 8, 1, 3, 5, 7, 2, 4, 6};
	static int dx = 0;
	static int dy = 0;
	static int distance = 0;
	int tiles[];
	int blankPos;
	private final static int[] opp = {3, 2, 1, 0, 5, 4}; 
	// UpRight, UpLeft, DownRight, DownLeft, Left, Right 0 1 2 3 4 5
	// DownLeft, DownRight, UpLeft, UpRight, Right, Left 3 2 1 0 5 4
	
	public Board(int[] tiles) {
		this.tiles = Arrays.copyOf(tiles, tiles.length);
		for(int i = 0; i < this.tiles.length; i++) {
			if(this.tiles[i] == 0) {
				blankPos = i;
				return;
			}
		}
	}
	
	public Board(int tiles[], int blankPos) {
		this.tiles = Arrays.copyOf(tiles, tiles.length);
		this.blankPos = blankPos;
	}
	
	public static void main(String[] args) {
		int[] x = new int[SIZE+1];
		for(int i = 0; i <= SIZE; i++) {
			if(i == 9) {
				x[i] = 0; // BlankPosition
			} else if ( i > 9) {
				x[i] = i; // 1 - 9
			} else {
				x[i] = i+1; // 10-18
			}
		}
		
		Board goal = new Board(x);		
		
        //   																 h   |   moves   |  A* ms     | ids ms   | ida* ms  |
		// int[] puzzle1 = 2 4 3 1 0 7 10 8 9 6 5 11 12 13 14 15 16 17 18 // h: 9  | moves: 10 | ms: 9      | ms: 168  | ms: 119  |
		// int[] puzzle2 = 1 5 10 0 16 2 3 4 14 13 17 11 12 8 6 18 7 15 9 // h: 28 | moves: 36 | ms: 1205   | ms:      | ms:      |
		// int[] puzzle3 = 17 7 18 10 6 14 15 5 1 0 8 9 13 12 3 16 2 4 11 // h: 45 | moves: 51 | ms: 27350  | ms:      | ms:      |
		// int[] puzzle4 = 7 18 10 1 5 12 8 16 14 17 11 4 13 2 3 6 9 15 0 // h: 41 | moves: 50 | ms: 164226 | ms:      | ms:      |
		// int[] puzzle5 = 7 2 15 9 1 3 16 4 12 10 5 11 14 8 13 6 0 17 18 // h: 25 | moves: 38 | ms: 95839  | ms:      | ms:      |
		// int[] puzzle6 = 15 13 16 12 11 8 10 7 18 2 17 1 6 14 3 4 9 0 5 // h: 51 | moves: ?? 80267; 61105

		int[] inputtedPuzzle = new int[SIZE+1];
		String inString = "";
		
		//System.out.println("Input Array of Board in a singular line separated by spaces, with the blankPos marked as 0 ");
		Scanner scan = new Scanner(System.in);
		if(scan.hasNext()) {
			inString = scan.nextLine();
		}
		boolean acceptedArray = false;
		while(!acceptedArray) {
			String[] stringList = inString.split(" ");
			if(stringList.length != SIZE+1) {
				System.out.println("You did not include the correct number of integers. Please try again: ");
				inString = scan.nextLine();
				continue;
			}
			acceptedArray = true;
			for(int i = 0; i <= SIZE; i++) {
				int currentNumber = Integer.parseInt(stringList[i]);
				if(currentNumber > 18 || currentNumber < 0) {
					System.out.println("You included a number that is larger than 18 or smaller than 0. Please try again: ");
					acceptedArray = false;
				}
				for(int j = 0 ; j < i; j++) {
					if(inputtedPuzzle[j] == currentNumber) {
						System.out.println("You included the number \"" + currentNumber + "\" twice. Please try again: ");
						acceptedArray = false;
					}
				}
				inputtedPuzzle[i] = currentNumber;
			}
			if(acceptedArray == false) {
				inString = scan.nextLine();
			}
		}
		
		Board newBoard = new Board(inputtedPuzzle);
		/* System.out.print("Respond (Yes/No) if this is your intended board:");
		 System.out.println(newBoard);
		while(true) {
			if(scan.hasNext()) {
				inString = scan.nextLine();
			}
			if(inString.equalsIgnoreCase("No") || inString.equalsIgnoreCase("N")) {
				System.out.println("Please restart the program, and input your board again.");
				System.exit(0);
			} else if (inString.equalsIgnoreCase("Yes") || inString.equalsIgnoreCase("Y")) {
				break;
			} else {
				System.out.println("Please enter either a \"Yes\" or a \"No\".");
				continue;
			}
		}
		
		
		System.out.println("Which Algorithm are you using to solve this puzzle?"
				+ "\n(A*, IDS, IDA*)");
		if(scan.hasNext()) {
			inString = scan.nextLine();
		}
		
		boolean astarAlgorithm = false, idsAlgorithm = false, idastarAlgorithm = false, acceptedString = false;
		while(!acceptedString) {
			if(inString.equalsIgnoreCase("A*") || inString.equalsIgnoreCase("Astar")) {
				astarAlgorithm = true;
				acceptedString = true;
			} else if (inString.equalsIgnoreCase("IDS")) {
				idsAlgorithm = true;
				acceptedString = true;
			} else if (inString.equalsIgnoreCase("IDA*") || inString.equalsIgnoreCase("IDAstar") || inString.equalsIgnoreCase("IDA")) {
				idastarAlgorithm = true;
				acceptedString = true;
			} else {
				System.out.println("Your answer of \"" + inString + "\" was not a valid answer. "
						+ "\nPlease use either \"Astar\" or \"A*\" for Astar."
						+ "\nPlease use \"IDS\" for Iterative-Deepening."
						+ "\nPlease use \"IDAstar\" or \"IDA*\" for Iterative-Deepening A*.");
				inString=scan.nextLine();
			}
		}
		scan.close();
		*/
		Long StartTime = System.currentTimeMillis();
		/*
		if(idsAlgorithm) { // idsAlgorithm
			ids(newBoard, goal, 0);
		} else if (idastarAlgorithm) { //idastarAlgorithm
			ids(newBoard, goal, h(newBoard,goal));
		} else if (astarAlgorithm) { //astarAlgorithm
			astar(newBoard, goal);
		}
		*/
		astar(newBoard, goal);
		Long StopTime = System.currentTimeMillis();
		System.out.println((StopTime - StartTime) + " miliseconds");
	}
	
	public static int ids(Board r, Board goal, int initialValue) {
		// This is Iterative Deepening, not IDA*.
		// To change this to IDA*, change the initial value of limit to h(r,goal).
		// Also, keep track of the f-values of nodes that were cut-off during bounded DFS, and use the smallest of those f-values
		// as the new limit.
		for(int limit=initialValue;;limit++) {
			System.out.print(limit + " ");
			int result = bdfs(r, goal, limit);
			if(result != 1) {
				System.out.println();
				return result;
			} 
		}
	}
	
	public static int bdfs(Board r, Board goal, int limit) {
		// returns 0: failure, 1: cutoff, 2: success
		if(r.equals(goal)) {
			return 2;
		}
		else if(limit == 0) {
			return 1;
		}	
		else {
			boolean cutoff = false;
			for(int i=0; i<6; i++) {	// Changed from 4 to 6
				if(r.moveActions[i].valid()) {
					r.moveActions[i].move();
					switch(bdfs(r, goal, limit-1)) {
						case 1: cutoff = true; break;
						case 2: return 2;
						default:
					}
					r.moveActions[opp[i]].move();
				}
			}
			return (cutoff ? 1 : 0);
		}
	}
	
	public static int h(Board r, Board goal) { // Changed to use new H function given to class
		dx = 0;
		dy = 0;
		distance = 0;
		for(int i=0; i<=SIZE; i++) {
			if(r.tiles[i] != 0) { // Don't count the BlankPos in H function
				if(r.tiles[i] <= 9) { // If the tile is less than 9, the positional value is tile-1
					dx = Math.abs(dxArray[i] - dxArray[r.tiles[i]-1]);
					dy = Math.abs(dyArray[i] - dyArray[r.tiles[i]-1]);
				} else {
					dx = Math.abs(dxArray[i] - dxArray[r.tiles[i]]);
					dy = Math.abs(dyArray[i] - dyArray[r.tiles[i]]);
				}
				// x rows; y columns
				distance += Math.max(dy-dx, 0) / 2 + dx;
			}
		}
		return distance;
	}
	
	public static void printAnswer(Node x) {
		Stack<Node> stack = new Stack<>();
		int numMoves = 0;
		for(Node y = x; y != null; y = y.parent) {
			stack.push(y);
			numMoves++;
		}
		int i = 0;
		while(!stack.isEmpty()) {
			System.out.println("Step " + i++ + ": ");
			System.out.println(stack.pop());
		}
			
		System.out.println((numMoves-1) + " moves.");
	}
	
	public static int astar(Board start, Board goal) {
		// returns 0: failure, 2: success
		System.out.println("  f    |frontier|  |explored|");
		int maxF = 0;
		Node z = new Node(start, null, 0, h(start, goal));
		IndexMinPQ<Node> frontier = new IndexMinPQ<>();
		frontier.add(z);
		HashMap<Board,Node> explored = new HashMap<>();
		explored.put(start, z);
		
		while(true) {
			if(frontier.isEmpty())
				return 0;
			Node x = frontier.remove();
			x.inFrontier = false;
			if(x.g + x.h > maxF) { 
				maxF = x.g + x.h; 
				System.out.printf("%3d %10d %10d\t", maxF, frontier.size(), explored.size());
				System.out.print("x.h: " + x.h + " x.g: " + x.g + "\n");
			}
			if(x.state.equals(goal)) { // More detailed answer, including maxF, frontier.size, and explored.size
				System.out.print("ANSWER: \n");
				System.out.printf("%3d %10d %10d\t", maxF, frontier.size(), explored.size());
				System.out.print("x.h: " + x.h + " x.g: " + x.g + "\n");
				printAnswer(x);
				return 2;
			}
			for(int i=0; i<6; i++) { // Changed from 4 to 6
				if(x.state.moveActions[i].valid()) {
					x.state.moveActions[i].move();
					Node n = explored.get(x.state);
					if(n == null) {
						Board s = new Board(x.state.tiles, x.state.blankPos);
						n = new Node(s, x, x.g+1, h(x.state,goal));
						explored.put(s, n);
						frontier.add(n);
					} else if(n.inFrontier) {
						if(x.g+1 < n.g) {
							n.parent = x;
							n.g = x.g + 1;
							frontier.update(n);
						}
					} else {
						explored.remove(x, n);
					}
					x.state.moveActions[opp[i]].move();
				}
			}    
		}
	}
	
	public String toString() { // Updated to work with Hexagonal Puzzle
		String s = "";
		for(int i = 0; i < tiles.length; i++) {
			if(i == 0 || i == 3 || i == 7 || i == 12 || i == 16 ) {
				s+= "\n\t";
				if(i == 0 || i == 16)
					s += "\t";
			}
			s += ("\t");
			if((i >= 3 && i <= 6)|| (i >= 12 && i <= 15)) {
				s += "    ";
			}
			if(tiles[i] == 0) {
				s += "x";
			} else {
				s += tiles[i];
			}		
		}
		return s;
	}
	
	public boolean equals(Object o) {
		Board r = (Board)o;
		return blankPos == r.blankPos && Arrays.equals(tiles, r.tiles);
	}
	
	public int hashCode() { return Arrays.hashCode(tiles); }
	
	interface MoveAction { boolean valid(); void move(); } // Changed from 4 moves to 6 moves
	
	private MoveAction[] moveActions = new MoveAction[] { // 	UpLeft, UpRight, DownLeft, DownRight, Left, Right
		new MoveAction() { // UpLeft
			public boolean valid() { return blankPos != 0 && blankPos != 1 && blankPos != 2 && blankPos != 3 && blankPos != 7;}
			public void move() { 
		    	// 4 --> 0 -4
		    	// 5 --> 1 -4
		    	// 6 --> 2 -4
		    	
		    	// 8 --> 3 -5 
		    	// 9 --> 4 -5 
		    	// 10 -> 5 -5 
		    	// 11 -> 6 -5 
		    	
		    	// 12 -> 7 -5 
		    	// 13 -> 8 -5 
		    	// 14 -> 9 -5 
		    	// 15 -> 10 -5 
		    	
		    	// 16 -> 12 -4
		    	// 17 -> 13 -4 
		    	// 18 -> 14 -4
		    	int newPosition;
		    	if(blankPos < 8 || blankPos > 15) {
		    		newPosition = blankPos - 4;
		    	} else {
		    		newPosition = blankPos - 5;
		    	}
		    	tiles[blankPos] = tiles[newPosition]; 
		    	blankPos = newPosition; 
		    	tiles[blankPos] = 0;
		    }
		},
		new MoveAction() { // UpRight
			public boolean valid() {return blankPos != 0 && blankPos != 1 && blankPos != 2 && blankPos != 6 && blankPos != 11;} 
			public void move() { 
				// 3 --> 0 -3
				// 4 --> 1 -3
				// 5 --> 2 -3
				
				// 7 --> 3 -4
				// 8 --> 4 -4
		    	// 9 --> 5 -4
		    	// 10 -> 6 -4
		    	
		    	// 12 -> 8 -4
		    	// 13 -> 9 -4
		    	// 14 -> 10 -4
		    	// 15 -> 11 -4
				
		    	// 16 -> 13 -3
		    	// 17 -> 14 -3
		    	// 18 -> 15 -3
				int newPosition;
				if(blankPos < 7 || blankPos > 15) {
					newPosition = blankPos - 3;
				} else {
					newPosition = blankPos - 4;
				}
		    	tiles[blankPos] = tiles[newPosition]; 
		    	blankPos = newPosition; 
		    	tiles[blankPos] = 0;
		    }
		},
		new MoveAction() { // DownLeft
			public boolean valid() { return blankPos != 16 && blankPos != 17 && blankPos != 18 && blankPos != 12 && blankPos != 7;}
			public void move() { 
				// 0 --> 3 +3
				// 1 --> 4 +3 
				// 2 --> 5 +3
		    	
				// 3 --> 7 +4
		    	// 4 --> 8 +4
		    	// 5 --> 9 +4
		    	// 6 --> 10 +4
		    	
		    	// 8 --> 12 +4
		    	// 9 --> 13 +4
		    	// 10 -> 14 +4
		    	// 11 -> 15 +4
		    	
		    	// 13 -> 16 +3
		    	// 14 -> 17 +3
		    	// 15 -> 18 +3
		    	int newPosition;
		    	if(blankPos < 3 || blankPos > 11) {
		    		newPosition = blankPos + 3;
		    	} else {
		    		newPosition = blankPos + 4;
		    	}
		    	tiles[blankPos] = tiles[newPosition]; blankPos = newPosition; tiles[blankPos] = 0;	    	
		    }
		},
		new MoveAction() { // DownRight
			public boolean valid() { return blankPos != 16 && blankPos != 17 && blankPos != 18 && blankPos != 15 && blankPos != 11;}
			public void move() { 
		    	// 0 --> 4 +4
		    	// 1 --> 5 +4
		    	// 2 --> 6 +4
		    	
		    	// 3 --> 8 +5
		    	// 4 --> 9 +5
		    	// 5 --> 10 +5
		    	// 6 --> 11 +5
		    	
		    	// 7 --> 12 +5 
		    	// 8 --> 13 +5 
		    	// 9 --> 14 +5 
		    	// 10 -> 15 +5 
		    	
		    	// 12 -> 16 +4
		    	// 13 -> 17 +4 
		    	// 14 -> 18 +4
		    	int newPosition;
		    	if(blankPos < 3 || blankPos > 10) {
		    		newPosition = blankPos + 4;
		    	} else {
		    		newPosition = blankPos + 5;
		    	}
		    	tiles[blankPos] = tiles[newPosition]; blankPos = newPosition; tiles[blankPos] = 0;
		    }
		},
		new MoveAction() { // Left
			public boolean valid() { return blankPos != 0 && blankPos != 3 && blankPos != 7 && blankPos != 12 && blankPos != 16; }
			public void move() { tiles[blankPos] = tiles[blankPos-1]; blankPos -= 1; tiles[blankPos] = 0;}
		},
		new MoveAction() { // Right
			public boolean valid() { return blankPos != 2 && blankPos != 6 && blankPos != 11 && blankPos != 15 && blankPos != 18; }
			public void move() { tiles[blankPos] = tiles[blankPos+1]; blankPos += 1; tiles[blankPos] = 0;}
		}
	};
	
	static class Node implements Comparable<Node>, Denumerable {
		public Board state;
		public Node parent;
		public int g, h;
		public boolean inFrontier;
		public int x;
		Node(Board state, Node parent, int g, int h) {
			this.state = state;
			this.parent = parent;
			this.g = g;
			this.h = h;
			inFrontier = true;
			x = 0;
		}
		
		public int compareTo(Node a) {
			return g + h - a.g - a.h;
		}
		
		public int getNumber() { return x; }
		public void setNumber(int x) { this.x = x; }
		public String toString() { return state + ""; }
	}
}



