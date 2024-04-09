import java.util.Set;
import java.util.TreeMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class TwoKeyOld<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	 
	private TreeMap<K1, D> tree1;
	private TreeMap<K2, D> tree2;
	
	public TwoKeyOld() {
		tree1 = new TreeMap<>();
		tree2 = new TreeMap<>();
	}
	
	void insert(K1 key1, K2 key2, D data) {
		
		
		Set<K1> s1 = tree1.keySet();
		Set<K2> s2 = tree2.keySet();
		if(s1.contains(key1) || s2.contains(key2)) {
			//ERROR Key is already in system ~ should use modify method instead
		}
		else {
			Object[] newData = new Object[3];
			newData[0] = data;
			newData[1] = key1;
			newData[2] = key2;
			tree1.put(key1, data);
			tree2.put(key2, data);
		}
	}
	
	D search1(K1 key1) {
		return tree1.get(key1);
	}
	
	D search2(K2 key2) {
		return tree2.get(key2);
	}
	
	void modify1(K1 key1, D data) {
		D temp = tree1.get(key1);
		Set<Map.Entry<K2, D>> a = tree2.entrySet();
		Object[] a2 = a.toArray();
		tree1.put(key1, data);
		tree2.put(null, data);
	}
	
	void modify2(K2 key2, D data) {
		D temp = tree2.get(key2);
		
		tree1.put(null, temp);
		tree2.put(key2, temp);
	}
	
	void delete1(K1 key1) {
		D temp = tree1.remove(key1);
		tree2.remove(null);
	}
	
	void delete2(K2 key2) {
		D temp = tree2.remove(key2);
		tree1.remove(null);
	}
	
	void change1(K1 key1, K2 key2) {
		D temp = tree1.get(key1);
		tree2.remove(null);
		tree2.put(key2, temp);
		
	}
	
	void change2(K2 key2, K1 key1) {
		D temp = tree2.get(key2);
		tree1.remove(null);
		tree1.put(key1, temp);
	}
	
	String list1() {

		return tree1.toString();
	}
	
	String list2() {
		
		return tree2.toString();
	}
	
	
} 