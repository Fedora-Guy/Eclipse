import javax.swing.JFrame;

public class SudokuMain {
	public static void main(String[] args) {
		
		
		/*
		 * Get information about Sudoku Board ~ input mechanism
		 * Display the Sudoku Board ~ Graphics
		 * Buttons ~ Graphic Button
		 * Solve ~ Bruteforcing, Tackle Edge Cases
		 * 
		 * 
		 * 
		 */
		
		JFrame jFrame = new JFrame();
		SudokuPaint paint = new SudokuPaint();
		jFrame.setTitle("Sudoku Solver Youtube");
		jFrame.setSize(1150, 950);
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		jFrame.setAlwaysOnTop(false);
		jFrame.setFocusable(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(paint);
		paint.requestFocusInWindow();
	}
}
