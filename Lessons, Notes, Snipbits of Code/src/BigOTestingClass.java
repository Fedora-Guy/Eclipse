import java.util.ArrayList;

public class BigOTestingClass {
	public static void main(String[] args) {
		int n = 100;
		int operations = 0;
		int operations2 = 0;
		
		ArrayList<Integer> a = new ArrayList<>();
		 for(int i = 0; i < n; i++) {
			 a.add(i);
			 operations++;
		 }

			 
		
		System.out.println();
		System.out.println("O: " + operations);
		System.out.println("O2: " + operations2);
	}
	
	
	
}
