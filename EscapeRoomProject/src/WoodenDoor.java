
public class WoodenDoor {
	private int code1;
	private int code2;
	private int code3;
	private boolean isUnlocked = false;
	
	public WoodenDoor(int argCode1, int argCode2, int argCode3) {
		code1 = argCode1;
		code2 = argCode2;
		code3 = argCode3;
	}
	
	public void inputCode(int x, int y, int z) {
		if(isUnlocked == false) {
			if(x == code1 && y == code2 && z == code3) {
				isUnlocked = true;
			}
		}
	}
	
	public boolean getIsUnlocked() {
		return isUnlocked;
	}
}
