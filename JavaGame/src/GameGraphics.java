import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class GameGraphics extends JComponent implements MouseListener, MouseMotionListener, KeyListener {
	
	public State state;
	private Controls controls;
	
	public GameGraphics(Controls controls) {
		this.controls = controls;
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        requestFocusInWindow();
    }
	
	public void startScreen() {
		state = State.START;
	}
	
	public void runningScreen() {
		state = State.RUNNING;
	}
	
	public void gameOverScreen() {
		state = State.GAME_OVER;
	}
	
	public void pausedScreen() {
		state = State.PAUSED;
	}
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if(state == State.START) {
			g2.setColor(new Color(100, 0, 255));
			g2.fillRect(1920/2-50, 1080/2+50, 100, 100);
			g2.setFont(new Font("Serif", Font.PLAIN, 30));
			g2.setColor(new Color(0, 255 ,0));
			g2.drawString("Click to", 1920/2-50, 1080/2+90);
			g2.drawString("Start", 1920/2-30, 1080/2+120);
		} else if (state == State.PAUSED) {
			g2.setBackground(new Color(0, 0, 255, 200));
			g2.setColor(new Color(50, 0, 0));
			g2.fillRect(200, 200, 200, 200);
			g2.setColor(new Color(100, 0, 100, 100));
			g2.fillRect(0, 0, 1000, 1000);
		} else if (state == State.GAME_OVER) {
			g2.setColor(new Color(200, 20, 200));
			g2.fillRect(100, 100, 1000, 1000);
		} else if (state == State.RUNNING) {
			
		}
//		g2.setColor(new Color(0, 0, 255));
//		g2.fillRect(400, 400, 100, 100);
//		imageDraw(g2, "Mappa", 0, 0);
		repaint();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 27 && controls.getState() != State.GAME_OVER) {
			controls.game_over();
		} else if (e.getKeyCode() == 27) {
			controls.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Pressed");
		if(((e.getX() > 910 && e.getX() < 1010) && (e.getY() > 590 && e.getY() < 690) ) && state == State.START ) {
			controls.paused();
		}
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

	public void imageDraw(Graphics2D g2, String path, int x, int y) {
		BufferedImage img = null;
		try {
			URL url = Main.class.getResource("/Images/" + path + ".jpg");
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
			}
		if(img != null) {
//			g2.drawImage(img, x, y, null);
			// (1920 - 1500) / 2
			// (1080 - 1000) / 2
			g2.drawImage(img, (1920-1500)/2, (1080 - 1000)/2, 1500, 1000, null);
		}
	}

}
