
public class SelectionSort {
	public static void main (String[] args) {
		String[] x = {"gg", "ss", "aa", "bb", "ww", "dd" };
		System.out.println("Original Array");
		for (String item : x) {
			System.out.println(item);
		}
		System.out.println("");
		
		//Selection Sort
		// Loop through all of the elements (Where we are starting)
		for (int start = 0; start < x.length; start++) {
			// look for the smllest element from start toe end of array
			int smallest = start;
			for(int checkIndex = start; checkIndex < x.length; checkIndex++) {
				if(x[checkIndex].compareTo(x[smallest]) < 0) {
					// swap them
					String temp = x[checkIndex];
					x[checkIndex] = x[smallest];
					x[smallest] = temp;
				}
			}
		}
		
		System.out.println("Sorted Array");
		for (String item : x) {
			System.out.println(item);
		}
		System.out.println("");
		
	}
}
