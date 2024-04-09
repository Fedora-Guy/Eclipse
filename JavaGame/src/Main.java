import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		game();
	}
	
	public static void game() {
		boolean gameState = true;
		Controls controls = new Controls();
		GameGraphics gameGraphics = new GameGraphics(controls);
		GameFrame gameFrame = new GameFrame(new JFrame(), gameGraphics);
		gameFrame.start();
		
		controls.addScreen(State.START, new ScreenStart(gameGraphics));
		controls.addScreen(State.RUNNING, new ScreenRunning(gameGraphics));
		controls.addScreen(State.PAUSED, new ScreenPaused(gameGraphics));
		controls.addScreen(State.GAME_OVER, new ScreenGameOver(gameGraphics));
		while(gameState) {
			controls.run();
		}
		gameFrame.end();
	}
}
