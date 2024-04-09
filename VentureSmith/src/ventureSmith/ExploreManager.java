package ventureSmith;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.KeyEvent;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ExploreManager {
	
	int[] mouse = {0, 0};
	int[] playerLoc = {0, 0};
	int biome;
	BufferedImage[] grassTiles = new BufferedImage[4];
	Chunk[][] chunks = new Chunk[20][20];
	
	public ExploreManager(int currentBiome) {
		grassTiles[0] = Custom.cropImage("grassTiles", biome*30, (biome/3)*30, 30, 30);
		grassTiles[1] = Custom.cropImage("grassTiles", (biome*2+1)*30, ((biome/3)*2)*30, 30, 30);
		grassTiles[2] = Custom.cropImage("grassTiles", biome*30, (biome/3+1)*30, 30, 30);
		grassTiles[3] = Custom.cropImage("grassTiles", (biome*2+1)*30, ((biome/3)*2+1)*30, 30, 30);
		
		this.biome = currentBiome;
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				chunks[j][i] = new Chunk(new int[] {j, i});
				for(int k = 0; k < 50; k++)
					for(int l = 0; l < 50; l++)
						chunks[j][i].setTile(new Tile(new String[] {"natural", "empty"}, false, 0), new int[] {l, k});
			}
		}
	}
	
	public void paint(Graphics2D g2, int[] state, ArrayList<Aesthetic> animations) {
		//around 27x20 tiles onscreen at a time
		for(int i = 0; i < chunks[0].length; i++)
			for(int j = 0; j < chunks.length; j++)
				for(int k = 0; k < chunks[i][j].tiles[0].length; k++)
					for(int l = 0; l < chunks[i][j].tiles.length; l++) {
						Tile tile = chunks[i][j].tiles[k][l];
						g2.drawImage(grassTiles[tile.rand], i*30*50+k*30, j*30*50+l*30, null);
					}
	}
	
	public void physics() {
		
	}
	
	public void mouseInputs(MouseEvent e, Body body) {
		
	}
	
	public void mouseMoveInputs(MouseEvent e, int[] mouse) {
		this.mouse[0] = mouse[0];
		this.mouse[1] = mouse[1];
	}
	
	public void mouseWheelInputs(MouseWheelEvent e, Body body) {
		
	}
	
	public void keyInputs(KeyEvent e, Body body) {
		switch(e.getKeyCode()) {
		case(87):
			break;
		case(83):
			break;
		case(65):
			break;
		case(68):
			break;
		}
	}
	
}
