import javax.swing.JFrame;

public class SudokuMain {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		SudokuBody body = new SudokuBody();
		jFrame.setSize(774, 539);
        jFrame.setTitle("Sudoku Solver");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(body);
	}
}
