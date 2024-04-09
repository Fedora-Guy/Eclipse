import javax.swing.JFrame;


public class NonogramMain {
	public static void main(String[] args) {
			JFrame jFrame = new JFrame();
	        NonogramBody body = new NonogramBody();
	        
	        jFrame.setSize(516, 539);
	        jFrame.setTitle("Nonogram Solver 2.8");
	        jFrame.setResizable(false);
	        jFrame.setVisible(true);
	        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jFrame.add(body);        
		
	}
}
