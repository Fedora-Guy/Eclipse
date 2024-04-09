import java.util.HashMap;
import java.util.Map;

public class Controls  {
	
	private State state = State.START;
	private Map<State, Screen> screens = new HashMap<>();
	
	public void addScreen(State state, Screen screen) {
		screens.put(state, screen);
	}
	
	public void run() {
		Screen screen = screens.get(state);
		screen.handleInput();
		screen.update();
		screen.draw();
	}
	
	public State getState() {
		return state;
	}
	
	public void paused() {
		state = State.PAUSED;
	}
	
	public void game_over() {
		state = State.GAME_OVER;
	}
	
	public void start() {
		state = State.START;
	}
	
	public void running() {
		state = State.RUNNING;
	}
}
