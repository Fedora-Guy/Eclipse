
public class CombinationLockPad {
	private int correctCode1;
	private int correctCode2;
	private int correctCode3;
	private boolean isCodeCorrect = false;
	private int currentCode1 = 0;
	private int currentCode2 = 0;
	private int currentCode3 = 0;
	
	
	public CombinationLockPad(int argTimecode1, int argTimecode2, int argTimecode3) {
		correctCode1 = argTimecode1;
		correctCode2 = argTimecode2;
		correctCode3 = argTimecode3;
	}
	
	
	public void checkCode() {
		if(currentCode1 == correctCode1 && currentCode2 == correctCode2 && currentCode3 == correctCode3) {
			isCodeCorrect = true;
		} else {
			isCodeCorrect = false;
		}
	}
	
	public boolean getIsCodeCorrect() {
		return isCodeCorrect;
	}

	public int getCurrentCode1() {
		return currentCode1;
	}

	public void setCurrentCode1(int argCurrentCode1) {
		currentCode1 = argCurrentCode1;
	}

	public int getCurrentCode2() {
		return currentCode2;
	}

	public void setCurrentCode2(int argCurrentCode2) {
		currentCode2 = argCurrentCode2;
	}

	public int getCurrentCode3() {
		return currentCode3;
	}

	public void setCurrentCode3(int argCurrentCode3) {
		currentCode3 = argCurrentCode3;
	}

	
	
}