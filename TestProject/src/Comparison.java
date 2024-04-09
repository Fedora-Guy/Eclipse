import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Comparison {
	public static void main (String[] args) {
		int[][] a3 = new int[3][];
		
		for(int i = 0; i < a3.length; i ++) {
			a3[i] = new int[i+1];
			for(int j = 0; j < a3[i].length; j++) {
				a3[i][j] = i;
			}
		}
		
		for(int i = 0; i < a3.length; i ++) {
			for(int j = 0; j < a3[i].length; j++) {
				System.out.println(a3[i][j]);
			}
		}
		
		/*
		int lowestNumber = 0;
		int highestNumber = 0;
		int currentNumber = 0;
		Scanner s = new Scanner(System.in);
		String fileName = "";
		System.out.print("Enter file name:");
		fileName = s.nextLine();
		
		File newFile = new File(fileName);
		Scanner f1 = null;
		try {
			f1 = new Scanner(newFile);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE NOT FOUND");
			System.out.println("FILE NAME IS " + fileName);
			System.exit(0);
		} 
		
		
		while(f1.hasNext()) {
			currentNumber = 0;
			currentNumber = f1.nextInt();
			if(currentNumber > highestNumber) {
				highestNumber = currentNumber;
			}
			if(currentNumber < lowestNumber) {
				lowestNumber = currentNumber;
			}
			
		}
		
		System.out.println("Min: " + lowestNumber);
		System.out.println("Max: " + highestNumber);
		f1.close();
		s.close();
		*/
	}
}