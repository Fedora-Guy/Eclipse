import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		Paint paint = new Paint();
        
        jFrame.setSize(774, 600);
        jFrame.setTitle("Sudoku Solver");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(paint);      
	
}
}
