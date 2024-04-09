
public class GoFish {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		final int numPlayers = 4;
		Player[] players = new Player[numPlayers];
		for(int i = 0; i< numPlayers; i++) {
			players[i] = new Player(i+1, players, deck);
		}
		deck.deal(players,  numPlayers <= 3 ? 7 : 5);
		while(Player.getTotalScore() != 13) {
			for(int i = 0; i< numPlayers; i++) {
				players[i].takeTurn();
			}
		}
		for(int i = 0; i < numPlayers; i++) {
			System.out.println(players[i] + ": " + players[i].score);
		}
		
	}
}
