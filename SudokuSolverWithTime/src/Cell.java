
public class Cell {
	private int cellSpot;
	private int cellDigit;
	
	public Cell() {
		cellSpot = 0;
		cellDigit = -1;
	}
	
	public Cell(int cellSpot) {
		this.cellSpot = cellSpot;
		cellDigit = -1;
	}
	
	public Cell(int cellSpot, int cellDigit) {
		this.cellSpot = cellSpot;
		this.cellDigit = cellDigit;
	}
	
	public void changeCellDigit(int cellDigit) {
		this.cellDigit = cellDigit;
	}
	
	public int returnCellDigit(){
		return cellDigit;
	}
	
	public int returnCellSpot() {
		return cellSpot;
	}
}
