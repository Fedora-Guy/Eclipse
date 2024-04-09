
package dndTracker;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.net.URL;


public class EnemyMain {

    public static void main(String[] args) {
        
        JFrame jFrame = new JFrame();
        Body body = new Body();
        
        jFrame.setSize(1150, 525);
        jFrame.setTitle("dndBeyond");
        URL url = EnemyMain.class.getResource("/Images/DnDIcon.png");
        ImageIcon img = new ImageIcon(url);
        jFrame.setIconImage(img.getImage());
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(body);        
        
    }

}