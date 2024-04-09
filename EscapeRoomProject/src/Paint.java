import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

// Class Represents: The Down Arrow image, and it's creation
// Player interacts with this class when they launch the program, or change the playerlocation, it draws this image.
@SuppressWarnings("serial")
public class Paint extends JComponent {
	
	// When called, it gets the "path".png from the Images folder, then draws it at the X and Y given through the parameters.
	public void imageDraw(Graphics2D g2, String path, int x, int y) {
		BufferedImage img = null;
		try {
			URL url = KeithReisEscapeRoom.class.getResource("/Images/" + path + ".png");
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
			}
		if(img != null) {
			if(path.equals("TopFloor") || path.equals("BottomFloor") || path.equals("MiddleFloor") || path.equals("MiddleFloorClosed") || path.equals("MiddleFloorOpened")|| path.equals("MiddleFloorDoor")) {
				g2.drawImage(img, x, y+50, 1920, 1080-100, null);
			} else if (path.equals("GrandFatherClockInput") || path.equals("CombinationLockInput")) {
				g2.drawImage(img, x, y+50, 1920, 1080-100, getBackground(), null);
			} else {
				g2.drawImage(img, x, y, null);
			}
		}
	}
}