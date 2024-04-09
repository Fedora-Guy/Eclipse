import java.util.Random;

public class Deck {
	Card[] cards;
	int numCards;
	static Random random = new Random();
	
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();
		numCards = 52;
		cards = new Card[numCards];
		for(int i = 0; i < numCards; i++) {
			cards[i] = new Card(ranks[i % 13], suits[i / 13]);
		}
	}
	
	private void swap(Card[] cards, int i, int j) {
		Card t = cards[i]; cards[i] = cards[j]; cards[j] = t;
	}
	
	public void shuffle() {
		for(int i = 0; i<numCards; i++) {
			swap(cards, i, random.nextInt(i+1));
		}
	}
	
	public boolean isEmpty() {
		return numCards == 0;
	}
	
	public Card takeCard() {
		return cards[--numCards];
	}
	
	public void deal(Player[] players, int n) {
		for(int i=0; i<n; i++) {
			for(int j = 0; j< players.length; j++) {
				players[j].addCard(takeCard());
			}
		}
	}
}
