import java.util.Scanner;

public class Concord {
	
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		Tree<String, Integer> db = new Tree<>();
		int numCities = 0;
		String regex = "(?:(?<!\\S)\\p{Punct}+)|(?:\\p{Punct}+(?!\\S))";
		while(sc.hasNext()) {
			String word = sc.next().replaceAll(regex, "");
			Integer number = db.find(word);
			if(number == null) {
				db.add(word, number = numCities++);
			}
		}
		System.out.println("Number = " + numCities);
		System.out.println(db);
		System.out.println(db.print());
		System.out.println(db.height());
	}
}
