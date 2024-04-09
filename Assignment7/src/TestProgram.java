
public class TestProgram {
	public static void main(String[] args) {
		TwoKeyHash<String, Integer, Integer> db = new TwoKeyHash<>();
		db.insert("Sam", 1, 2);
		db.insert("Joe", 2, 3);
		db.insert("Sam", 1, 2);
		db.insert("Wilma", 3, 5);
		db.insert("Bob", 4, 7);
		System.out.println(db.search1("Wilma"));
		System.out.println(db.search2(4));
		System.out.println(db.list1());
		System.out.println(db.list2());
		db.modify1("Sam", 11);
		db.modify1("Joe", 13);
		db.modify2(1, 17);
		db.change1("Bob", 2);
		db.change2(3, "Pebbles");
		System.out.println(db.list1());
		System.out.println(db.list2());
	}
}
