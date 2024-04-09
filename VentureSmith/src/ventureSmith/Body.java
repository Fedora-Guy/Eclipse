package ventureSmith;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import java.awt.*;

@SuppressWarnings("serial")
public class Body extends Component implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	MapManager mapManager = new MapManager();
	ExploreManager exploreManager;
	HashMap<Integer, Town[]> townHash = new HashMap<Integer, Town[]>();
	Town[] towns = new Town[0];
	int[] mouse = {0, 0};
	int[] screen = {800, 600};
	int[] counter = {0};
	int[] state = {0, 0};
	boolean offScreen = false;
	boolean start = true;
	ArrayList<Button> currentButtons = new ArrayList<Button>();
	ArrayList<Aesthetic> animations = new ArrayList<Aesthetic>();
	double screenShake = 0;
	
	public Body() {		
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		addKeyListener(this);
		new Timer().scheduleAtFixedRate(new TimerTask() {
			public void run() {
				counter[0]++;
				physics();
			}
		}, 16, 16);
		addAnimation(new Aesthetic(true, 40, "screenTransition", new Object[] {"changeState[0]", 1}));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		this.requestFocusInWindow();
		g2.setColor(Color.black);
		g2.fillRect(-200, -200, screen[0]+400, screen[1]+400);
		if(this.screenShake > 2) {
			g2.translate((int) (this.screenShake*2*(0.5-Math.random())), (int) (this.screenShake*2*(0.5-Math.random())));
			this.screenShake = Math.pow(this.screenShake, 0.98);
		}
		drawBackground(g2);
		switch(state[0]) {
		case(0):
			break;
		case(1):
			mapManager.paint(g2, state);
			break;
		case(2):
			exploreManager.paint(g2, state, animations);
			break;
		}
		for(int i = 0; i < animations.size(); i++)
			if(animations.get(i).global)
				animations.get(i).paint(g2, this);
		g2.dispose();
	}
	
	public void physics() {
		switch(state[0]) {
		case(2):
			break;
		}
		for(int i = 0; i < animations.size(); i++)
			animations.get(i).update(this);
		repaint();
	}
	
	public void drawBackground(Graphics2D g2) {
		g2.setColor(Color.lightGray);
		g2.fillRect(0, 0, 800, 600);
	}
	
	public void sendMessage(Object[] obj) {
		switch((String) obj[0]) {
		case("kill"):
			for(int i = 0; i < animations.size(); i++)
				if(animations.get(i) == (Aesthetic) obj[1])
					animations.remove(i);
			break;
		case("changeState[0]"):
			this.state[0] = (int) obj[1];
			if((int) obj[1] == 2) {
				this.exploreManager = new ExploreManager(0);
			}
			break;
		case("changeState[1]"):
			this.state[1] = (int) obj[1];
			break;
		}
	}
	
	public void addAnimation(Aesthetic a) {
		switch(a.name) {
		case("transition"):
			switch((String) a.obj[0]) {
			case("changeState[0]"):
				if((int) a.obj[1] == state[0])
					return;
				break;
			case("changeState[1]"):
				if(((String) (a.obj[0])).equals("changeState[1]") && (int) a.obj[1] == state[1])
					return;
				break;
			}
			break;
		}
		animations.add(a);
	}
	
	public void killAnimation(Aesthetic a) {
		animations.remove(a);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse[0] = e.getX();
		mouse[1] = e.getY();
		switch(state[0]) {
		case(1):
			mapManager.mouseMoveInputs(e, this, new int[] {mouse[0], mouse[1]});
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(offScreen)
			offScreen = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(state[0]) {
		case(1):
			mapManager.mouseInputs(e, this);
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		offScreen = true;
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		switch(state[0]) {
		case(1):
			mapManager.mouseWheelInputs(e, this);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(state[0]) {
		case(1):
			mapManager.keyInputs(e, this);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
}
