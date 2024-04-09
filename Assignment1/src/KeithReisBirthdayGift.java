/* Name: Keith Reis
 * Program Name: Birthday Gift
 * Due Date: 1/26/22
 * Description: Given a list of Names, and a list of Birthday Gifts, match them together
 * Assistance: None
 */
import java.util.Scanner;
import java.util.ArrayList;

public class KeithReisBirthdayGift {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		// Created 2 array Lists because I think they are better suited for this assignment
		// names ArrayList will contain the names; gifts ArrayList will contain the gifts
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> gifts = new ArrayList<String>();
		
		// Input for the Lists; code checks if it is *END*, 
		// otherwise it adds the String to names list if it is the first iteration, 
		// or gifts list if it is the second iteration.
		for(int i = 0; i <= 1; i ++) {
			String temp = "";
			for(int j = 0; j < 100; j++) {
				temp = s.nextLine();
				if(temp.equals("*END*")) {
					break;
				}
				else if (i == 0) {
					names.add(temp);
				} else {
					gifts.add(temp);
				}
			}
		}
		
		// Sort the ArrayLists by using Selection Sort by a method to reduce repeated code
		sortLists(names);
		sortLists(gifts);
		
		// Match the Arrays (lockstep)
		// Lockstep code description: 
		// name & gift both have the first letter match? Add gift to name String ~ Remove gifts from gifts list, then advance both loops by break;
		// name comes before the gift, print name with no Gift, advance ONLY the name list. (negative compareTo)
		// name comes after the gift, advance ONLY the gift list. (positive compareTo)
		for(int i = 0; i < names.size(); i++) {
			for(int j = 0; j < gifts.size(); j++) {
				if(names.get(i).substring(0,1).compareTo(gifts.get(j).substring(0, 1)) == 0) {
					names.set(i, names.get(i) + ", " + gifts.get(j));
					gifts.remove(j);
					break;
				} else if (names.get(i).substring(0,1).compareTo(gifts.get(j).substring(0, 1)) < 0) {
					i++;
					j--;
				} else {
					continue;
				}
			}
		}
		
			
		//Outputs the both ArrayList contents
		for(String a : names) {
				System.out.println(a);
		}
		System.out.println("*END*");
		for(String a : gifts) {
			System.out.println(a);
		}
		
		// Closes the Scanner.
		s.close();
	}
	
	// Selection Sort Method ~ basically same in as taught in class, except modified for Strings, and Lists. (CODE FROM CLASS)
	public static void sortLists(ArrayList<String> list) {
		for(int i = 0; i < list.size()-1; i++) {
			int minPosition = i;
			for(int j = i+1; j < list.size(); j++) {
				if(list.get(j).compareTo(list.get(minPosition)) < 0) {
					minPosition = j;
				}
			}
			String temp = list.get(i);
			list.set(i, list.get(minPosition));
			list.set(minPosition, temp);
		}
	}
}
