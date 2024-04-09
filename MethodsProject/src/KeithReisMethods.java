public class KeithReisMethods {
	
	public int minOf3(int a, int b, int c) {
		
		if(a <= b && a <= c) // if a is less than or equal to b and c
			return a;
		else if (b <= a && b <= c) // if b is less than or equal to a and c
			return b;
		else // else it returns c
			return c;
		
	}
	
	public boolean lollipopParty(int lollipops, boolean isNight) {
		
		if(isNight == false) { // if it is NOT night
			if(lollipops >= 22 && lollipops <= 66) { // if lollipops is between 22 and 66 inclusive
				return true;
			} else { // if it is outside of that range
				return false;
			}
		} else { // if it is night
			if(lollipops < 77) { // if lollipops is less than 77 {including negative values}
				return true;
			} else { // if lollipops is greater than or equal to 77
				return false;
			}
		}
		
	}
	
	public int countDuplicates(String[] letters, int n) {
		
		if(n >= letters.length) { // if n is greater than the array's length
			return 0;
		}
		
		String searchingFor = letters[n]; 
		int duplicates = 0; 
		
		for(int i = 0; i < letters.length; i++) {
			if(letters[i].equals(searchingFor)) { // if the array value equals the letter we are searching for
				duplicates++;
			}
		}
		
		return duplicates;
		
	}
	
	public String connectStrings(String str1, String str2) {
		
		String displayString = "";
		int length1 = str1.length();
		int length2 = str2.length();
		boolean even1 = ((length1 % 2 == 0) ? true : false);
		boolean even2 = ((length2 % 2 == 0) ? true : false);
		
		
		if(even1 != even2) { // If one is odd, and the other is even
			if(even1 == false) { // if str1 is the string that is odd
				displayString = str2.substring(0, length2/2) + str1.substring(0) + str2.substring(length2/2);
			} else { // if str2 is the string that is odd
				displayString = str1.substring(0, length1/2) + str2.substring(0) + str1.substring(length1/2);
			}
		} else if(even1 == false) { // if both are odd
			displayString = str1.substring(0,1) + str2.substring(length2-1);
		} else { // if both are even
			displayString = str1.substring(0, length1/2) + str2.substring(length2/2);
		}
		
		return displayString;
		
	}
	
	public boolean equallyApart(int a, int b, int c) {
		
		if(Math.abs(a-b) == Math.abs(a-c)) { // if a-b == a-c
			return true;
		} else if (Math.abs(b-a) == Math.abs(b-c)) { // if b-a == b-c
			return true;
		} else if (Math.abs(c-a) ==  Math.abs(c-b)) { // c-a == c-b
			return true;
		} else { // if none of the above is true
			return false;
		}
		
	}
	
	public String grumpyHost(int yourClothes, int dateClothes) {
		
		String displayString = "";
		if(yourClothes <= 2 || dateClothes <= 2) { // if you or your date's style (or both) is below or equal to 2
			displayString = "no";
		} else if (yourClothes >= 8 || dateClothes >= 8) { // if you or your date's style (or both) is above or equal to 8
			displayString = "yes";
		} else { // if neither of the above
			displayString = "maybe";
		}
		return displayString;
		
	}
	
	public int sumFactors(int n) {
		
		int total = 0;
		for(int i = n; i > 0; i--) {
			if(n % i == 0) { // if the parameter is evenly divided by iterator value
				total += i; // adds iterator value to the total sum
			}
		}
		return total;
		
	}
	
	public String[] comingUp(String[] battingOrder, int leadOffPosition) {
		
		String[] upComing = new String[3]; // new String array for the order
		leadOffPosition -= 1; // So we understand it in Java Math.
		for(int i = 0; i < 3; i++) {
			upComing[i] = battingOrder[leadOffPosition]; // sets the upcoming position to the batting order
			leadOffPosition++;  // increases position
			if(leadOffPosition == 9) { // if position equals 9, resets it to 0
				leadOffPosition = 0;
			}
		}
		return upComing;
		
	}
	
	public String excitedString(String str) {
		if(str.contains("!!!")) { // If the str contains a '!!!'
			if(str.lastIndexOf("!!!") == str.length()-3) // if the string already ends in "!!!"
				return str;
			else // example: Go!!!AL should still add '!!!' at the end, because '!!!' is not at the end of the String
				return str + "!!!"; 
		}
		return str + "!!!";
	}
	
	public String evilE(String str) {
		String newStr = "";
		if(!str.contains("E")) { //If the string doesn't contain a capital E
			return str;
		} else { // If the string does contain a capital E
			int spot = str.indexOf("E"); // integer where the first instance of a capital E in the String
			if(str.length() == 1) { // If the input String only contains 1 character, returns itself
				return str;
			}
			
			if (spot == 0) { // If the location of 'E' is in spot 0
				newStr = "E";
			} else if (spot == 1) { // If the location of 'E' is in spot 1
				if(str.substring(spot-1, spot).equals("e")) { // if the letter before the first capital E is a lower-case e 
					newStr = "eE";
				} else { // otherwise 
					newStr = " E";
				}
			} else { // If the location of 'E' is in neither spot 0 or spot 1
				if(str.substring(spot-1, spot).equals("e")) { // if the letter before the first capital E is a lower-case e
					newStr = str.substring(0, spot-1) + "eE";
				} else { // otherwise 
					newStr = str.substring(0, spot-1) + " E";
				}
			} 
			
			if(spot != str.length()-1) {
				if(str.substring(spot+1, spot+2).equals("e")) { // If the location after the first capital E is an lower-case e
					newStr += "e";
				} else if (str.substring(spot+1, spot+2).equals("E")) {// If the location after the first capital E is an capital E
					newStr += "E";
				} else { // otherwise
					newStr += " ";
				}
				
				newStr += str.substring(spot+2); // Adds the remaining string
			}
			
			
		}
		return newStr;
	}
	
	public boolean avoidWashingDishes(double amount, MenuItem[] order) {
		double total = 0.00; // new variable for total
		for(int i = 0; i < order.length; i++) {
			total += order[i].getItemCost(); // iterates through, adding the cost of each item to total
		}
		if(total > amount) { // if total is greater than the amount you have
			return false; // return false
		} else { // otherwise
			return true; // return true
		}
	}
	
	public String[] parseString(String str) {
		String noun = "";
		String adjective = "";
		String[] sentence = new String[2];
		
		noun = str.substring(str.indexOf(" ")+1, str.indexOf(" ", str.indexOf(" ")+1));
		// Finds the first index of " "+1, then next index of " " [Starting after the first index of " "] 
		adjective = str.substring(str.lastIndexOf(" ")+1);
		// Finds the last index of " "+1, then substrings the last of the sentence
		sentence[0] = noun;
		sentence[1] = adjective;
		
		return sentence;
	}
	
}
