import java.awt.Color;

// Class Represents: Each interact able Button that can be clicked on
// The Player will interact with this class every time they click on an object. This class adds the click ability to the images
public class ButtonObj {
	// Attributes
	
	private String objDisplay;
	private int objX1, objX2, objY1, objY2, objLocation;
	private Color objColor;
	
	// Constructors
	
	public ButtonObj (String argObjDisplay, int argX1, int argY1, int argX2, int argY2, Color argColor, int argObjLocation) {
		objDisplay = argObjDisplay;
		objX1 = argX1;
		objY1 = argY1;
		objX2 = argX2;
		objY2 = argY2;
		objColor = argColor;
		objLocation = argObjLocation;
	}
	
	public ButtonObj (String argObjDisplay, int argX1, int argY1, int argX2, int argY2, int argObjLocation) {
		objDisplay = argObjDisplay;
		objX1 = argX1;
		objY1 = argY1;
		objX2 = argX2;
		objY2 = argY2;
		objLocation  = argObjLocation;
	}
	
	public ButtonObj (String argObjDisplay, int argX1, int argY1, int argObjLocation) {
		objDisplay = argObjDisplay;
		objX1 = argX1;
		objY1 = argY1;
		objX2 = argX1+40;
		objY2 = argY1+40;
		objLocation = argObjLocation;
	}

	// Getters and Setters for the Attributes
	
	public String getObjDisplay() {
		return objDisplay;
	}

	public void setObjDisplay(String argObjDisplay) {
		objDisplay = argObjDisplay;
	}

	public Color getObjColor() {
		return objColor;
	}

	public void setObjColor(Color argObjColor) {
		objColor = argObjColor;
	}

	public int getObjX1() {
		return objX1;
	}

	public void setObjx1(int argObjX1) {
		objX1 = argObjX1;
	}

	public int getObjX2() {
		return objX2;
	}

	public void setObjX2(int argObjX2) {
		objX2 = argObjX2;
	}

	public int getObjY1() {
		return objY1;
	}

	public void setObjY1(int argObjY1) {
		objY1 = argObjY1;
	}

	public int getObjY2() {
		return objY2;
	}

	public void setObjY2(int argObjY2) {
		objY2 = argObjY2;
	}
	
	public int getObjLocation() {
		return objLocation;
	}

	public void setObjLocation(int argObjLocation) {
		objLocation = argObjLocation;
	}
	
	
}
