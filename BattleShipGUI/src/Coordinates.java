import java.util.Random;
import java.util.Scanner;

public class Coordinates {
	
	public int x, y;
	
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Coordinates getRandomCoordinates(Random random) {
		return new Coordinates(random.nextInt(10), random.nextInt(10));
	}
	
	public static Coordinates getCoordinates(Scanner sc) {
		String s;
		while(!((2 <= (s = sc.nextLine()).length() && s.length() <=3 && 'A' <= s.charAt(0) && s.charAt(0) <= 'J' && '1' <= s.charAt(1) && s.charAt(1) <= '9') 
				&& (s.length() == 2 || (s.charAt(1) == '1' && s.charAt(2) == '0'))))
			System.out.println("Invalid location. Try again.");
		int x = Integer.parseInt(s.substring(1))-1;
		int y = s.charAt(0) - 'A';
		return new Coordinates(x,y);
	}
}
