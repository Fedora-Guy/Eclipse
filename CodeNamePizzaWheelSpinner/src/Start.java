import java.awt.Canvas;

/* Name: Keith Reis
 * Program Name: WheelSpinner
 * Due Date: XX/XX/XX
 * Description: A sideproject to both improve my skill, and test my limits of coding.
 * Assistance: None
 */

// TODO
// "I want someone to make basically a wheel spinner, but on my computer. Ok? And for the wheel spinner, I can put whatever images I want ok? 
// It could be a signed card, a pizza. I want the wheel spinner, to not be a wheel, but the mystery box." Also has to be operated via streamdeck button

// Constraints:
// Must be a "wheel spinner" (Roughly equal chances for each outcome)
// Must be able to easily import images as potential outcomes
// Must be a visual of the mystery box
// Must be able to use streamdeck ~ I personally don't know the capabilities of streamdeck

public class Start extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	
	private boolean running = false;
	private Thread thread;
	
	
	public synchronized void start(){
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {	
//		WheelSpinner wheel = new WheelSpinner();
//		ImportImages importImages = new ImportImages();
//		new Window(800, 600, "Mystery Box Spinner", new Start());
		System.out.println("Wrong Main Nerd");
	}
}
