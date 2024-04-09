
public class PaintCan {
	private int combinationlockCode3;
	private boolean examinePaintCans = false;
	
	public PaintCan() {
		combinationlockCode3 = (int)(Math.random() * (9));

	}
	
	public PaintCan(int argCode) {
		combinationlockCode3 = argCode;
	}
	
	public int getCombinationlockCode3() {
		return combinationlockCode3;
	}
	
	public void lookAtCans() {
		examinePaintCans = true;
	}
	
	public boolean isLookingAtCans() {
		return examinePaintCans;
	}
}
