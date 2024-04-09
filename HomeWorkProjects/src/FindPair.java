import java.util.Scanner;
import java.io.*;

public class FindPair {
	public static void main(String[] args) {
		
		int numberA, numberB, number1, number2, number3, number4, number5, number6, number7, number8, number9, number0;
		Scanner s = new Scanner(System.in);
		boolean pair = false;
		int i = 0, j = 0;
		
		System.out.print("Enter file name:");
		String fileName = s.nextLine();
		RandomAccessFile raf = null;
		
		/*
		number1 = fileIn.nextInt();
		number2 = fileIn.nextInt();
		number3 = fileIn.nextInt();
		number4 = fileIn.nextInt();
		number5 = fileIn.nextInt();
		number6 = fileIn.nextInt();
		number7 = fileIn.nextInt();
		number8 = fileIn.nextInt();
		number9 = fileIn.nextInt();
		number0 = fileIn.nextInt();
		*/
		
		
		System.out.print("Enter number to find pair:");
		int numberPair = s.nextInt();
		
		
		
			try {
				String fileName2 = "C:\\Users\\keith\\eclipse-workspace\\HomeWorkProjects\\src/dat.txt";
			    File file = new File(fileName2);
				raf = new RandomAccessFile(file, "r");
				while(i < 10) {
					numberA = raf.readInt();
					System.out.print(i + " i");
					while(j < 10) {
						numberB = raf.readInt();
						System.out.print(" " + j + " j");
						System.out.println(": " + numberA + ", " + numberB);
						if( numberA + numberB == numberPair) {
							System.out.println("Pair Found: " + numberA + ", " + numberB);
						}
						j++;
					}
					j = 0;
					i++;
					raf.seek(0);
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		/*
		Test of Proof idea - Ignore this
			
			if(number1 + number2 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number2);
			} if(number1 + number3 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number3);
			} if(number1 + number4 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number4);
			} if(number1 + number5 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number5);
			} if(number1 + number6 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number6);
			} if(number1 + number7 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number7);
			} if(number1 + number8 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number8);
			} if(number1 + number9 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number9);
			} if(number1 + number0 == numberPair) {
				System.out.println("Pair Found: " + number1 + ", " + number0);
			} if(number2 + number3 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number3);
			} if(number2 + number4 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number4);
			} if(number2 + number5 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number5);
			} if(number2 + number6 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number6);
			} if(number2 + number7 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number7);
			} if(number2 + number8 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number8);
			} if(number2 + number9 == numberPair) {
				System.out.println("Pair Found: " + number2 + ", " + number9);
			} if(number3 + number4 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number4);
			} if(number3 + number5 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number5);
			} if(number3 + number6 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number6);
			} if(number3 + number7 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number7);
			} if(number3 + number8 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number8);
			} if(number3 + number9 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number9);
			} if(number3 + number0 == numberPair) {
				System.out.println("Pair Found: " + number3 + ", " + number0);
			} if(number4 + number5 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number5);
			} if(number4 + number6 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number6);
			} if(number4 + number7 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number7);
			} if(number4 + number8 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number8);
			} if(number4 + number9 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number9);
			} if(number4 + number0 == numberPair) {
				System.out.println("Pair Found: " + number4 + ", " + number0);
			} if(number5 + number6 == numberPair) {
				System.out.println("Pair Found: " + number5 + ", " + number6);
			} if(number5 + number7 == numberPair) {
				System.out.println("Pair Found: " + number5 + ", " + number7);
			} if(number5 + number8 == numberPair) {
				System.out.println("Pair Found: " + number5 + ", " + number8);
			} if(number5 + number9 == numberPair) {
				System.out.println("Pair Found: " + number5 + ", " + number9);
			} if(number5 + number0 == numberPair) {
				System.out.println("Pair Found: " + number5 + ", " + number0);
			} if(number6 + number7 == numberPair) {
				System.out.println("Pair Found: " + number6 + ", " + number7);
			} if(number6 + number8 == numberPair) {
				System.out.println("Pair Found: " + number6 + ", " + number8);
			} if(number6 + number9 == numberPair) {
				System.out.println("Pair Found: " + number6 + ", " + number9);
			} if(number6 + number0 == numberPair) {
				System.out.println("Pair Found: " + number6 + ", " + number0);
			} if(number7 + number8 == numberPair) {
				System.out.println("Pair Found: " + number7 + ", " + number8);
			} if(number7 + number9 == numberPair) {
				System.out.println("Pair Found: " + number7 + ", " + number9);
			} if(number7 + number0 == numberPair) {
				System.out.println("Pair Found: " + number7 + ", " + number0);
			} if(number8 + number9 == numberPair) {
				System.out.println("Pair Found: " + number8 + ", " + number9);
			} if(number8 + number0 == numberPair) {
				System.out.println("Pair Found: " + number8 + ", " + number0);
			} if(number9 + number0 == numberPair) {
				System.out.println("Pair Found: " + number9 + ", " + number0);
			}
			
			*/
			
			
		
		System.out.println("No Pair Found");
		
	}
}