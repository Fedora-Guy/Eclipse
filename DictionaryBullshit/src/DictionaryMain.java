import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class DictionaryMain {

	public static void main(String[] args) {
		
		// Get currentWord from Dictionary .txt
		// 
		
		Scanner scan = null;
		try {
			File file = new File("C:\\Users\\keith\\Downloads\\words.txt");
			scan = new Scanner(file);
		} catch(IOException e) {
			System.out.println("File: " + new File("C:\\Users\\keith\\Downloads\\words.txt"));
			System.out.println("Scan: " + new Scanner("C:\\Users\\keith\\Downloads\\words.txt"));
		}
		
		
		System.out.println();
		
		int i = 0;
		List<String> dictionaryOfLo = new ArrayList<>();
		String temp = "";
		while(scan.hasNextLine()) {
			temp = scan.nextLine();
			if(temp.contains("lo")) {
				dictionaryOfLo.add(temp);
				System.out.println(dictionaryOfLo.get(i));
				i++;
			}
		}
		System.out.println(i);
		scan.close();
	}

}
