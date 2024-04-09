import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.net.URL;

public class Main {
	public static void main(String[] args) {
		// Things to do:
		// Make a *simple* map - Jframe
		// Make a *simple* network interaction - Network/Youtube video
		// Make a slightly more map ~ tile base 1 layer {Maybe add graphics) - Jframe with math ( + Pixel Studios for graphics)
		// Make network interaction to be turn base AND unqiue (i.g. Only Player 2 CAN move Player 2) (Network with math + server?)
		// Make map become multiple layers; i.g. click on house ( or Green square), map changes) (Jframe; relearn it all to learn panes/content panes; Pixel Studios )
		// Make combat menu {Player clicks on Player Icon and gets a menu to interact with; Player press "ESC", get Menu} (KeyPressed; JFrame; Pixels Studios [cog wheel]; Animation?)
		// More jazz here.
		// *players can only move up to their movement in squares
		// *Maps have height changes, so it can't be all on the same plane; view from isometric.
		// *kill me
		
		 JFrame jFrame = new JFrame("DND Game");
//	     Body body = new Body();   
	     
//	     jFrame.setSize(1920, 1080);
	     
//	     URL url = EnemyMain.class.getResource("/Images/DnDIcon.png");
//	     ImageIcon img = new ImageIcon(url);
//	     jFrame.setIconImage(img.getImage());
	     jFrame.setResizable(false);
	     jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	     jFrame.setUndecorated(true);
	     jFrame.setVisible(true);
	     jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	     jFrame.add(body);        
		
		
	}
}