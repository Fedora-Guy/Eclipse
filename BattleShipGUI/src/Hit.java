public class Hit extends Piece  {
	
	public Hit() {
		super('*');
	}
	
	public Piece fireAt() {
		System.out.println("You've already shot there and hit, fool!");
		return this;
	}
	
	public void setSymbol(char sym) { this.sym = sym; }
}
