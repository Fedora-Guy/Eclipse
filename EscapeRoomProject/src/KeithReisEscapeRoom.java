import javax.swing.JFrame;

// Driver Class ~ Contains the Main Method
// Class Represents: The starter bit of code that makes everything run
// The compiler has to run code from here in order for the game to start
public class KeithReisEscapeRoom {
	//Main Method ~ However all logic is in the PaintClasses Class.
	public static void main (String[] args) {
		
		JFrame jFrame = new JFrame();
        PaintClasses paintClasses = new PaintClasses();
        
        jFrame.setSize(1920, 1080); 
        jFrame.setTitle("Escape Room");
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH ); 
        jFrame.setUndecorated(true); // CHANGE THIS IF YOU WANT TO HAVE THE MENU BAR, I.G. IT INCLUDES THE "X" IN THE TOP RIGHT HAND CORNER
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(paintClasses);
        
        // The only real way to test is to play it! Currently included is: Arrows to go Up and Down; The Brick in the Top Floor, and the Middle Floor Drawing (unrefined)
	}
}
