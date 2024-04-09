import java.util.Scanner;
public class HighScore {
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int[] highScores = new int[10];
		String[] playerNames = new String[10];
		int command = 0;
		String tempName = "";
		int tempScores = 0;
		
		while(true) {
			System.out.print("Enter 1 to add player, 2 to print all players, 3 to search player, 4 to delete player, or 10 to exit:");
			command = s.nextInt();
			s.nextLine();
			if(command == 1) {
				System.out.print("Enter player name:");
				tempName = s.nextLine();
				System.out.print("Enter " + tempName + " scores:");
				tempScores = s.nextInt();
				
				for(int i = 0; i < playerNames.length; i++) {
					if(playerNames[i] == null || playerNames[i] == "") {
						playerNames[i] = tempName;
						highScores[i] = tempScores;
						break;
					} else {
						continue;
					}
				}
			} else if (command == 2) {
				for(int i = 0; i < playerNames.length; i++) {
					if(playerNames[i] == null || playerNames[i] == "" ) {
						break;
					} else {
						System.out.println(playerNames[i] + ": " + highScores[i]);
					}
				}
			} else if (command == 3) {
				System.out.print("Enter player name:");
				tempName = s.nextLine();
				boolean actualPlayer = false;
				for(int i = 0; i < playerNames.length; i++) {
					if(playerNames[i] != null && playerNames[i].equals(tempName)) {
						System.out.println(playerNames[i] + ": " + highScores[i]);
						actualPlayer = true;
					}
				}
				
				if(actualPlayer != true) {
					System.out.println(tempName + " wasn't found!");
				}
				
			} else if (command == 4) {
				System.out.print("Enter player name:");
				tempName = s.nextLine();
				for(int i = 0; i < playerNames.length; i++) {
					if(playerNames[i] != null && playerNames[i].equals(tempName)) {
						playerNames[i] = "";
						highScores[i] = 0;
					}
				}
			} else if (command == 10) {
				break;
			} else {
				
			}
			
		}
		
		
		s.close();
	}
}