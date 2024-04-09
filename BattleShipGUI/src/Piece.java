
public abstract class Piece {
	
	char sym;
	
	public Piece(char sym) { this.sym = sym;}
	
	public String toString() {
		return sym + " ";
	}
	
	public abstract Piece fireAt();
	
	public boolean isSunk() {
		return false;
	}
}
