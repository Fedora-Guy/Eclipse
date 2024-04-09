import java.util.Scanner;

public class Distinct {
	public static void main (String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int numOfElements = 0;
		
		System.out.print("Enter number of elements:");
		numOfElements = s.nextInt();
		s.nextLine();
		
		int[] array = new int[numOfElements];
		for(int i = 0; i < array.length; i++) {
			System.out.print("Enter next element:");
			array[i] = s.nextInt();
			s.nextLine();
		}
		s.close();
		for(int j = 0; j < array.length-1; j++) {
			for(int k = 0; k < array.length-j-1; k++) {
				
				if(array[k] < array[k+1]) {
					
					int temp = array[k];
					array[k] = array[k+1];
					array[k+1] = temp;
					
				}
				
			}
		}
		
		System.out.println("N\tCount");
		
		int variableCount = 0;
		boolean stop = false;
		for(int j = 0; j < array.length; j += variableCount) {
			variableCount = 1;
			stop = false;
			for(int k = j; k < array.length-1; k++) {
				if(array[k] == array[k+1] && stop == false) {
					
					variableCount++;
				} else {
					stop = true;
				}
			}
			
			System.out.println(array[j] + "\t" + variableCount);
		}
	}
}