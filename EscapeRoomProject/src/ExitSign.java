
public class ExitSign {
	private int combinationlockCode1;
	private boolean examineSign;
	
	public ExitSign() {
		combinationlockCode1 = (int)(Math.random() * (9));
		examineSign = false;
	}
	
	public ExitSign(int argCode) {
		combinationlockCode1 = argCode;
	}
	
	public int getCombinationlockCode1() {
		return combinationlockCode1;
	}
	
	public void lookAtSign() {
		examineSign = true;
	}
	
	public boolean isLookingAtSign() {
		return examineSign;
	}
}
