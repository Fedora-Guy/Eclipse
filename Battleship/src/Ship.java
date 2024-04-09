
public class Ship extends Piece {
	
	private String name;
	private int size;
	private int numHits;
	private Hit hit;
	private char realSym;
	
	public Ship(String name, int size, char sym) {
		super('.');
		realSym=sym;
		this.name=name;
		this.size=size;
		numHits = 0;
		hit = new Hit();
	}
	
	public Piece fireAt() {
		if(++numHits == size) {
			System.out.println("You sunk my " + name + ".");
			hit.setSymbol(realSym);
		} else {
			System.out.println("You hit my ship.");
		}
		return hit;
	}
	
	public boolean isSunk() {
		return numHits == size;
	}
	
	public int getSize() {
		return size;
	}
}
