import java.util.Scanner;
import javax.swing.*;

public class NonogramSolver {
	public static void main(String[] args) {
		
//		Scanner s = new Scanner(System.in);
//		
//		System.out.println("How big is your grid? Enter in format HorziontalxVertical");
//		String[] words = s.nextLine().split("x");
		String[] words =JOptionPane.showInputDialog("How big is your grid? Enter in format HorziontalxVertical").split("x");
		
		int height = Integer.parseInt(words[0]);
		int width = Integer.parseInt(words[1]);
		
		System.out.println(height);
		System.out.println(width);
		
		String array = "";
		
		for(int row = 0; row < height; row++) {
			for(int col = 0; col < width; col++) {
//				System.out.print("|X| ");
				array += "|X| ";
			}
//			System.out.println("");
			array += "\n";
		}
		System.out.println(array);
		
		
		
		
		
		
		
	}
}
