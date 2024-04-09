
public class StringsPracticeDriver {
	public static void main(String[] args) {
		StringsPractice test = new StringsPractice();
		
		System.out.println(test.beginToEnd("Hello"));
		System.out.println(test.beginToEnd("it"));
		System.out.println(test.beginToEnd(""));
		
		System.out.println(test.endToBegin("Computer"));
		System.out.println(test.endToBegin("it"));
		
		int[] addArray1 = {1, 2, 3, 4};
		int[] subtractArray1 = {10, 2, 6, 9};
		
		int[] addArray2 = {5, 20};
		int[] subtractArray2 = {-4};
		
		System.out.println(test.addSubtractArray(addArray1, subtractArray1));
		System.out.println(test.addSubtractArray(addArray2, subtractArray2));
	}
}
