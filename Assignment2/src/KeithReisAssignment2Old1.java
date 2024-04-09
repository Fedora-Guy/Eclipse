import java.util.Random;

public class KeithReisAssignment2Old1 {
	public static void main(String[] args) {
		int attempts = 0;
		int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0;
		while(attempts != 1000) {
		// Creates Array and populates it from 1 to 10 inclusive
		int[] integers = new int[10];
		for(int i = 0; i < 10; i++) {
			integers[i] = i+1;
		}
		
		// Randomizes array list 
		Random random = new Random();
		for(int i = 0; i<integers.length; i++) {
			int j = random.nextInt(i+1);
			int t = integers[i]; integers[i] = integers[j]; integers[j] = t;
		}
		
//		for(int i : integers) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		//Puts the first four integers into a new array
		int[] fourNumbers = new int[4];
		for(int i = 0; i < 4; i++) {
			fourNumbers[i] = integers[i];
		}
		
//		//Testing
//		for(int i : fourNumbers) {
//			System.out.print(i + " ");
//		}
		switch(fourNumbers[0]) {
		case 1:
			one++;
			break;
		case 2:
			two++;
			break;
		case 3:
			three++;
			break;
		case 4:
			four++;
			break;
		case 5:
			five++;
			break;
		case 6:
			six++;
			break;
		case 7:
			seven++;
			break;
		case 8:
			eight++;
			break;
		case 9:
			nine++;
			break;
		case 10:
			ten++;
			break;
		default:
			break;
		}
		
		attempts++;
		}
		System.out.println("1: " + one);
		System.out.println("2: " + two);
		System.out.println("3: " + three);
		System.out.println("4: " + four);
		System.out.println("5: " + five);
		System.out.println("6: " + six);
		System.out.println("7: " + seven);
		System.out.println("8: " + eight);
		System.out.println("9: " + nine);
		System.out.println("10: " + ten);
	}
}
