import java.util.Scanner;
import javax.swing.JFrame;

public class Battleship {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Board board = new Board(); // construct board and place ships
//		while(!board.gameOver()) {
			System.out.println(board);
//			System.out.print("Enter coordinates > ");
//			Coordinates coordinates = Coordinates.getCoordinates(sc);
//			board.fireAt(coordinates); // Fire at position and give results.
//		}
		JFrame jFrame = new JFrame();
		BattleShipGUI body = new BattleShipGUI(board);
		jFrame.setSize(1150, 850);
		jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(body);
		while(!board.gameOver()) {
			
		}
		jFrame.setVisible(false);
//		System.out.println(board);
		System.out.println("You win!!");
	}
}