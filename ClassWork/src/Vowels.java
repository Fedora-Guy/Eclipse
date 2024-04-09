import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Vowels {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String fileName = "words.txt";
		String longestString = "";
		String currentString = "";
		String tempString = "";
		String currentCharacter = "";
		String previousCharacter = "";
		int longestVowels = 0;
		int currentVowels = 0;
		int length = 0;
		
		
		
		Scanner fileIn = null;
		try{
			fileIn = new Scanner( new FileInputStream(fileName));
		}
		catch(FileNotFoundException e) 
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		
		while(fileIn.hasNextLine()) {
			currentString = fileIn.nextLine();
			tempString = currentString;
			currentVowels = 0;
			length = currentString.length();
			for(int i = 1; i < length; i ++) {
				currentCharacter = currentString.substring(i, i+1);
				previousCharacter = currentString.substring(i-1, i);
				if ((currentCharacter.equals("a") || currentCharacter.equals("e") || currentCharacter.equals("i") ||  currentCharacter.equals("o") || currentCharacter.equals("u")) && (previousCharacter.equals("a") || previousCharacter.equals("e") || previousCharacter.equals("i")|| previousCharacter.equals("o") || previousCharacter.equals("u"))) {
					currentVowels++;
				}
			}
			if(currentVowels > longestVowels) {
				longestString = tempString;
				longestVowels = currentVowels;
				currentVowels = 0;
			}
			
		}
		
		System.out.print(longestString + "has " + longestVowels + " consecutive vowels.");
	}
}