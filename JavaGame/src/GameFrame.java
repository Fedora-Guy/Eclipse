import javax.swing.JFrame;

public class GameFrame  {
	
	private JFrame jFrame;
	
	public GameFrame(JFrame jFrame, GameGraphics gameGraphics) {
		this.jFrame = jFrame;
		jFrame.setSize(1920, 1080); 
		jFrame.setTitle("Java Game");
		jFrame.setResizable(false);
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jFrame.setUndecorated(false); // CHANGE THIS IF YOU WANT TO HAVE THE MENU BAR, I.G. IT INCLUDES THE "X" IN THE TOP RIGHT HAND CORNER
		jFrame.setFocusable(true);
//		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.add(gameGraphics);
	}
	
	public void start() {
		jFrame.setVisible(true);
	}
	public void end() {
		jFrame.setVisible(false);
	}
}
