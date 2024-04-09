package y2021.m9.d27;

public class InClass {
	public static void main(String[] args) {
		/* THIS WEEK'S TOPICS:
		 * Nested loops
		 * loop control
		 */
		
		int rowNum, colNum;
		for (rowNum = 1; rowNum <= 3; rowNum++) {
			for (colNum =1; colNum <= 2; colNum++) {
				System.out.print(" [ " + rowNum + " , " + colNum + " ]");
			}
			System.out.println();
		}
	}
}
