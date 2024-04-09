import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class BattleShipGUI extends Component implements MouseListener {
	
	private int gridX[][] = new int[10][2];
	private int gridY[][] = new int[10][2];
	private Piece[][] grid;
	private Board board;
	private Water water = new Water();
	private Hit hit = new Hit();
	private Miss miss = new Miss();
	
	public BattleShipGUI (Board board) {
		this.board = board;
		this.grid = board.returnGrid();
		
		addMouseListener(this);
		
		for(int i = 0; i < 10; i++) {
			for(int k = 0; k < 2; k++) {
				if(k == 0) {
					gridX[i][k] = 150 + i*70;
					gridY[i][k] = 50 + i*70;
				}
				if(k == 1) {
					gridX[i][k] = 210 + i*70;
					gridY[i][k] = 110 + i*70;
				}
			}
		}
		
	}

	
	
	public void paint(Graphics g) {
		
		for(int i = 0; i < 10; i++) {
			for(int j =0; j < 10; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(new Color(200, 200, 200));
        g2.fillRect(0, 0, 1150, 850);
        
        g2.setColor(Color.BLUE);
        g2.fillRect(100 , 10, 1150-200, 850-60);
        g2.setColor(new Color (235, 235, 235));
//        for(int x = 10; x < 1120; x += 160) {
//        	for (int y = 10; y < 420; y += 210) {
//        		g2.fillRect(x, y, 150, 200);
//        	}
//        }
        int width = 60;
        int height = 60;
        for(int x = 0; x < 10; x++) {
        	for(int y = 0; y < 10; y++) {
        		g2.setColor(Color.green);
        		g2.fillRect(x*70 + 150, y*70 + 50, width, height);
        	}
        }
        
        for(int i = 0; i < 10; i++) {
        	for(int j = 0; j < 10; j++) {
        		if(grid[i][j] == water) {
        			g2.setColor(Color.white);
            		g2.fillRect(i*70 + 150, j*70 + 50, width, height);
        		} else if (grid[i][j] == hit) {
        			g2.setColor(Color.red);
            		g2.fillRect(i*70 + 150, j*70 + 50, width, height);
        		} else if (grid[i][j] == miss) {
        			g2.setColor(Color.cyan);
            		g2.fillRect(i*70 + 150, j*70 + 50, width, height);
        		}
        	}
        }
        
        repaint();
    }
	
	private void ClickCell(int xSquare, int ySquare) {
		board.fireAt(new Coordinates(ySquare, xSquare));
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX() + ", " + e.getY());
		System.out.println();
		int xSquare = -1;
		int ySquare = -1;
		for(int i = 0; i< 10; i++) {
			if(e.getX() >= gridX[i][0] && e.getX() <= gridX[i][1]) {
				xSquare = i;
			}
		}
		
		for(int i = 0; i< 10; i++) {
			if(e.getY() >= gridY[i][0] && e.getY() <= gridY[i][1]) {
				ySquare = i;
			}
		}
		if(xSquare != -1 && ySquare != -1) {
			ClickCell(xSquare, ySquare);
			System.out.println(xSquare + ", " + ySquare);
		} else {
			System.out.println("Not a Coordinate");
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
	
}
