import java.util.Scanner;
public class Battleship {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Board board = new Board(); // construct board and place ships
		while(!board.gameOver()) {
			System.out.println(board);
			System.out.print("Enter coordinates > ");
			Coordinates coordinates = Coordinates.getCoordinates(sc);
			board.fireAt(coordinates); // Fire at position and give results.
		}
		System.out.println(board);
		System.out.println("You win!!");
	}
}