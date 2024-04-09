/*
 * Creator: Keith Reis
 * Assistance: Adam Liswieski
 * Description: Basically a clone of Minecraft; done fully in Java Eclipse.
 */
import javax.swing.JFrame;

public class MineHackMain {

	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
        
		jFrame.setSize(774, 539);
        jFrame.setTitle("Mine Hack");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setAlwaysOnTop(true);
        jFrame.setFocusable(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(body);   

	}

}
