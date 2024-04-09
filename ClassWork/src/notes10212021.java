
public class notes10212021 {
	public static void main (String[] args) {
		
		String temp;
		String[] x = {"gg", "ss", "aa", "bb", "ww", "dd"};
		for (String item : x) {
			System.out.println(item);
		}
		// Bubble Sort
		// Outer loop (0 through the second to last element)
		for(int i = 0; i < x.length-1; i++) {
			// Inner loop ( i+i through the last element) 
			for (int j = i+1; j<x.length; j++) {
				if(x[j].compareTo(x[i]) < 0) {
					temp = x[i];
					x[i] = x[j];
					x[j] = temp;
				}
			}
		}
		System.out.println();
		for (String item : x) {
			System.out.println(item);
		}
		
	}
	
}
