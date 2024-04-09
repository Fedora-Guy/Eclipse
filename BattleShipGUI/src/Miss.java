
public class Miss extends Piece {
	
	public Miss() {
		super('x');
	}
	
	public Piece fireAt() {
		System.out.println("You've already shot there and missed, fool!");
		return this;
	}
	
}