
public class Week13PL21050 {
	
	public static boolean method(int[][] a2d) {
		boolean isSquare = true;
		for(int i = 0; i < a2d.length-1; i++) {
			if(a2d[i].length != a2d[i+1].length || a2d.length != a2d[i].length) {
				isSquare = false;
			}
		}
		if(0 == a2d.length-1) {
			isSquare = a2d[0].length == 1;
		}
		return isSquare;
	}
	
	public static void main (String[] args) {
		int[][] test = {{1, 2, 3}};
		System.out.println(method(test));
	}
}
