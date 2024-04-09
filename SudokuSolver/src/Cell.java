
public class Cell {
	
	public int cellDigit;
	public int cellSpot;
	
	public Cell() {
		cellDigit = -1;
		cellSpot = -1;
	}
	
	public Cell(int cellDigit) {
		this.cellDigit = cellDigit;
	}
	
	public void changeDigit(int cellDigit) {
		this.cellDigit = cellDigit;
	}
	
	public int returnDigit() {
		return cellDigit;
	}
	
	public void changeSpot(int cellSpot) {
		this.cellSpot = cellSpot;
	}
	
	public int returnSpot() {
		return cellSpot;
	}
}
