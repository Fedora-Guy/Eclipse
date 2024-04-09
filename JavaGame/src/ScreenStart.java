
public class ScreenStart implements Screen {
	
	private GameGraphics gameGraphics;
	
	public ScreenStart(GameGraphics gameGraphics) {
		this.gameGraphics = gameGraphics;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		gameGraphics.startScreen();
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		gameGraphics.requestFocusInWindow();
		
	}

}
