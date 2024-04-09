
public class week12programmingwithArrays20766 {
	
	
	public int[] merge(int[] x, int[] y) {
		int[] newArray = new int[(x.length + y.length)];
		int xIndex = 0;
		int yIndex = 0;
		int i = 0;
		while(newArray.length > i) {
			
			if(xIndex < x.length && yIndex < y.length) {
				if(x[xIndex] == y[yIndex]) {
					newArray[i] = x[xIndex];
					i++;
					newArray[i] = y[yIndex];
					xIndex++;
					yIndex++;
				} else if (x[xIndex] < y[yIndex]) {
					newArray[i] = x[xIndex];
					xIndex++;
				} else {
					newArray[i] = y[yIndex];
					yIndex++;
				}
			} else if (xIndex >= x.length) {
				newArray[i] = y[yIndex];
				yIndex++;
			} else if (yIndex >= y.length) {
				newArray[i] = x[xIndex];
				xIndex++;
			}
			i++;
		}
		
		return newArray;
	}
	
	
	public static void main(String[] args) {
		week12programmingwithArrays20766 program = new week12programmingwithArrays20766();
		int[] x = {1, 2, 3};
		int[] y = {4, 5, 6};
		int[] newArray = program.merge(x, y);
		System.out.print("{ ");
		for(int i = 0; i < newArray.length; i++) {
			System.out.print(newArray[i] + ", ");
		}
		System.out.print(" }");
	}
}
