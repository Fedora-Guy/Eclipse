import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Contest {
	
	static class Contestant implements Comparable<Contestant> {
		public String name;
		public Integer count;
		
		public Contestant(String name, Integer count) {
			this.name = name;
			this.count = count;
		}
		
		public String toString() {
			return "(" + name + "," + count + ")";
		}
		
		public int compareTo(Contestant b) {
			return b.count-count;
		}
	}
	
	
	public static void main(String[] agrs) {
		// Read in lines <names, scores>, total the scores for the contestants,
		// print out top 10 votes getters.
		TreeMap<String, Integer> db = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String name = sc.next();
			Integer vote = sc.nextInt();
			Integer count = db.get(name);
			if(count == null) {
				count = 0;
			}
			db.put(name, count+vote);
		}
//		ArrayList<Contestant> list = new ArrayList<>();
		PriorityQueue<Contestant> pq = new PriorityQueue<>();
		for(Map.Entry<String, Integer> entry : db.entrySet()) {
			Contestant c = new Contestant(entry.getKey(), entry.getValue());
			pq.add(c);
		}
		
//		PriorityQueue<Contestant> pq = new PriorityQueue<>(list);
		for(int i = 0; i < 10; i++) {
			System.out.println(pq.poll());
		}
		
		sc.close();
	}
}
