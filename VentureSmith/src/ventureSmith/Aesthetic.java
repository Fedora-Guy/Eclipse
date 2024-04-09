package ventureSmith;

import java.awt.Color;
import java.awt.Graphics2D;

public class Aesthetic {
	
	boolean global;
	int frames;
	String name;
	Object[] obj;
	
	public Aesthetic(boolean global, int frames, String name, Object[] obj) {
		this.global = global;
		this.frames = frames;
		this.name = name;
		this.obj = obj;
	}
	
	public void update(Body body) {
		this.frames--;
		if(this.frames <= -1)
			body.sendMessage(new Object[] {"kill", this});
	}
	
	public void paint(Graphics2D g2, Body body) {
		switch(this.name) {
		case("screenTransition"):
			if(this.frames == 15)
				body.sendMessage(this.obj);
			g2.setColor(Color.black);
			g2.fillRect((this.frames-15)*800/15, 0, 800, 600);
			break;
		}
	}
	
}
