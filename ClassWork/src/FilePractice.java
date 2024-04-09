import java.io.*;
import java.util.Scanner;

import com.sun.tools.javac.Main;

public class FilePractice {
	public static void main(String[] args) {
		// Create file variables
		PrintWriter outputStream = null;
		
		// Open the file
		try {
			outputStream = new PrintWriter(new FileWriter("myFirstFile", false));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening File");
			System.exit(0);
		} catch (IOException e) {
			System.out.println("IO ERROR");
			System.exit(0);
		}
		
		System.out.println("Writing to file");
		outputStream.println("sss");
		outputStream.println("Jdwdwdanet");
		outputStream.close();
		System.out.println();
		
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new FileInputStream("myFirstFile.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening File");
			e.printStackTrace();
			System.exit(0);
		}
		
		
		String line;
		while(inputStream.hasNextLine()) {
			line = inputStream.nextLine();
			System.out.println(line);
		}
		
		
	}
}
