import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class Paint extends Component implements MouseListener, KeyListener  {
	
	private Sudoku sudoku = new Sudoku();
	public Rectangle rectangleExample = new Rectangle(100, 100, 100, 100);
	
	public Paint() {
		addMouseListener(this);
		addKeyListener(this);
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.lightGray);
		g2.fillRect(10, 10, 525, 490);
		g2.draw(rectangleExample);
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				g2.setColor(Color.black);
				g2.drawRect(sudoku.returnX(i), sudoku.returnY(j), sudoku.returnWidth(), sudoku.returnHeight());
				g2.setColor(Color.white);
				g2.fillRect(sudoku.returnX(i)+1, sudoku.returnY(j)+1, sudoku.returnWidth()-1, sudoku.returnHeight()-1);
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
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getX());
		System.out.println(e.getY());
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
