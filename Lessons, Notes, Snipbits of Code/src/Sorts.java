
public class Sorts {
	public static void main(String[] args) {
		
		int[] grades = {10, 15, 3, 15};
		int num = grades.length;
		/* Selection Sort ~ More Efficient than Bubble
		for(int j = 0; j< num; j++) {
			int minpos = j;
			for(int i = minpos+1; i< num; i++) {
				if(grades[i] < grades[minpos]) {
					minpos = i;
				}
				swap(grades, j, minpos);
			}
		}
		*/
		
		
		/* Bubble Sort ~ NOT EFFICIENT
		for(int i = 0; i < num-1; i++) {
			for(int j = 0; j<num-1-i; j++) {
				if(grades[j] > grades[j+1])
					swap(grades, j, j+1);
			}
		}
		*/
		
		/* Bubble Sort Advanced ~ Still not good enough
		 * for(int i = 0; i < num-1; i++) {
		 * boolean swapped = false;
		 * 	for(int j = 0; j<num-1-i; j++) {
		 * 		if(grades[j] > grades[j+1]) {
		 * 			swapped = true;
		 * 			swap(grades, j, j+1);
		 * 		}
		 * 	}
		 * }
		 */
		
		/* Insertion Sort - 1 card
		 * t = card; i = 
		 * while(i > 0 && a[i-1] > t) {
		 * 	a[i] = a[i-1];
		 * 	i--;
		 * }
		 * a[i] = t;
		*/
		
		/* Insertion Sort - More than 1 'Card'
		for(int j = 1; j<num; j++) {
			int t = a[j], i = j;
			while(i > 0 && a[i-1] > t) {
				a[i] = a[i-1];
				i--;
			}
			a[i] = t;
		}
		*/
		
		// Elementary Sorts
		// Selection Sort is useful when the cost of swapping two elements is high
		// NEVER USE BUBBLE SORT.
		// Insertion Sort is useful when the array to be sorted is nearly in order
	}

	/*public static void swap(int[] grades, int j, int minpos) {
		int temp = grades[j]; grades[j] = grades[minpos]; grades[minpos] = temp;
	}*/
	
	
}
