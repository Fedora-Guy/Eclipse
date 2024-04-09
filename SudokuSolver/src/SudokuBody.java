import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class SudokuBody extends Component implements MouseListener, KeyListener {
	
	private String inputTyped = "";
	
	private int[][][] cellInfo = new int[6][9][9];
	private Cell cell = new Cell();
	// six blocks; 0 for starting X-Coord, 1 for starting Y-Coord
	// 2 for ending X-Coord, 3 for ending Y-Coord; 
	// 4 for cellSpot; 5 for what the cell contains if anything. (-1 means it contains nothing)
	
	private int hightlightedCell = -1;
	// -1 resembles if nothing is selected
	
	public SudokuBody() {
		addMouseListener(this);
		addKeyListener(this);
		for(int k = 0; k < 6; k++) {
			int i = 1;
			for(int col = 0; col < 9; col++) {
				for(int row = 0; row < 9; row++) {
					if(k == 0) {
						cellInfo[k][col][row] = 25 + (50*col);
					} else if (k == 1) {
						cellInfo[k][col][row] = 15 + (50*row);
					} else if (k == 2) {
						cellInfo[k][col][row] = 25 + (50*col) + 45;
					} else if (k == 3) {
						cellInfo[k][col][row] = 15 + (50*row) + 45;
					} else if ( k == 4){
						cellInfo[k][col][row] = i;
						i++;
					} else {
						cellInfo[k][col][row] = -1;
					}
				}
			}
		}
		// Cell 1 is: x-starting: 25 x-ending: 70; y-starting: 15, y-ending: 60; spot 0; contains nothing
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(200, 200, 200));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setColor(Color.black);
		g2.fillRect(25, 15, 446, 446);
		for(int i = 0; i < 9; i++) {
			for( int j = 0; j < 9; j++) {
				g2.setColor(Color.red);
				g2.drawRect(25+(50*i), 15+(50*j), 45, 45);
//				g2.setColor(Color.blue);
				g2.setColor(new Color((j/3)*100, (i/3)*60, 50));
				g2.fillRect(26+(50*i), 16+(50*j), 44, 44);
				if(hightlightedCell == cellInfo[4][i][j]) {
					g2.setColor(Color.red);
					g2.drawRect(25+(50*i), 15+(50*j), 45, 45);
					g2.setColor(Color.green);
					g2.fillRect(26+(50*i), 16+(50*j), 44, 44);
				}
				if(cellInfo[5][i][j] > 0) {
					g2.setColor(Color.red);
					g2.setFont(new Font("Serif", Font.PLAIN, 45));
					g2.drawString(Integer.toString(cellInfo[5][i][j]), 35+(50*i), 55+(50*j));
				}
			}
		}
		g2.setFont(new Font("Serif", Font.PLAIN, 15));
		g2.setColor(Color.magenta);
		g2.fillRect(650, 450, 50, 30);
		g2.setColor(Color.black);
		g2.drawString("Solve", 660, 470);
		g2.setColor(Color.red);
		g2.fillRect(550, 450, 50, 30);
		g2.setColor(Color.black);
		g2.drawString("Quit", 560, 470);
		
		repaint();
	}
	
	//CODE TIME HERE
	public void solve() {
		
		boolean solvable = true;
		//Check if any Column has duplicate numbers: Good
		for(int col = 0; col < 9; col++) {
			for(int row = 0; row < 9; row++) {
				for(int check = row+1; check < 9; check++) {
					if(cellInfo[5][col][row] == cellInfo[5][col][check] && cellInfo[5][col][row] != -1) {
						System.out.println("Duplicate Numbers in Column " + (col+1));
						System.out.println("Numbers: " + cellInfo[5][col][row]);
						solvable = false;
					}
					
				}
			}
		}
		if(solvable == false) {
			System.out.println("Grid is not solvable - Column");
//			return;
		}
		//Check if any Row has any duplicate numbers : Good
		for(int row = 0; row < 9; row++) {
			for(int col = 0; col < 9; col++) {
				for(int check = col+1; check < 9; check++) {
					if(cellInfo[5][col][row] == cellInfo[5][check][row] && cellInfo[5][col][row] != -1) {
						System.out.println("Duplicate Numbers in Row " + (row+1));
						System.out.println("Numbers: " + cellInfo[5][col][row]);
						solvable = false;
					}
				}
			}
		}
		
		if(solvable == false) {
			System.out.println("Grid is not solvable - Row");
			return;
		}
		
		
		//new check if any box has any duplicate numbers
		for(int box = 1; box < 10; box++) {
			if(box == 1 || box == 2 || box == 3) {
				for(int col = 0; col < 3; col++) {
					for(int row = (box * 3)-3; row < (box*3); row++) {
						for(int check = 0; check < 3; check++) {
							if(cellInfo[5][col][row] == cellInfo[5][check][row] && ((cellInfo[5][col][row] != -1) && (cellInfo[4][col][row] != cellInfo[4][check][row]))) {
								System.out.println("Duplicate Numbers in Box " + (box));
								System.out.println("Numbers: " + cellInfo[5][col][row]);
								System.out.println("col, row, check: " + col + ", " + row + ", " + check);
								solvable = false;
							}
						}
					}
				}
			} else if(box == 4 || box == 5 || box == 6) {
				for(int col = 3; col < 6; col++) {
					for(int row = ((box-3) * 3)-3; row < ((box-3)*3); row++) {
						for(int check = 3; check < 6; check++) {
							if(cellInfo[5][col][row] == cellInfo[5][check][row] && cellInfo[5][col][row] != -1) {
								System.out.println("Duplicate Numbers in Box " + (box));
								System.out.println("Numbers: " + cellInfo[5][col][row]);
								solvable = false;
							}
						}
					}
				}
			} else {
				for(int col = 6; col < 9; col++) {
					for(int row = ((box-6) * 3)-3; row < ((box-6)*3); row++) {
						for(int check = 6; check < 9; check++) {
							if(cellInfo[5][col][row] == cellInfo[5][check][row] && cellInfo[5][col][row] != -1) {
								System.out.println("Duplicate Numbers in Box " + (box));
								System.out.println("Numbers: " + cellInfo[5][col][row]);
								solvable = false;
							}
						}
					}
				}
			}
		}
		
		System.out.println("Grid is " + ((solvable == false) ? "not solvable" : "solvable"));
		
		//Check if any box has any duplicate numbers
//		for(int box = 1; box <= 9; box++) {
//			// box 1 = 1, 2, 3, 10, 11, 12, 19, 20, 21
//			// box 2 (right) = 28, 29, 30, 37, 38, 39, 46, 47, 48
//			// box 3 (down) = 4, 5, 6, 13, 14, 15, 22, 23, 24
//			
//			//			col/row
//			// box 1 =  1/1, 1/2, 1/3, 2/1, 2/2, 2/3, 3/1, 3/2, 3/3
//			for(int number = 0; number < 9; number++) {
//				int col = 1;
//				int row = 1;
//				int check = 0;
//				
//				col = 1 * box + number;
//				row = 1 * box;
//				if(number > 3 && number < 6) {
//					row = box * number + 9;
//				} else if (number > 6){
//					row = box * number + 9;
//				}
//				
//				System.out.println("col: " + col + ", row: " + row);
//				if(cellInfo[5][col][row] == cellInfo[5][check][row] && cellInfo[5][col][row] != -1) {
//					
//				}
//			}
//			
//			for(int col = (box%3); col < box+3 && col < 9; col++) {
//				for(int row = 3*box; row < box+3 && row < 9; row++) {
////					System.out.println("box: " + box + " Col: " + col + " Row: " + row);
////					System.out.println(cellInfo[4][col][row]);
//					for(int check = 0; check < 9; check++) {
////						if(cellInfo[5][col][row] == cellInfo[5][col][check] && cellInfo[5][col][row] != -1) {
////							System.out.println("Duplicate Number in a Row");
////						}
//					}
//				}
//			}
//		}
		
		
	}
	
	public void quit() {
		System.exit(0);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		requestFocusInWindow();
		
//		System.out.println(e.getX() + " Actual X");
//		System.out.println(e.getY() + " Actual Y");
		
		boolean cellFound = false;
		for(int col = 0; col < 9; col++) {
			if(cellFound) {
				break;
			}
			for(int row = 0; row < 9; row++) {
				if((e.getX() >= cellInfo[0][col][row] && e.getX() <= cellInfo[2][col][row]) && (e.getY() >= cellInfo[1][col][row] && e.getY() <= cellInfo[3][col][row])) {
					hightlightedCell = cellInfo[4][col][row];
					cellFound = true;
					break;
				} else {
					hightlightedCell = -1;
				}
			}
		}
		System.out.println(hightlightedCell + " Cell");
		if((e.getX() >= 650 && e.getX() <= 700) && (e.getY() >= 450 && e.getY() <= 480)) {
			System.out.println("Solve Button");
			solve();
		}
		
		if((e.getX() >= 550 && e.getX() <= 600) && (e.getY() >= 450 && e.getY() <= 480)) {
			System.out.println("Quit Button");
			quit();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Key 'typed'");
//		System.out.println(e.getKeyChar());
//		System.out.println(e);
		inputTyped = Character.toString(e.getKeyChar());
		if(inputTyped.equals("1") || inputTyped.equals("2") || inputTyped.equals("3") || 
		   inputTyped.equals("4") || inputTyped.equals("5") || inputTyped.equals("6") || 
		   inputTyped.equals("7") || inputTyped.equals("8") || inputTyped.equals("9") || inputTyped.equals("\b") ) {
			for(int col = 0; col < 9; col++) {
				for(int row = 0; row < 9; row++) {
					if(hightlightedCell == cellInfo[4][col][row]) {
						if(inputTyped.equals("\b")) {
							cellInfo[5][col][row] = -1;
						} else {
							cellInfo[5][col][row] = Integer.parseInt(inputTyped);
							
						}
						return;
					}
				}
			}
//			System.out.println("No cell selected");
		} 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
