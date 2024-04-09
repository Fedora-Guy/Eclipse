import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuPaint extends Component implements MouseListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private Color color = Color.BLUE;
	private int[][] grid = new int[9][9];
	private int[][] solutionGrid = new int[9][9];
	private int[][] duplicateGrid = new int[9][9];
	private int selectedRow = -1, selectedColumn = -1; // i = Column, j = Row... grid[Column][Row]
	
	
	public SudokuPaint() {
		addKeyListener(this);
		addMouseListener(this);
		
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				grid[i][j] = 0;
				solutionGrid[i][j] = 0;
				duplicateGrid[i][j] = 0;
			}
		}
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(color);
		
		
		displayBoard(g2);
		displaySelected(g2);
		displayNumbers(g2);
		displayButtons(g2);
		this.repaint();
	}

	public void displayBoard(Graphics2D g2) {
		
		g2.setColor(Color.BLUE);
		g2.fillRect(10, 10, 820, 820);
		
		g2.setColor(new Color(255, 255, 255));
		
		// Each Box
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				g2.setColor(new Color(255/(i+j+1), 255/(i+1), 255/(j+1)));
				g2.fillRect(10 + 270 * i, 10 + 270 * j, 270, 270);
			}
		}
		
		// Horizontal Bars
		g2.setColor(Color.DARK_GRAY);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j <= 9; j++) {
				g2.drawLine(10, (10+j)+(90*i), 829, (10+j)+(90*i));
			}
		}
		
		// Vertical Bars
		g2.setColor(Color.DARK_GRAY);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j <= 9; j++) {
				g2.drawLine((10+j)+(90*i), 10, (10+j)+(90*i), 829);
			}
		}
		
		// Green Dots
//		g2.setColor(Color.green);
//		for(int i = 1; i<= 10*9; i += 9) {
//			for(int j = 1; j<= 10*9; j += 9) {
//				g2.fillRect(10*i, 10*j, 10, 10);
//			}
//		}
	}
	
	public void displaySelected(Graphics2D g2) {
		if(selectedRow != -1 && selectedColumn != -1) {
			g2.setColor(Color.YELLOW);
			g2.fillRect((20+90*selectedColumn), (20+90*selectedRow), 80, 80);
		}
	}
	
	public void displayNumbers(Graphics2D g2) {
		
		// FONT = SERIF, PLAIN, 110
		// DrawString; 34 + (90 * column) is the x-center, 100 + (90*row) is the bottom layer of a cell
		// Numbers
		g2.setFont(new Font("Serif", Font.PLAIN, 110));		
		// Display Input 
		g2.setColor(Color.black);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(grid[i][j] != 0) {
					g2.drawString(Integer.toString(grid[i][j]), 34 + (90 * i), 100 + (90 * j));
				}
			}
		}
		// Display Output
		g2.setColor(Color.blue);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(solutionGrid[i][j] != 0) {
					g2.drawString(Integer.toString(solutionGrid[i][j]), 34 + (90 * i), 100 + (90 * j));
				}
			}
		}
		// Display Error Numbers
		g2.setColor(Color.red);
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if(duplicateGrid[i][j] != 0) {
					g2.drawString(Integer.toString(duplicateGrid[i][j]), 34 + (90 * i), 100 + (90 * j));
				}
			}
		}
		
	}
	
	public void displayButtons(Graphics2D g2) {
		
		// Solve Button
		g2.setColor(Color.BLUE);
		g2.fillRect(900, 500, 100, 60);
		g2.setFont(new Font("Serif", Font.BOLD, 40));
		g2.setColor(Color.RED);
		g2.drawString("Solve", 905, 540);
		
		// Quit Button
		g2.setColor(Color.BLACK);
		g2.fillRect(900, 700, 100, 60);
		g2.setFont(new Font("Serif", Font.BOLD, 40));
		g2.setColor(Color.RED);
		g2.drawString("Quit", 910, 740);
	}
	
	public void mouseClickedCell(int row, int column) {
//		System.out.println("row: " + (row+1) + "\ncolumn:" + (column+1));
		selectedRow = row;
		selectedColumn = column;
	}
	
	public void mouseClickedSolve() {
		SudokuSolver sudokuSolver = new SudokuSolver(grid);
		int[][] returnedGrid = sudokuSolver.Solve();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				this.solutionGrid[i][j] = returnedGrid[i][j];
			}
		}
		for(int i = 9; i < 18; i++) {
			for(int j = 0; j < 9; j++) {
				this.duplicateGrid[i-9][j] = returnedGrid[i][j];
			}
		}
	}
	
	public void mouseClickedQuit() {
		System.exit(0);
	}
	
	public void numberTyped(int number) {
		if(selectedRow != -1 && selectedColumn != -1) {
			grid[selectedColumn][selectedRow] = number;
		}
	}
	
	public void escapeTyped() {
		selectedRow = -1;
		selectedColumn = -1;
	}
	
	public void backspaceTyped() {
		if(selectedColumn != -1 && selectedRow != -1) {
			grid[selectedColumn][selectedRow] = 0;
		}
	}
	
	public void directionalKeyTyped(int direction) {
		if(selectedRow == -1 || selectedColumn == -1) {
			return;
		} else {
			if(direction == 38) {
				if(selectedRow == 0) {
					selectedRow = 8;
				} else {
					selectedRow--;
				}
			} else if(direction == 40) {
				if(selectedRow == 8) {
					selectedRow = 0;
				} else {
					selectedRow++;
				}
			} else if(direction == 39) {
				if(selectedColumn == 8) {
					selectedColumn = 0;
				} else {
					selectedColumn++;
				}
			} else if(direction == 37) {
				if(selectedColumn == 0) {
					selectedColumn = 8;
				} else {
					selectedColumn--;
				}
			}
		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		char pressed = e.getKeyChar();
		String pressedString = Character.toString(pressed);
		for(int i = 0; i < 9; i++) {
			if(pressedString.equals((i+1) + "")) {
				numberTyped((i+1));
			}
		}
		
		if((int)pressed == 27) {
			escapeTyped();
		}
		
		if((int)pressed == 8) {
			backspaceTyped();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int pressed = e.getKeyCode();
		if(pressed == 37 || pressed == 38 || pressed == 39 || pressed == 40) {
			directionalKeyTyped((int)pressed);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println(e.getX() + ", " + e.getY());
		// (20, 20) to (100, 100); each box is 80 x 80
		int x = e.getX();
		int y = e.getY();
		for(int i = 0; i<9; i++) {
			for(int j = 0; j<9; j++) {
				if((x >= (20+90*i) && x <= (100+90*i)) && (y >= (20+90*j) && y <= (100+90*j))) {
					mouseClickedCell(j, i);
					return;
				}
			}
		}
		selectedRow = -1;
		selectedColumn = -1;
		if((x >= (900) && x <= (1000)) && (y >= (500) && y <= (560))) {
			mouseClickedSolve();
		} else if((x >= (900) && x <= (1000)) && (y >= (700) && y <= (760))) {
			mouseClickedQuit();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

}
