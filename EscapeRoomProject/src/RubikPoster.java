
public class RubikPoster {
	private int timecode4;
	private boolean examinePoster = false;
	
	public RubikPoster() {
		int temp = (int)(Math.random() * (3) + 1);
		if(temp == 1) {
			timecode4 = 0;
		} else if (temp == 2) {
			timecode4 = 1;
		} else if (temp == 3) {
			timecode4 = 4;
		} else if (temp == 4) {
			timecode4 = 7;
		} else {
			timecode4 = 1;
		}
	}

	public int getTimecode4() {
		return timecode4;
	}

	public void setTimecode4(int argTimecode4) {
		timecode4 = argTimecode4;
	}
	
	public void lookAtPoster() {
		examinePoster = true;
	}
	
	public boolean isLookingAtPoster() {
		return examinePoster;
	}
	
}
