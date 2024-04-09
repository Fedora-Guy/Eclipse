
public class MagicSquare {

	public static void main(String[] args) {
		
		int i = 5;
		int j = 1;
		int[] a = {10, 12, 13, 14, 15, 16};
		
		
		for(int e : a) {
			System.out.print(e + " ");
		}
		System.out.println();
		swap(a, i, j);
		for(int e : a) {
			System.out.print(e + " ");
		}
		
		System.out.println();
		swap(a, i, j);
		for(int e : a) {
			System.out.print(e + " ");
		}
		
		/*
		 * 10 12 13 14 15 16 
10 16 13 14 15 12 
		 * 10 12 13 14 15 16 
10 16 13 14 15 12 
		 */
	}
	
	public static void fun(int x, int y, int z) {
		
		System.out.println(x + " " + y + " " + z);
	}
	
	private static void swap(int[] a, int i, int j) {
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
		}

}
