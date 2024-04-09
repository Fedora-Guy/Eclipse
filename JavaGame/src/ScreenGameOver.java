
public class ScreenGameOver implements Screen{

	private GameGraphics gameGraphics;
	
	public ScreenGameOver(GameGraphics gameGraphics) {
		this.gameGraphics = gameGraphics;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		gameGraphics.repaint();
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		gameGraphics.gameOverScreen();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
