import java.util.Random;

public class Hand {
	Card[] cards;
	int numCards;
	static Random random = new Random();
	
	public Hand() {
		cards = new Card[52];
		numCards = 0;
	}
	
	public boolean isEmpty() {
		return numCards == 0;
	}
	
	public void addCard(Card card) {
		cards[numCards++] = card;
	}
	
	public Rank chooseRank() {
		return cards[random.nextInt(numCards)].rank;
	}
	
	public int numCards(Rank rank) {
		int count = 0;
		for(int i = 0; i < numCards; i++) {
			if(cards[i].rank == rank) {
				count++;
			}
		}
		return count;
	}
	
	public void remove(Rank rank) {
		for(int i = 0; i < numCards;) {
			if(cards[i].rank == rank) {
				cards[i] = cards[--numCards];
			}
			else {
				i++;
			}
		}
	}
	
	public void takeCards(Hand oppHand, Rank rank) {
		for(int i = 0; i < oppHand.numCards; i++) {
			if(oppHand.cards[i].rank == rank) {
				addCard(oppHand.cards[i]);
			}
		}
		oppHand.remove(rank);
	}
	
}
