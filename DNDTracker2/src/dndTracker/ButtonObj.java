package dndTracker;
import java.awt.Color;

public class ButtonObj {
	
	String objdisplay;
	int objx1, objx2, objy1, objy2;
	Color objcolor;
	
	public ButtonObj (String display, int x1, int y1, int x2, int y2, Color color) {
		this.objdisplay = display;
		this.objx1 = x1;
		this.objy1 = y1;
		this.objx2 = x2;
		this.objy2 = y2;
		this.objcolor = color;
		
	}
	
	public ButtonObj (String display, int x1, int y1) {
		this.objdisplay = display;
		this.objx1 = x1;
		this.objy1 = y1;
		this.objx2 = x1+40;
		this.objy2 = y1+40;
	}
	
	
	
}
