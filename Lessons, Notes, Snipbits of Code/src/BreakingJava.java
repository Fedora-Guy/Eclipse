
public class BreakingJava {
	
	public static void main(String[] args) throws StackOverflowError{
		BreakingJava bj = new BreakingJava();
		bj.a();
	}
	
	public boolean a() {
		
		return b();
	}
	
	public boolean b() {
		
		return a();
	}
}
