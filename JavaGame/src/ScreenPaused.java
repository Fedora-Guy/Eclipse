
public class ScreenPaused implements Screen{

	private GameGraphics gameGraphics;
	
	public ScreenPaused(GameGraphics gameGraphics) {
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
		gameGraphics.pausedScreen();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
