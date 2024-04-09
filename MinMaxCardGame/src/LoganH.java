import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoganH {
    public static Player getPlayer() {
        return new HoffnerPlayer();
    }

    private static class HoffnerPlayer implements Player {
        public Card playCard(ArrayList<Card> hand, ArrayList<Card> playedCards, int numOnTable, int valOnTable, int score1, int score2) {
            if (hand.size() == 1)
                return hand.get(0);

            //Run several trial rounds to find the card that wins the most games
            Map<Card, Integer> suggestedCards = new HashMap<Card, Integer>();
            ArrayList<ArrayList<Card>> checked = new ArrayList<ArrayList<Card>>();
            //Loop condition adapted from https://stackoverflow.com/questions/2550536/java-loop-for-a-certain-duration
            double duration = 9.0;
            long stop = System.nanoTime() + TimeUnit.MILLISECONDS.toNanos((long)(duration*1000));
            while (stop > System.nanoTime()) {
                //Create randomized hand to represent the opponent's hand
                Deck d = new Deck();
                d.shuffle();
                ArrayList<Card> oppHand = new ArrayList<>();
                int oppHandSize = (playedCards.size()%2 == 0) ? hand.size() : (hand.size()-1);
                for (int i = 0,deckIndex = 0; i < oppHandSize; i++) {
                    oppHand.add(d.get(deckIndex++));
                    while (hand.contains(oppHand.get(i)) || playedCards.contains(oppHand.get(i))) {
                        oppHand.set(i, d.get(deckIndex++));
                    }
                }

                sortHand(oppHand);

                if (checked.size() > 0 && checked.contains(oppHand))
                    continue;
                
                checked.add(oppHand);

                // System.out.println("max");
                // for (Card c : hand) {
                //     System.out.println(c);
                // }

                // System.out.println("min");
                // for (Card c : oppHand) {
                //     System.out.println(c);
                // }

                //Use our hand and the randomized hand to start the minimax algorithm and place the result into a hashmap with the number of times the card is suggested
                Card key = maxValue(hand, oppHand, valOnTable, numOnTable, null).getValue();
                suggestedCards.put(key, (suggestedCards.containsKey(key)) ? suggestedCards.get(key) + 1 : 1);
            }

            // System.out.println("\nSuccessful Loops: " + suggestedCards.size());

            //Find the card that is considered the best in most scenarios
            //Code adapted from https://www.geeksforgeeks.org/frequent-element-array/
            // for (Card c : suggestedCards) {
            //     //System.out.print("i");
            //     Card key = c;
            //     if (hp.containsKey(key))
            //         hp.put(key, hp.get(key) + 1);
            //     else
            //         hp.put(key, 1);
            // }

            Card retVal = null;
            int maxCount = 0;

            // System.out.println("suggestedCards");
            for (Map.Entry<Card, Integer> val : suggestedCards.entrySet()) {
                // System.out.println(val.getKey() + " " + val.getValue());
                if (maxCount < val.getValue()) {
                    retVal = val.getKey();
                    maxCount = val.getValue();
                }
            }

            // for (int i = 0; i < suggestedCards.size(); i++) {
            //     System.out.print("i");
            //     int count = 0;
            //     for (int j = 0; j < suggestedCards.size(); j++) {
            //         if (suggestedCards.get(i).equals(suggestedCards.get(j)))
            //             count++;
            //     }

            //     if (count > maxCount) {
            //         maxCount = count;
            //         retVal = suggestedCards.get(i);
            //     }
            // }

            // System.out.println(retVal.getKey() + " " + retVal.getValue());

            return retVal;
        }

        private Pair<Integer, Card> maxValue(ArrayList<Card> maxHand, ArrayList<Card> minHand, int valOnTable, int numOnTable, Integer limit) {
            //If the hand is empty when this method is called, no cards can be played or collected
            if (maxHand.isEmpty())
                return new Pair<Integer, Card>(0, null);

            //Pair representing the utility, card pair
            Pair<Integer, Card> v = new Pair<>(null, null);

            //Array of card values to reduce repeated exploration
            ArrayList<Integer> vals = new ArrayList<>();

            //Loop through each card to find the card with the best result
            for (Card c : maxHand) {
                //If a card with the same value as the current card has already been explored, skip this loop
                if (vals.contains((c.value.ordinal() + 2) % 13))
                    continue;
                else
                    vals.add((c.value.ordinal() + 2) % 13);

                // System.out.println("MAX");
                // System.out.println("Play:" + c + ((c.value.ordinal() + 2) % 13));

                //Create a copy of the player's hand without the current card
                ArrayList<Card> handCopy = new ArrayList<Card>();
                for (Card c2 : maxHand) {
                    if (!c2.equals(c))
                        handCopy.add(c2);
                }

                // for (Card c2 : handCopy) {
                //     System.out.println(c2);
                // }

                //Call the minValue method and get the worst case scenario if the current card is played.
                Pair<Integer, Card> v2;
                if (Tournament.isSquare(valOnTable + ((c.value.ordinal() + 2) % 13))) {
                    v2 = minValue(handCopy, minHand, 0, 0, v.getKey());
                    //If the returned value is worse than the parent's current best, stop searching
                    if (limit != null && v2.getKey().intValue() > limit.intValue())
                        return v2;
                    v2.setKey(v2.getKey() + numOnTable + 1);
                    v2.setValue(c);
                }
                else {
                    v2 = minValue(handCopy, minHand, valOnTable + ((c.value.ordinal() + 2) % 13), numOnTable++, v.getKey());
                    //If the returned value is worse than the parent's current best, stop searching
                    if (limit != null && v2.getKey().intValue() < limit.intValue())
                        return v2;
                    v2.setValue(c);
                }
                
                //If this worst case scenario is better than the move stored in v, replace v with minValue result.
                if ((v.getKey() == null) || (v2.getKey().intValue() > v.getKey().intValue()))
                    v = v2;
            }

            // System.out.println(v.getKey() + " " + v.getValue());

            return v;
        }

        private Pair<Integer, Card> minValue(ArrayList<Card> maxHand, ArrayList<Card> minHand, int valOnTable, int numOnTable, Integer limit) {
            //If the hand is empty when this method is called, no cards can be played or collected
            if (minHand.isEmpty())
                return new Pair<Integer, Card>(0, null);

            //Pair representing the utility, card pair
            Pair<Integer, Card> v = new Pair<>(null, null);

            //Array of card values to reduce repeated exploration
            ArrayList<Integer> vals = new ArrayList<>();

            //Loop through each card to find the card with the best result
            for (Card c : minHand) {
                //If a card with the same value as the current card has already been explored, skip this loop
                if (vals.contains((c.value.ordinal() + 2) % 13))
                    continue;
                else
                    vals.add((c.value.ordinal() + 2) % 13);

                // System.out.println("MIN");
                // System.out.println("Play:" + c + ((c.value.ordinal() + 2) % 13));

                //Create a copy of the player's hand without the current card
                ArrayList<Card> handCopy = new ArrayList<Card>();
                for (Card c2 : minHand) {
                    if (!c2.equals(c))
                        handCopy.add(c2);
                }

                // for (Card c2 : handCopy) {
                //     System.out.println(c2);
                // }

                //Call the minValue method and get the worst case scenario if the current card is played.
                Pair<Integer, Card> v2;
                if (Tournament.isSquare(valOnTable + ((c.value.ordinal() + 2) % 13))) {
                    v2 = maxValue(maxHand, handCopy, 0, 0, v.getKey());
                    //If the returned value is worse than the parent's current best, stop searching
                    if (limit != null && v2.getKey().intValue() < limit.intValue())
                        return v2;
                    v2.setKey(v2.getKey() - numOnTable - 1);
                    v2.setValue(c);
                }
                else {
                    v2 = maxValue(maxHand, handCopy, valOnTable + ((c.value.ordinal() + 2) % 13), numOnTable++, v.getKey());
                    //If the returned value is worse than the parent's current best, stop searching
                    if (limit != null && v2.getKey().intValue() < limit.intValue())
                        return v2;
                    v2.setValue(c);
                }

                //If this worst case scenario is better than the move stored in v, replace v with minValue result.
                if ((v.getKey() == null) || (v2.getKey().intValue() < v.getKey().intValue()))
                    v = v2;
            }

            // System.out.println(v.getKey() + " " + v.getValue());

            return v;
        }
    
        private void sortHand(ArrayList<Card> hand) {
            for (int i = 0; i < hand.size() - 1; i++) {
                boolean swapped = false;
                for (int j = 0; j < hand.size() - i - 1; j++) {
                    if (((hand.get(j).value.ordinal() + 2) % 13) > ((hand.get(j + 1).value.ordinal() + 2) % 13)) {
                        Card temp = hand.get(j);
                        hand.set(j, hand.get(j + 1));
                        hand.set(j+1, temp);
                        swapped = true;
                    }
                }
                if (swapped == false)
                    break;
            }
        }
    }

    private static class Pair<T1, T2> {
        private T1 key;
        private T2 value;
        public Pair(T1 argKey, T2 argValue) {
            key = argKey;
            value = argValue;
        }
        public T1 getKey() {
            return key;
        }
        public void setKey(T1 i) {
            key = i;
        }
        public T2 getValue() {
            return value;
        }
        public void setValue(T2 i) {
            value = i;
        }
    }
}