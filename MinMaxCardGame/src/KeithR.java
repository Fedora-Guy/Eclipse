import java.util.ArrayList;
import java.util.HashMap;

public class KeithR {

    public static Player getPlayer() { return new player(); }

    public static class player implements Player {
    	long startTime = 0;
    	
    	/*
    	 • ArrayList<Card> hand: The player's hand of cards.
		 • ArrayList<Card> playedCards: The cards that have been played so far, in the order played.
		 • int numOnTable: the number of the cards on the table.
		 • int onTable: the total value of the cards on the table.
		 • int score1: The number of cards collected by the first player.
		 • int score2: The number of cards collected by the second player.
		 
		 Hints:
		 There's no need for cutting off search and using an evaluation function for this 
		 assignment. There should be enough time to search the whole tree with alpha-beta pruning. 
		 (Check if alpha-beta pruning does help). Since you can't see the opponent's hand, you 
		 should try playing your hand against a large number of randomly chosen hands 
		 (chosen from the unused cards), and then select the card that does the best overall.
    	 */
    	
    	// Improvements For calculating all PossibleOpponentHands.
    	// 1) Make it so we only store unique card VALUES in ArrayList<Cards> possibleOpponenthands
    	// Example: Ace of H, 2 of H, 3 of H, 4 of H, 5 of H, 6 of H, 7 of H
    	// Are identical (gameplay wise) to Ace of D, 2 of C, 3 of S, 4 of H, 5 of C, 6 of D, 7 of S
    	// 2) Store the Number of duplicate cards, so we multiply the miniMax value by that
    	// Example: If we have A 2 3 4 5 6 7 (or values: 1 2 3 4 5 6 7), we want to increment the number of times miniMax solves this array
    	
    	// Improvements: For calculating MiniMax, if I have two cards of the same value, only calculate it once, (skip) prune the other tree!
    	// 

	public Card playCard(ArrayList<Card> hand, ArrayList<Card> playedCards, int numOnTable, int onTable, int score1, int score2) {
		this.startTime = System.currentTimeMillis();
		
		// Determine who played first
		boolean playedFirst = false;
		if(playedCards.size() % 2 == 0) {
			playedFirst = true; // We played first
		} else {
			playedFirst = false; // Opponent played first
		}
		
		if(!playedFirst) { // Swaps the scores so that score1 is now us, score2 is always opponent
			int temp = score1;
			score1 = score2;
			score2 = temp;
		}
		
		Card currentCard = null; // Sets the current card to null;
		if(hand.size() == 1) { // Only 1 card in hand, play it; no need to calculate anything
			currentCard = hand.get(0);
			hand.remove(0);
			// System.out.println("Only 1 card left, returning card: " + currentCard);
			return currentCard;
		}
		
		hand = sort(hand); // Sorts my Hand (For calculating All possibleOpponentHands) 
		
		// for(Card c : hand) {
		// 	System.out.println(c + "Int value: " + convertToInteger(c));
		// }
		
		// Calculating ALL possible opponent Hands (7 hands, 6 hands, 5 hands, 4 hands, 3 hands, 2 hands)
		HashMap<String, Integer> duplicatedHandValues = new HashMap<>();
		ArrayList<ArrayList<Card>> possibleOpponentHands = new ArrayList<ArrayList<Card>>(); // Stores all possible opponent Hands
		possibleOpponentHands = calculateAllPossibleHands(hand, playedCards, duplicatedHandValues); // Passes in ExcludedCards
		
		// Lets assume we have, Ace, Ace, Ace, Ace, 2 (S), 2 (C), 2 (D).
		// RandyP Could have: (Spade, Club, Diamond, Heart) Should be -> (Club, Diamond, Heart, Spade)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 4 (C)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 4 (D)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 4 (H)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (C), 4 (D)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (C), 4 (H)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (D), 4 (H)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 5 (S)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 5 (C)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 5 (D)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (S), 5 (H)
		// 2 (H), 3 (S), 3 (C), 3 (D), 3 (H), 4 (C), 5 (S)
		// And so on. But FOR Sake of Calculation, this should be completed only ONCE by MiniMax, 
		// and the result is multiplied by the number of duplicate this has. 
		
		
		// System.out.println(hand.size() + " " + playedCards.size());
		// if(possibleOpponentHands != null && !possibleOpponentHands.isEmpty())
			  //System.out.println("possibleOpponentHands.size(): " + possibleOpponentHands.size());
		// Should be 4,272,048 OR 906,192 OR 169,911 OR 27,405 OR 3,654 OR 378 OR 27 
		// ^Incorrect, as now that we only get unique states, which varies on what cards I have + has been played
		// long endTime = System.currentTimeMillis();
		// System.out.print("Current hand Size: " + hand.size() + " ");
		// System.out.println("Total time to calculate Opponent Hand: " + (endTime-startTime));
		
		int[] bestCardArray = new int[hand.size()];
		for(int i = 0; i < hand.size(); i++) {
			bestCardArray[i] = 0;
		}
		
		//int loops = 0;
		for(int i = 0; i < possibleOpponentHands.size(); i++) {			
			// Run minimax in here
			ArrayList<Card> currentOpponentHand = possibleOpponentHands.get(i);
			for(int currentCard1 = 0; currentCard1 < hand.size(); currentCard1++) {
				int miniMaxOutcome = minimax(hand, currentOpponentHand, numOnTable, onTable, score1, score2, currentCard1);
				int outcome = 0;
				if(miniMaxOutcome > 0) {
					//increment
					outcome = 1;
				} else if(miniMaxOutcome < 0) {
					//decrement
					outcome = -1;
				} 
				bestCardArray[currentCard1] += (outcome * 1); // 1 Should be replaced with the UniqueOpponentHand's Weight.
			}
			
			//loops++;
			if((System.currentTimeMillis() - startTime) > 9500 ) {
				// System.out.println("Nearly ran out of time!");
				break;
			}
			
		}
//		if(hand.size() == 2) {
//			int i = 0;
//			for(ArrayList<Card> opponentHands : possibleOpponentHands) {
//				System.out.println("Hand " + i++ + ": ");
//				for(Card c : opponentHands) {
//					System.out.println(c);
//				}
//				System.out.println();
//			}
//		}
		// System.out.println("Sucessful loops: " + loops);
		int mostWins = 0;
		int cardIndex = 0;
		for(int i = 0; i < hand.size(); i++) {
			// System.out.println("Card " + hand.get(i) + " had " + bestCardArray[i] + " matches as best");
			if(mostWins < bestCardArray[i]) {
				mostWins = bestCardArray[i];
				cardIndex = i;
			}
		}
		// System.out.println();
		// System.out.println();
		// System.out.println("The highestest miniMax Card is " + hand.get(cardIndex));
		currentCard = hand.get(cardIndex);
//		System.out.println("Current value on table: " + onTable);
//		System.out.println("Running card: " + currentCard);
		
//		for(int i = 0; i < bestCardArray.length; i ++) {
//			boolean swapped = false;
//			for(int j = 0; j < bestCardArray.length - i - 1; j++) {
//				if(bestCardArray[j] > bestCardArray[j+1]) {
//					int temp = bestCardArray[j];
//					bestCardArray[j] = bestCardArray[j+1];
//					bestCardArray[j+1] = temp;
//					swapped = true;
//				}
//			}
//			if(swapped == false) {
//				break;
//			}
//		}
//		for(int i = 0; i < bestCardArray.length; i++) {
//			// System.out.println("bestCardArray[" + i + "]: " + bestCardArray[i]);
//		}
		
		
		/*
		long time = System.currentTimeMillis();
		long stopTime = time + 1000; //! DON'T FORGET TO CHANGE BACK TO + 9000 for 9 seconds of math
		for(; time < stopTime; time = System.currentTimeMillis()) { // MinMax Algorithm running for roughly 9 seconds
			
			ArrayList<Card> opponentsHand = new ArrayList<>();
			// Initial State of board
			//currentCard = minimax(hand, opponentsHand, onTable);
			int cardIndex = hand.indexOf(currentCard);
			if(cardIndex != -1) {
				//bestCard[cardIndex]++;
			}
			
		}
		
		int bestIndex = -1;
		int previousBest = 0;
		//for(int i = 0; i < bestCard.length; i++) {
		//	if(bestCard[i] > previousBest) {
		//		bestIndex = i;
		//		previousBest = bestCard[i];
		//	}
		//}
		
		if(bestIndex != -1) {
			currentCard = hand.get(bestIndex);
		}
		*/
		
		
		
		// (Should never be used in an ideal match)
		if(currentCard == null) { // If no card was chosen after 9 seconds of calculating, choose any card that gets a perfect square, else choose the top card.
			int i = 0;
			for(Card c : hand) {
				if(perfectSquare(convertToInteger(c) + onTable)) {
					// System.out.println("Perfect Square detected: " + (convertToInteger(c) + onTable) + "\t Returning card: " + c);
					hand.remove(i);
					return c;
				}
				i++;
			}
			currentCard = hand.get(0);
			hand.remove(0);
		}
		// System.out.println("Returning card: " + currentCard);
	    return currentCard;
	}
	
	public ArrayList<ArrayList<Card>> calculateAllPossibleHands(ArrayList<Card> hand, ArrayList<Card> playedCards, HashMap<String, Integer> duplicatedHandValues) {
		Deck deck = new Deck(); // Create a new Deck
		ArrayList<ArrayList<Card>> possibleOpponentHands = new ArrayList<ArrayList<Card>>(); // Stores all possible opponent Hands
		ArrayList<Card> currentPossibleOpponentHand = new ArrayList<Card>(); // The current possible opponent hand
		// Old code Card currentPossibleOpponentCard = null; // The current Card to be added to the current possible opponent hand
		ArrayList<Card> excludedCards = new ArrayList<Card>(); // Cards that are in my hand + Cards that have been played
		HashMap<String, ArrayList<Card>> uniqueOpponentHands = new HashMap<>();
		for(Card c : hand) {
			excludedCards.add(c);
		}
		for(Card c : playedCards) {
			excludedCards.add(c);
		}
		excludedCards = sort(excludedCards);
		// First thing: What is the current Opponent Hand Size? (Did Opponent Play first or did we?)
		int currentOpponentHandSize = hand.size();
		if(playedCards.size() % 2 == 0) {
			currentOpponentHandSize = hand.size(); // We played first
		} else {
			currentOpponentHandSize = hand.size() - 1; // Opponent played first
		}
		
		generateHands(deck, currentOpponentHandSize, 0, currentPossibleOpponentHand, possibleOpponentHands, excludedCards, uniqueOpponentHands, duplicatedHandValues);
		// System.out.println("Unique: " + uniqueOpponentHands.size());
		// System.out.println("Possible: " + possibleOpponentHands.size());
		// System.out.println("Duplicated Size(): " + duplicatedHandValues.size());
		// System.out.println(duplicatedHandValues.get(hashFunction(possibleOpponentHands.get(0))));
		// System.out.println("currentTime-startTime: " + (System.currentTimeMillis() - startTime));
		return possibleOpponentHands;
		
		/* Old, inefficient way to calculate cards.
		// Second thing: How many different states exist for the current opponent hand size?
		// Combinations Calculation; i.g. (33 = unplayed cards, 7 = currentOpponentHandSize) = 4,272,048 possible hands
		// (40 - hand.size() - playedCards.size() ) choose currentOpponentHandSize
		// fact(40 - hand.size() - playedCards.size()) / fact (currentOpponentHandSize ) * fact((40-hand.size() - playedCards.size()) - currentOpponentHandSize)
		// System.out.println("hand.size(): " + hand.size() + " ; playedCards.size(): " + playedCards.size());
		// System.out.println(40 - hand.size() - playedCards.size() + "!");
		
		BigInteger n2 = factorial(40 - hand.size() - playedCards.size());
		// System.out.println("n2!: " + n2);
		BigInteger r2 = factorial(currentOpponentHandSize);
		// System.out.println("r2!: " + r2);
		BigInteger n2_r2 = factorial((40-hand.size() - playedCards.size()) - currentOpponentHandSize);
		// System.out.println("n2-r2!: " + n2_r2);
		BigInteger x = r2.multiply(n2_r2);
		// System.out.println("x: " + x);
		BigInteger possibleStates = n2.divide(x);
		// System.out.println("possibleStates: " + possibleStates);
		int possibleStates2 = possibleStates.intValueExact(); // 4,272,048; 906,192; 169,911; 27,405; 3,654; 378; 27
		// System.out.println(possibleStates2);
		
		for(int possibleHands = 0; possibleHands < possibleStates2 ; possibleHands++) { // loops UNTIL no more hands exist
			// Generates a Hand, stores it into possibleOpponentHands, make sure no duplicate Hands exist in that ArrayList
			// Requirements for each hand: 
			// - Cannot have a card that has either been played, or in my hand
			// - Cannot have the same CARD twice in a hand
			// - Hand CANNOT be identical to another hand 
			//   Once a hand is created, it sorted by card.getNumber, 
			//   then we check if possibleOpponentHands.contains(currentPossibleOpponentHand)
			//   if it does, we don't add it to the ArrayList, otherwise we can finally add it.
			// 	 Improvements for the future: Add this is a hashmap; 
			//   if the hashmap already contains this hand, don't add it; Should be a faster lookup
			
			boolean alreadyAdded = false;
			for(int handSize = 0; handSize < currentOpponentHandSize; handSize++) {
				// loops currentOpponentHandSize to add those # of cards to the currentPossibleOpponentHand
				int previouslyInsertedCard = 0;
				for(previouslyInsertedCard = 0; previouslyInsertedCard < Deck.length; previouslyInsertedCard++) { 
					// Grabs a card from the deck
					// Requirements BEFORE adding this card to hand:
					// - This card does not already appear in the currentPossibleHand, my Hand, or playedCards
					// Requirements AFTER adding this card to the hand:
					// - If this hand already exists, 
					currentPossibleOpponentCard = deck.get(previouslyInsertedCard); // Grabs card J, each card has a unique value
					if(hand.contains(currentPossibleOpponentCard) || playedCards.contains(currentPossibleOpponentCard) || currentPossibleOpponentHand.contains(currentPossibleOpponentCard)) {
						// if my hand has that card, 
						// OR that card was already played,
						// OR it already exists in currentPossibleOpponentHand, skip it.
						continue; 
					}
					currentPossibleOpponentHand.add(currentPossibleOpponentCard);
					if(currentPossibleOpponentHand.size() < currentOpponentHandSize) {
						// Keep looping UNTIL we have enough cards to create a Hand
						continue;
					}
					// Sort the hand before checking if it exists in 
					currentPossibleOpponentHand = sort(currentPossibleOpponentHand);
					if(possibleOpponentHands.contains(currentPossibleOpponentHand)) {
						// if this current possible opponent Hand is already in possible opponent Hands, 
						// don't add it again, remove the current Possible Opponent Card; 
						currentPossibleOpponentHand.remove(currentPossibleOpponentHand.size());
						
						incrementCard(previouslyInsertedCard, currentPossibleOpponentHand, possibleOpponentHands);
						if(previouslyInsertedCard == Deck.length-1) { // recursion this
							// If we have incremented ALL of the last card, increment the last card - 1,
							Card previousCard = currentPossibleOpponentHand.remove(currentPossibleOpponentHand.size());
							int previousJ = convertToInteger(previousCard);
							previousJ++; 
							if(previousJ == 39) {
								// Same as above
							}
						}
					}
				}
				// Check if the currentPossibleOpponentHand is in PossibleOpponentHands already
				// Sort first, to make sure we only record distinct states
				currentPossibleOpponentHand = sort(currentPossibleOpponentHand);
				
				if(possibleOpponentHands.contains(currentPossibleOpponentHand)) {
					alreadyAdded = true;
				}
			}
			if(alreadyAdded) {
				continue;
			}
			possibleOpponentHands.add(currentPossibleOpponentHand);
		}
		// Returns the ArrayList OF all UNIQUE possible Opponent Hands
		return possibleOpponentHands;
		*/
	}
	
	public void generateHands(Deck deck, int currentOpponentHandSize, int start,  ArrayList<Card> currentPossibleOpponentHand, ArrayList<ArrayList<Card>> possibleOpponentHands, ArrayList<Card> excludedCards, HashMap<String, ArrayList<Card>> uniqueOpponentHands, HashMap<String, Integer> duplicatedHandValues) {
		if(currentPossibleOpponentHand.size() == currentOpponentHandSize) {
			// Base Case: currentPossibleOpponentHand.size() is the opponentHandSize
			// 1) Create a copy. Sort the hand coming in (by Integer Value)
			// 2) Check if this hand already exists in uniqueOpponentHand
			// 3) If not add it.
			// 4) If it does, increment the duplicatedHandValues for it's hashFunction(currentPossibleOpponentHand).
			String currentKey = hashFunction(currentPossibleOpponentHand);
			if(!uniqueOpponentHands.containsKey(currentKey)) {
				uniqueOpponentHands.put(currentKey, new ArrayList<Card>(currentPossibleOpponentHand));
				duplicatedHandValues.put(currentKey, 1);
				possibleOpponentHands.add(new ArrayList<>(currentPossibleOpponentHand));
				//System.out.println("original " + uniqueOpponentHands.size());
			} else {
				int currentDuplicatedValue = duplicatedHandValues.get(currentKey);
				duplicatedHandValues.put(currentKey, currentDuplicatedValue+1);
//				ArrayList<Card> inHash = uniqueOpponentHands.get(hashFunction(currentPossibleOpponentHand));
//				System.out.print("duplicated Cards: \ncuHand ");
//				for(Card c : currentPossibleOpponentHand) {
//					System.out.print(c + " ");
//				}
//				System.out.print(hashFunction(currentPossibleOpponentHand) + "\ninHash ");
//				for(Card c : inHash) {
//					System.out.print(c + " ");
//				}
//				System.out.println(hashFunction(inHash));
			}
			
//			if(uniqueOpponentHands.get(hashFunction(currentPossibleOpponentHand)) == null) {
//				uniqueOpponentHands.put(new ArrayList<Card>(currentPossibleOpponentHand), hashFunction(currentPossibleOpponentHand));
//				possibleOpponentHands.add(new ArrayList<Card>(currentPossibleOpponentHand));
//			} else {
//				System.out.println("Collision Detected ");
//			}
			return;
		}
		
		for(int i = start; i < Deck.length; i++) {
			Card currentPossibleOpponentCard = deck.get(i); 
			if(!excludedCards.contains(currentPossibleOpponentCard) && 
					!currentPossibleOpponentHand.contains(currentPossibleOpponentCard)) {
				currentPossibleOpponentHand.add(currentPossibleOpponentCard);
				generateHands(deck, currentOpponentHandSize, i + 1, currentPossibleOpponentHand, possibleOpponentHands, excludedCards, uniqueOpponentHands, duplicatedHandValues);
				currentPossibleOpponentHand.remove(currentPossibleOpponentHand.size() - 1);
			}
		}
	}
	
	public String hashFunction(ArrayList<Card> copyCurrentPossibleOpponentHand) {
		// Sort cards, convert cards just to Integer values, and add all to a String
		// This will allows collisions, which means we have a duplicate state
		copyCurrentPossibleOpponentHand = sortByValue(copyCurrentPossibleOpponentHand);
		String hashValue = "";
		for(int i = 0; i < copyCurrentPossibleOpponentHand.size(); i++) {
			hashValue += convertToInteger(copyCurrentPossibleOpponentHand.get(i));
		}
		// System.out.println("hashValue: " + hashValue);
		return hashValue;
	}

	/* No longer used since new efficient way of calculating cards, but left in for potential revisions
	 public Card incrementCard(int j, ArrayList<Card> currentPossibleOpponentHand, ArrayList<ArrayList<Card>> possibleOpponentHands ) {
		
		if(j == 39) {
			Card previousCard = currentPossibleOpponentHand.remove(currentPossibleOpponentHand.size());
			int previousJ = convertToInteger(previousCard);
			previousJ++; 
			incrementCard(previousJ, currentPossibleOpponentHand, possibleOpponentHands);
		} else {
			return null;
		}
		return null;
		
	}
	
	public static BigInteger factorial(int number) { // Calculates Factorial, using BigInteger, for calculating all possible opponent hands.
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    } */

	public boolean perfectSquare(int i) {
		return i == 1 || i == 4 || i == 9 || i == 16 || i == 25 || i == 36 || i == 49 || i == 64 || i == 81
			    || i == 100 || i == 121;
	}
	
	public int convertToInteger(Card c) {
		// Convert the Card to an Integer of its value
		String CardtoInteger = c.toString();
		CardtoInteger = CardtoInteger.substring(0, CardtoInteger.indexOf(" "));
		if(CardtoInteger.equalsIgnoreCase("Ace")) {
			CardtoInteger = "1";
		}
		return Integer.valueOf(CardtoInteger);
	}
	
	public ArrayList<Card> sort(ArrayList<Card> possibleHand) {
		// Bubble Sort based on Card.getNumber()
		boolean swapped;
		for(int i = 0; i < possibleHand.size(); i ++) {
			swapped = false;
			for(int j = 0; j < possibleHand.size() - i - 1; j++) {
				if(possibleHand.get(j).getNumber() > possibleHand.get(j+1).getNumber()) {
					Card temp = possibleHand.get(j);
					possibleHand.set(j, possibleHand.get(j+1));
					possibleHand.set(j+1, temp);
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
		}
		
		return possibleHand;
	}
	
	public ArrayList<Card> sortByValue(ArrayList<Card> possibleHand) {
		// Bubble Sort based on Integer Value
		boolean swapped;
		for(int i = 0; i < possibleHand.size(); i ++) {
			swapped = false;
			for(int j = 0; j < possibleHand.size() - i - 1; j++) {
				if(convertToInteger(possibleHand.get(j)) > convertToInteger(possibleHand.get(j+1))) {
					Card temp = possibleHand.get(j);
					possibleHand.set(j, possibleHand.get(j+1));
					possibleHand.set(j+1, temp);
					swapped = true;
				}
			}
			if(swapped == false) {
				break;
			}
		}
		
		return possibleHand;
	}
	
	public int h() { // Heuristic/Evaluation Function ~ Should not be needed according to Hint!
		return 0;
	}
	
	public int minimax(ArrayList<Card> hand, ArrayList<Card> opponentsHand, int numOnTable, int onTable, int score1, int score2, int currentCard1) {
		// Utility utility = new Utility(Integer.MIN_VALUE, null);
		int alpha = Integer.MIN_VALUE; // alpha starts at - Infinity
		int beta = Integer.MAX_VALUE; // beta starts at + Infinity
		int value = max(hand, opponentsHand, numOnTable, onTable, score1, score2, alpha, beta, currentCard1); // Start with my turn, with CurrentCard as my starting spot
		// System.out.println("Value: " + value.getValue());
		// System.out.println("bestCard: " + value.getCard());
		return value;
	}
	
	public int max(ArrayList<Card> hand, ArrayList<Card> opponentsHand, int numOnTable, int onTable, int score1, int score2, int alpha, int beta, int currentCard1) {
		if(isTerminal(hand, opponentsHand, numOnTable, score1, score2)) { // terminal state
			if(score1>score2) {
				return 1;
			} else if (score1<score2){
				return -1;
			} else {
				return 0;
			}
		}
		Utility maxUtility = new Utility(Integer.MIN_VALUE, null);
		int[] playedCardValues = new int[hand.size()];
		for(int i = 0; i < playedCardValues.length; i++) {
			playedCardValues[i] = -1;
		}
		int originalNumberOnTable = numOnTable;
		int originalOnTable = onTable;
		int originalScore1 = score1;
		// int originalScore2 = score2;
		if(currentCard1 != -1) {
			score1 = originalScore1;
			Card c = hand.get(currentCard1);
			ArrayList<Card> newHand = new ArrayList<Card>(hand); // Creates a new hand
			newHand.remove(currentCard1);
			
			currentCard1 = -1;
			numOnTable = originalNumberOnTable + 1; // increases the number of cards on the table
			onTable = originalOnTable + convertToInteger(c); // increases the value by the card value.
			if(perfectSquare(onTable)) { // if it is a perfect Square, clear the board, increase score.
				onTable = 0; 
				score1 = originalScore1 + numOnTable; 
				numOnTable = 0;
			}
			int miniValue = mini(newHand, opponentsHand, numOnTable, onTable, score1, score2, alpha, beta, -1);
			if(miniValue > maxUtility.getValue()) {
				maxUtility.setValue(miniValue);
				maxUtility.setCard(c);
				alpha = Math.max(alpha, maxUtility.getValue());
			}
			if(maxUtility.getValue() >= beta) {
				//System.out.println("Beta Pruning");
				return maxUtility.getValue();
			}
			return maxUtility.getValue();
		} else {
			for(Card c : hand) {
				score1 = originalScore1;
				ArrayList<Card> newHand = new ArrayList<Card>(hand); // Creates a new hand
				// check if Card c is a card (value) we already have explored
				// -1 -1 -1 -1 -1 -1 -1
				boolean uniqueCardValue = true;
				for(int i = 0; i < hand.indexOf(c); i++) {
					if(playedCardValues[i] == convertToInteger(c)) {
						// System.out.println("two duplicate cards: ");
						// System.out.println(c + " " + hand.get(i));
						uniqueCardValue = false;
						break; // break out of this loop, as we know this card has already been explored
					}
				}
				playedCardValues[hand.indexOf(c)] = convertToInteger(c);
				if(uniqueCardValue == false) {
					continue;
				}
				newHand.remove(c); // Removes the played card from hand
				numOnTable = originalNumberOnTable + 1; // increases the number of cards on the table
				onTable = originalOnTable + convertToInteger(c); // increases the value by the card value.
				if(perfectSquare(onTable)) { // if it is a perfect Square, clear the board, increase score.
					onTable = 0; 
					score1 = originalScore1 + numOnTable; 
					numOnTable = 0;
				}
				int miniValue = mini(newHand, opponentsHand, numOnTable, onTable, score1, score2, alpha, beta, -1);
				if(miniValue > maxUtility.getValue()) {
					maxUtility.setValue(miniValue);
					maxUtility.setCard(c);
					alpha = Math.max(alpha, maxUtility.getValue());
				}
				if(maxUtility.getValue() >= beta) {
					//System.out.println("Beta Pruning");
					return maxUtility.getValue();
				}
			}
			return maxUtility.getValue();
		}
	}
	
	public int mini(ArrayList<Card> hand, ArrayList<Card> opponentsHand, int numOnTable, int onTable, int score1, int score2, int alpha, int beta, int j) {
		if(isTerminal(hand, opponentsHand, numOnTable, score1, score2)) {
			if(score1 > score2) {
				return 1;
			} else if (score1 < score2) {
				return -1;
			} else {
				return 0;
			}
		}
		Utility miniUtility = new Utility(Integer.MAX_VALUE, null);
		int[] playedCardValues = new int[opponentsHand.size()];
		for(int i = 0; i < playedCardValues.length; i++) {
			playedCardValues[i] = -1;
		}
		int originalNumberOnTable = numOnTable;
		int originalOnTable = onTable;
		// int originalScore1 = score1;
		int originalScore2 = score2;
		for(Card c : opponentsHand) { 
			score2 = originalScore2;
			ArrayList<Card> newOpponentsHand = new ArrayList<Card>(opponentsHand); // Creates a opponent hand
			// check if Card c is a card (value) we already have explored
			// -1 -1 -1 -1 -1 -1 -1
			boolean uniqueCardValue = true;
			for(int i = 0; i < opponentsHand.indexOf(c); i++) {
				if(playedCardValues[i] == convertToInteger(c)) {
					// System.out.println("two duplicate cards: ");
					// System.out.println(c + " " + hand.get(i));
					uniqueCardValue = false;
					break; // break out of this loop, as we know this card has already been explored
				}
			}
			playedCardValues[opponentsHand.indexOf(c)] = convertToInteger(c);
			if(uniqueCardValue == false) {
				continue;
			}			
			newOpponentsHand.remove(c); // Removes the played card from hand
			numOnTable = originalNumberOnTable + 1; // increases the number of cards on the table
			onTable = originalOnTable + convertToInteger(c); // increases the value by the card value.
			if(perfectSquare(onTable)) { // if it is a perfect Square, clear the board, increase score.
//				if(score2 + numOnTable > 14) {
//					System.out.print("");
//				}
				score2 = originalScore2 + numOnTable;
				onTable = 0; 
				numOnTable = 0;
			} 
			
			int maxValue = max(hand, newOpponentsHand, numOnTable, onTable, score1, score2, alpha, beta, -1);
			if(maxValue < miniUtility.getValue()) {
				miniUtility.setValue(maxValue);
				miniUtility.setCard(c);
				beta = Math.min(beta, miniUtility.getValue());
			}
			if(miniUtility.getValue() <= alpha) {
				//System.out.println("Alpha pruning");
				return miniUtility.getValue();
			}
		}
		
		return miniUtility.getValue();
	}
	
	public boolean isTerminal(ArrayList<Card> hand, ArrayList<Card> opponentsHand, int numOnTable, int score1, int score2) {
		if(hand.size() == 0 || opponentsHand.size() == 0) { // if my hand or opponentsHand is empty, stop calculating
			//System.out.println("End of branch reached");
			return true;
		}
		if (Math.abs(score1-score2) > (hand.size() + opponentsHand.size() + numOnTable)) { // Someone won regardless of the rest of play
			// Example: Player 1 just picked up a score of 7
			//System.out.println("Gameplay no longer matters past here");
			return true;
		}
		return false;
	}
	
	public class Utility {
    	public int value;
    	public Card card;
    	
    	public Utility(int v, Card a) {
    		this.value = v;
    		this.card = a;
    	}
    	
    	public int getValue() {
    		return value;
    	}
    	
    	public void setValue(int value) {
    		this.value = value;
    	}
    	
    	public Card getCard() {
    		return card;
    	}
    	
    	public void setCard(Card card) {
    		this.card = card;
    	}
    }
	
    }
    
    
}
