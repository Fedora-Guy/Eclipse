import java.util.Random;
import java.util.Scanner;
// Create a BogoSort, count the comparisons it does.

public class BogoSort {
	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.println("How many items in array?"); 
		int length = scan.nextInt();
		int[] array = new int[length];
		for(int i = 1; i <= length; i++) {
			array[i-1] = i;
		}
		BogoSort bs = new BogoSort();
		array = bs.randomize(array);
		for(int i : array) {
			System.out.print(i + " ");
		}
	}
	
	public int[] randomize(int[] array) {
		Random random = new Random();
		int[] newArray = new int[array.length];
		int[] swapIntegers = new int[array.length];
		boolean invalidSwap = false;
		for(int i = 0 ; i < array.length; i++) {
			int swap = random.nextInt(10);
			for(int j = 0 ; j < array.length; j++) {
				if(swapIntegers[j] == swap) {
					invalidSwap = true;
					break;
				}
				invalidSwap = false;
			}
			if(invalidSwap == true) {
				continue;
			}
			swapIntegers[swap] = swap;
			
			
		}
		return newArray;
	}
}	
