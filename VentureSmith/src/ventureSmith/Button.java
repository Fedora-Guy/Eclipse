package ventureSmith;

import java.awt.image.BufferedImage;

public class Button {
	
	BufferedImage[] PNGs = new BufferedImage[2];
	int[] loc = new int[2];
	
	public Button(BufferedImage[] pngs, int[] loc) {
		this.PNGs = pngs;
		this.loc = loc;
	}
	
}
