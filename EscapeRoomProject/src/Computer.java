
public class Computer {
	private int combinationlockCode2;
	private boolean isTurned = false;
	private boolean examineComputer = false;
	
	public Computer() {
		combinationlockCode2 = (int)(Math.random() * (9));
	}
	
	public Computer(int argCode) {
		combinationlockCode2 = argCode;
	}
	
	public int getCombinationlockCode2() {
		return combinationlockCode2;
	}
	
	public boolean getIsTurned() {
		return isTurned;
	}
	
	public void turned() {
		if(isTurned == false) {
			isTurned = true;
		} else {
			isTurned = false;
		}
	}
	
	public void lookAtComputer() {
		examineComputer = true;
	}
	
	public boolean isLookingAtComputer() {
		return examineComputer;
	}
}
