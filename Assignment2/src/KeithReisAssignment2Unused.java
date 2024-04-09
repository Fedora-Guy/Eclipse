/* Name: Keith Reis
 * Program Name: Getting to 23
 * Due Date: 2/16/22
 * Description: Using 4 ints, and a combination of math, see if they equal 23
 * Assistance: None
 */
import java.util.Random;

public class KeithReisAssignment2Unused {
	public static void main(String[] args) {
		// Creates an Array with ints 1-10, then randomizes it.
		// Next it puts the first four ints into a new Array.
		// Lastly it prints the four numbers
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Random random = new Random();
		for(int i = 0; i <= 9; i++) {
			int j = random.nextInt(i+1);
			int t = array[i]; 
			array[i] = array[j]; 
			array[j] = t;
		}
		int[] ints = {array[0], array[1], array[2], array[3]};
		System.out.println("Numbers: " + ints[0] + " "
				+ ints[1] + " " + ints[2] + " " + ints[3]);
		
		
	}
}
