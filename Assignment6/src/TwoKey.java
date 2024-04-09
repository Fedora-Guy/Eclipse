/* Name: Keith Reis
 * Program Name: TwoKey
 * Due Date: 4/25/22
 * Description: Creates an ADT based on two keys utilizing two Binary Trees
 * Assistance: Used TreeMap API documentation page, Used W3schools for Collections/Iterator (used in list1/list2 and a bit of insert)
 */


import java.util.Iterator; // https://www.w3schools.com/java/java_iterator.asp and https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.TreeMap; // https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/TreeMap.html


public class TwoKey<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	
	// Creates two trees with TreeMap API
	// tree1 using K1 as key, tree2 using K2 as key, 
	// and both using an Object array for the value type.
	private TreeMap<K1, Object[]> tree1 = new TreeMap<>();
	private TreeMap<K2, Object[]> tree2 = new TreeMap<>();
	
	//Inserts value into both trees ~ Only if neither key has been used before AND if the record DOES NOT already exist
	void insert(K1 key1, K2 key2, D data) {
		
		if(tree1.containsKey(key1) || tree2.containsKey(key2)) {
			//ERROR a key is already in a tree ~ should use modify method instead or chose a new key
			System.out.println("A key is already inserted ~ should use modify method instead or chose a new key");
			return;
		} else {
			// Gets the data from both trees (although it should be the same)
			// then checks to make sure the new D data coming is unique
			Iterator<Object[]> dataList1 = tree1.values().iterator();
			Iterator<Object[]> dataList2 = tree2.values().iterator();
			while(dataList1.hasNext() || dataList2.hasNext()) {
				Object[] d1 = dataList1.next();
				Object[] d2 = dataList2.next();
				if (d1[0] == data || d2 == data) {
					//ERROR the Data is already inserted {requirement that all records must be unique}
					System.out.println("This value '" + data + "' has already been inserted");
					return;
				} 
			}				
		} 
		
		Object[] newData = new Object[3]; // the variable to be stored in the tree as a value
		newData[0] = data;
		newData[1] = key1;
		newData[2] = key2;
		tree1.put(key1, newData); // Putting the actual value into the tree
		tree2.put(key2, newData);
	}
	
	//return the D data from a given key
	D search1(K1 key1) {
		return (D)tree1.get(key1)[0];
	}
	
	D search2(K2 key2) {
		return (D)tree2.get(key2)[0];
	}
	
	//Given the Key, get the original data, store it in temp, change the data index in temp, put the new data back into both trees.
	void modify1(K1 key1, D data) {
		Object[] temp = tree1.get(key1);
		temp[0] = data;
		tree1.put((K1)temp[1], temp);
		tree2.put((K2)temp[2], temp);
	}
	
	void modify2(K2 key2, D data) {
		Object[] temp = tree2.get(key2);
		temp[0] = data;
		tree1.put((K1)temp[1], temp);
		tree2.put((K2)temp[2], temp);
	}
	
	//Remove the data from the given key, and remove it from the other tree as well.
	void delete1(K1 key1) {
		Object[] temp = tree1.remove(key1);
		tree2.remove((K2)temp[2]);
	}
	
	void delete2(K2 key2) {
		Object[] temp = tree2.remove(key2);
		tree1.remove((K1)temp[1]);
	}
	
	//Grab the data from tree using the given key, remove the link to the old key, update it to the new key, and add the new link.
	void change1(K1 key1, K2 key2) {
		Object[] temp = tree1.get(key1);
		tree2.remove((K2)temp[2]);
		temp[2] = key2;
		tree2.put(key2, temp);
		
	}
	
	void change2(K2 key2, K1 key1) {
		Object[] temp = tree2.get(key2);
		tree1.remove((K1)temp[1]);
		temp[1] = key1;
		tree1.put(key1, temp);
	}
	
	// Assistance: https://www.w3schools.com/java/java_iterator.asp
	// Did not know how to get the actual values from Collection/Iterator. Tried tree1.toArray(), but couldn't get it to work.
	// The website W3schools showed me both how to get values, and how to loop through it.
	String list1() {
		String output = "";
		Iterator<Object[]> dataList = tree1.values().iterator();
		while(dataList.hasNext()) {
			Object[] temp = dataList.next();
			output += "(";
			output += temp[1];
			output += ",";
			output += temp[0];
			output += ")";
		}
		
		return output;
	}
	
	// Same as above
	String list2() {
		String output = "";
		Iterator<Object[]> dataList = tree2.values().iterator();
		while(dataList.hasNext()) {
			Object[] temp = dataList.next();
			output += "(";
			output += temp[2];
			output += ",";
			output += temp[0];
			output += ")";
		}
		return output;
	}
	
} 