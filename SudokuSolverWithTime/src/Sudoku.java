
public class Sudoku {
	
	private int width;
	private int height;
	private Cell[] cell = new Cell[81];
	
	public Sudoku() {
		width = 45;
		height = 45;
		for(int i = 0; i < 81; i++) {
			cell[i] = new Cell(i);
		}
	}
	
	public int returnX(int i) {
		int x = 25 + (50*i);
		int widthGap = (i/3) * 15;
		return x + widthGap;
	}
	
	public int returnY(int j) {
		int y = 15+(50*j);
		int heightGap = (j/3) * 5;
		return y + heightGap;
	}
	
	public int returnWidth() {
		return width;
	}
	
	public int returnHeight() {
		return height;
	}
	
	public Cell returnSpecificCell(int i) {
		return cell[i];
	}
}
