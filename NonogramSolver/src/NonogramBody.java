import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class NonogramBody extends Component implements MouseListener {

	int[] size = {5, 5};
	int state = 0;
	int[] buttons = new int[10];
	Polygon triangle = new Polygon(new int[] {-10, 10, 0}, new int[] {10, 10, -15}, 3);
	
	public NonogramBody() {
		addMouseListener(this);
	    for(int i = 0; i < 8; i+=2) {
	    	buttons[i] = 100 + 200*(i/4);
	    	buttons[i+1] = 50 + 150*(i%4);
	    }
	    buttons[8] = 400;
	    buttons[9] = 425;
	    		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(200, 200, 200));
		g2.fillRect(0, 0, getWidth(), getHeight());
    	g2.setFont(new Font("Serif", Font.PLAIN, 30));
		
		if(state == 0) {
			for(int i = 0; i < 10; i+=2) {
				g2.translate(buttons[i], buttons[i+1]);
				g2.rotate(0.5 * Math.PI * (i%4));
				g2.setColor(Color.black);
				g2.fillRoundRect(-37, -25, 75, 50, 5, 5);
				g2.setColor(Color.yellow);
				if(i < 8)
					g2.fillPolygon(triangle);
				else
					g2.drawString("Start", -28, 10);
				g2.rotate(-Math.PI * 0.5 * (i%4));
				g2.translate(-buttons[i], -buttons[i+1]);
			}
	    	g2.setFont(new Font("Serif", Font.PLAIN, 50));
			g2.drawString("" + size[0], 85, 200);
			g2.drawString("" + size[1], 285, 200);
		}
		repaint();
	}
	
	
	
	// Quits the program
	public void quit() {
		System.exit(0);
	}

	
	public void start() {
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		for(int i = 0; i < buttons.length/2-1; i+=1) {
			if(e.getX() > buttons[i*2]-37 && e.getX() < buttons[i*2] + 38 && e.getY() > buttons[i*2+1] - 25 && e.getY() < buttons[i*2+1] + 25) {
				size[i/2] += 1-((i%2)*2);
				if(size[i/2] < 0) {
					size[i/2] = 0;
				}
			}
		}
		if(e.getX() > buttons[8] - 37 && e.getX() < buttons[9] + 38 && e.getY() > buttons[8] - 25 && e.getY() < buttons[9] + 25) {
			quit();
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {	
		
	}

	@Override
	public void mouseExited(MouseEvent e) {	
		
	}
	
}
