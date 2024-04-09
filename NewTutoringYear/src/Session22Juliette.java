import java.util.ArrayList;
import java.util.List;

public class Session22Juliette {
	public static void main(String args[]) {
		Example<String> exampleString = new Example<String>();
		Example<Integer> exampleInteger = new Example<>();
		
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "keithID");
		
		ArrayList<String> list = new ArrayList<>(); 
		list.add("Niraj");
		list.add("Juliette");
		list.add("Heran");
		
		Pair<String, ArrayList<String>> p2 = new Pair<String, ArrayList<String>>("julietteID", list);

		System.out.println("p1 Value: " + p1.getValue());
		p1.setValue("newEmployeeID");
		System.out.println("p1 Value: " + p1.getValue());
		
		System.out.println("p2 Value: " + p2.getValue());
		list.remove(0);
		p2.setValue(list);
		System.out.println("p2 Value: " + p2.getValue());
	}
	
	
}


class Example<T> {
	
}

class Box<T> {
	private T t;
	public void set(T t) {this.t = t;}
	public T get() {return t;}
	
	public Box() {}
	public Box(T t) {this.t = t;}
}


class Pair<K, V> {
	private K key; // int // Double 
	private V value; // string // Boolean
	// Generic constructor
	public Pair() { }
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	// Generic methods
	public void setKey(K key) { this.key = key; }
	public void setValue(V value) { this.value = value; }
	public K getKey() { return key; }
	public V getValue() { return value; }
}