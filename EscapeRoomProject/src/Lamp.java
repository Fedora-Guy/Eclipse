
public class Lamp {
	private int timecode3;
	private boolean examineLamp;
	
	public Lamp() {
		timecode3 = (int)(Math.random() * (5));
		examineLamp = false;
	}

	public int getTimecode3() {
		return timecode3;
	}

	public void setTimecode3(int argTimecode3) {
		timecode3 = argTimecode3;
	}
	
	public void lookAtLamp() {
		examineLamp = true;
	}
	
	public boolean isLookingAtLamp() {
		return examineLamp;
	}
	
}
