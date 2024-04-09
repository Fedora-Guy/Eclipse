
public class KeithReisHW9 {
	public static void main(String[] args) {
		Runner[] runners = new Runner[10];
		runners[0] = new Runner("Adam", 12);
		runners[1] = new Runner("Bucky", 16);
		runners[2] = new Runner("Charlie", 18);
		runners[3] = new Runner("Devin", 20);
		runners[4] = new Runner("Ezra", 3);
		runners[5] = new Runner("Fredrick", 5);
		runners[6] = new Runner("Gregory", 7);
		runners[7] = new Runner("Hamlet", 9);
		runners[8] = new Runner("Islet", 10);
		runners[9] = new Runner("Jamie", -2); // He ran backwards
		
		for(int i = 0; i < runners.length; i++) {
			System.out.println(runners[i]);
		}
		int totalDistance = 0;
		for(int i = 0; i < runners.length; i++) {
			totalDistance += runners[i].getRunDistance();
		}
		System.out.println("Together, all ten runners ran a distance of " + totalDistance);
	}
}
