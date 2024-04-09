
public class ScreenRunning implements Screen{

	private GameGraphics gameGraphics;
	
	public ScreenRunning(GameGraphics gameGraphics) {
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
		gameGraphics.runningScreen();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
