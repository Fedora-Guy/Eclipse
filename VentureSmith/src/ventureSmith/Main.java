package ventureSmith;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame obj = new JFrame();
		Body body = new Body();
		
		obj.setSize(816, 639);
		obj.setTitle("Adventure Blacksmith");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(body);
		
	}

}
