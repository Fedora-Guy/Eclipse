package TicTacToe;

import java.util.Scanner;

public class TicTac{ 
	public static void main (String[] args) {
		boolean gameOver = false;
		int playerTurn = 1;
		int selection = 0;
		Scanner s = new Scanner(System.in);
		
		String[][] ticTac = {{"1  ", "2  ", "3  "}, {"4  ", "5  ", "6  "}, {"7  ", "8  ", "9  "}};
		
		while(!gameOver) {
			
			if(playerTurn % 2 == 0) {
				System.out.println("Enter Player O move:");
			} else {
				System.out.println("Enter Player X move:");
			}
			
			selection = s.nextInt();
			
			if(selection == 1) {
				if(playerTurn % 2 == 0) {
					ticTac[0][0] = "O  ";
				} else {
					ticTac[0][0] = "X  ";
				}
			} else if(selection == 2) {
				if(playerTurn % 2 == 0) {
					ticTac[0][1] = "O  ";
				} else {
					ticTac[0][1] = "X  ";
				}
			} else if(selection == 3) {
				if(playerTurn % 2 == 0) {
					ticTac[0][2] = "O  ";
				} else {
					ticTac[0][2] = "X  ";
				}
			} else if(selection == 4) {
				if(playerTurn % 2 == 0) {
					ticTac[1][0] = "O  ";
				} else {
					ticTac[1][0] = "X  ";
				}
			} else if(selection == 5) {
				if(playerTurn % 2 == 0) {
					ticTac[1][1] = "O  ";
				} else {
					ticTac[1][1] = "X  ";
				}
			} else if(selection == 6) {
				if(playerTurn % 2 == 0) {
					ticTac[1][2] = "O  ";
				} else {
					ticTac[1][2] = "X  ";
				}
			} else if(selection == 7) {
				if(playerTurn % 2 == 0) {
					ticTac[2][0] = "O  ";
				} else {
					ticTac[2][0] = "X  ";
				}
			} else if(selection == 8) {
				if(playerTurn % 2 == 0) {
					ticTac[2][1] = "O  ";
				} else {
					ticTac[2][1] = "X  ";
				}
			} else if(selection == 9) {
				if(playerTurn % 2 == 0) {
					ticTac[2][2] = "O  ";
				} else {
					ticTac[2][2] = "X  ";
				}
			}
			System.out.println();
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					System.out.print(ticTac[i][j]);
				}
				System.out.println();
			}
			

			
			if(ticTac[0][0].equals(ticTac[0][1]) && ticTac[0][0].equals(ticTac[0][2])) {
				gameOver = true;
			} else if (ticTac[0][0].equals(ticTac[1][0]) && ticTac[0][0].equals(ticTac[2][0])) {
				gameOver = true;
			} else if (ticTac[0][0].equals(ticTac[1][1]) && ticTac[0][0].equals(ticTac[2][2])) {
				gameOver = true;
			} else if (ticTac[2][0].equals(ticTac[2][1]) && ticTac[2][0].equals(ticTac[2][2])) {
				gameOver = true;
			} else if (ticTac[0][2].equals(ticTac[1][2]) && ticTac[0][2].equals(ticTac[1][2])) {
				gameOver = true;
			}  else if (ticTac[2][0].equals(ticTac[1][1]) && ticTac[2][0].equals(ticTac[0][2])) {
				gameOver = true;
			} else  {
				
			}
			
			playerTurn++;
			
		}
		if(playerTurn % 2 == 1) {
			System.out.println("Player O won");
		} else {
			System.out.println("Player X won");
		}
	}
		
}