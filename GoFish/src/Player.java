import java.util.Random;

public class Player {
	
	int num; // Player's internal number, starting at 0
	Hand hand;
	int score;
	Player[] players;
	Deck deck;
	static int totalScore = 0;
	static Random random = new Random();
	
	public Player(int num, Player[] players, Deck deck) {
		this.num = num - 1;
		score = 0;
		hand = new Hand();
		this.players = players;
		this.deck = deck;
	}
	
	public String toString() {
		return "Player " + (num+1);
	}
	
	public void takeTurn() {
		if(hand.isEmpty()) {
			if(deck.isEmpty()) {
				return;
			} else {
				addCard(deck.takeCard());
			}
		}
		Player opponent = chooseOpponent();
		Rank rank = chooseRank();
		if(opponent.askFor(this, rank)) {
			takeTurn();
		}
	}
	
	private Player chooseOpponent() {
		int n = random.nextInt(players.length-1);
		if(n >= num)
			n++;
		return players[n];
	}
	
	private Rank chooseRank() {
		return hand.chooseRank();
	}
	
	private boolean askFor(Player asker, Rank rank) {
		System.out.println(asker + " asks " + this + " for " + rank + "'s");
		int n = hand.numCards(rank);
		if(n > 0) {
			System.out.println(this + " gives " + asker + " " + n + " " + rank + "'s");
			asker.giveCards(this, rank);
			return true;
		} else {
			System.out.println(this + " tells " + asker + " 'Go Fish'!");
			return asker.goFish(rank);
		}
	}
	
	private void giveCards(Player opponent, Rank rank) {
		hand.takeCards(opponent.hand, rank);
		checkForBook(rank);
	}
	
	private void checkForBook(Rank rank) {
		if(hand.numCards(rank) == 4) {
			System.out.println(this + " puts down a book of " + rank);
			hand.remove(rank);
			totalScore++;
			score++;
		}
	}
	
	public void addCard(Card card) {
		hand.addCard(card);
		checkForBook(card.rank);
	}
	
	private boolean goFish(Rank rank) {
		if(deck.isEmpty()) {
			return false;
		} else {
			Card card = deck.takeCard();
			addCard(card);
			System.out.println(this + " takes a card from the deck.");
			if(card.rank == rank) {
				System.out.println( this + " got the rank asked for!");
				return true;
			}
			return false;
		}
	}
	
	public int getScore() {
		return score;
	}
	
	public static int getTotalScore() {
		return totalScore;
	}
	
}
