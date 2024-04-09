
public class GrandFatherClockCompartment {
	private boolean hasKey = false;
	private boolean isOpened = false;
	
	
	
	public void takeKey() {
			if(hasKey == false) {
				hasKey = true;
			}
	}
	
	public void openDoor() {
		if(isOpened == false) {
			if(checkCode() == true) {
				isOpened = true;
			}
		}
	}
	
	public boolean checkCode() {
		
		return false;
	}
	
	public boolean getHasKey() {
		return hasKey;
	}
}
