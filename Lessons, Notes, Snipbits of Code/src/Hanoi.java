
public class Hanoi {
	public static void hanoi(int n, char start, char dest, char spare) {
		// move n disks from start to dest, using spare as spare peg.
		if(n > 0) {
			hanoi(n-1, start, spare, dest);
			System.out.println("Move one disk from " + start + " to " + dest);
			hanoi(n-1, spare, dest, start);
		}
	}
		
		public static void main(String[] agrs) {
			hanoi(64, 'A', 'C', 'B');
		}
		
}
