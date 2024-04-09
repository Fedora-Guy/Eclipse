
public class Water extends Piece {
	
	private static Piece miss = new Miss();
	
	public Water() {
		super('.');
	}
	
	public Piece fireAt() {
		System.out.println("You've missed!");
		return miss;
	}
	
}