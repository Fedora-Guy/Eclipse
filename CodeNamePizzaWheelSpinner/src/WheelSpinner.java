import java.io.File;
import java.util.Random;

// Class that actually randomly picks an outcome
public class WheelSpinner {
	
	
	// You can hardcode a number of outcomes by changing the number below this
	private int outcomes = 0;
	private Random random = new Random();
	
	public WheelSpinner() {
		
	}
	
	public void answer() {
		int answer = -1;
		if(outcomes == 0) {
			//! CHANGE THE PATH OF THIS TO THE OUTCOMES FOLDER ON YOUR COMPUTER!
			File images = new File("C:\\Users\\keith\\eclipse-workspace\\CodeNamePizzaWheelSpinner\\src\\outcomes");
			String[] allInfo = images.list();
			answer = random.nextInt(allInfo.length);
		} else {
			answer = random.nextInt(outcomes);
		}
		System.out.println(answer);
//		return answer;
	}
	
}
