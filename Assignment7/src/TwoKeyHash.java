/* Name: Keith Reis
 * Program Name: TwoKeyHash
 * Due Date: 5/4/22
 * Description: Creates an ADT based on two keys utilizing two Hash Tables
 * Assistance: None
 */

import java.util.HashMap;
import java.util.Iterator;

public class TwoKeyHash<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	
	// Create two Hash Tables using HashMap API with
	// K1 and K2 being keys for hashMap 1 and hashMap 2 respectively, 
	// and both using a Node (class down at the bottom) as the value
	private HashMap<K1, Node> hashMap1 = new HashMap<>();
	private HashMap<K2, Node> hashMap2 = new HashMap<>();
	
	// Insert the data into both Hash Maps, assuming neither key has been used so far.
	// If either key has been used, it does not input the data.
	void insert(K1 key1, K2 key2, D data) {
		if(hashMap1.containsKey(key1) && hashMap2.containsKey(key2)) {
			System.out.println("Error ~ Both Key 1 '" + key1 + "' and Key 2 '" + key2 + "' are already in use.");
			return;
		} else if (hashMap1.containsKey(key1)) {
			System.out.println("Error ~ Key 1 '" + key1 + "' is already in use.");
			return;
		} else if (hashMap2.containsKey(key2)) {
			System.out.println("Error ~ Key 2 '" + key2 + "' is already in use.");
			return;
		}
		Node tempNode = new Node(key1, key2, data);
		hashMap1.put(key1, tempNode);
		hashMap2.put(key2, tempNode);
	}
	
	// returns the D for the key if the Key exists. If it does not, returns null
	D search1(K1 key1) {
		Node tempNode = hashMap1.get(key1);
		if(tempNode != null) {
			return tempNode.getData();
		} else {
			return null;
		}
	}
	
	D search2(K2 key2) {
		Node tempNode = hashMap2.get(key2);
		if(tempNode != null) {
			return tempNode.getData();
		} else {
			return null;
		}
	}
	
	// changes the D for the given key and it's partner key, if the key exists. 
	void modify1(K1 key1, D data) {
		Node tempNode = hashMap1.get(key1);
		if(tempNode != null) {
			tempNode.setData(data);
			hashMap1.put(tempNode.getKey1(), tempNode);
			hashMap2.put(tempNode.getKey2(), tempNode);
		} else {
			System.out.println("Error ~ Cannot modify. Key 1 '" + key1 + "' does not exist.");
		}
	}
	
	void modify2(K2 key2, D data) {
		Node tempNode = hashMap2.get(key2);
		if(tempNode != null) {
			tempNode.setData(data);
			hashMap1.put(tempNode.getKey1(), tempNode);
			hashMap2.put(tempNode.getKey2(), tempNode);
		} else {
			System.out.println("Error ~ Cannot modify. Key 2 '" + key2 + "' does not exist.");
		}
	}
	
	// removes both keys and data from the Hash Table
	void delete1(K1 key1) {
		Node tempNode = hashMap1.remove(key1);
		if(tempNode != null) {
			hashMap2.remove(tempNode.getKey2());
		} else {
			System.out.println("Error ~ Cannot delete. Key 1 '" + key1 + "' does not exist.");
		}
	}
	
	void delete2(K2 key2) {
		Node tempNode = hashMap2.remove(key2);
		if(tempNode != null) {
			hashMap1.remove(tempNode.getKey1());			
		} else {
			System.out.println("Error ~ Cannot delete. Key 2 '" + key2 + "' does not exist.");
		}
	}
	
	// Changes the K2 if both K1 exists, AND the new K2 doesn't already exist.
	void change1(K1 key1, K2 key2) {
		Node tempNode = hashMap1.get(key1);
		if(tempNode != null) {
			if(hashMap2.containsKey(key2)) {
				System.out.println("Error ~ Cannot change Key 2. Key 2 '" + key2 + "' already in system.");
			} else {
				hashMap2.remove(tempNode.getKey2());
				tempNode.setKey2(key2);
				hashMap2.put(key2, tempNode);
			}
		} else {
			System.out.println("Error ~ Cannot change Key 2. Key 1 '" + key1 + "' does not exist.");
		}
	}
	
	void change2(K2 key2, K1 key1) {
		Node tempNode = hashMap2.get(key2);
		if(tempNode != null) {
			if(hashMap1.containsKey(key1)) {
				System.out.println("Error ~ Cannot change Key 1. Key 1 '" + key1 + "' already in system.");
			} else {
				hashMap1.remove(tempNode.getKey1());
				tempNode.setKey1(key1);
				hashMap1.put(key1, tempNode);
			}
		} else {
			System.out.println("Error ~ Cannot change Key 1. Key 2 '" + key2 + "' does not exist.");
		}
	}
	
	// returns a string of the Hash Table
	String list1() {
		String output = "";
		Iterator<Node> dataList = hashMap1.values().iterator();
		while(dataList.hasNext()) {
			Node tempNode = dataList.next();
			output += "(" + tempNode.getKey1() + "," + tempNode.getData() + ")";
		}
		return output;
	}
	
	String list2() {
		String output = "";
		Iterator<Node> dataList = hashMap2.values().iterator();
		while(dataList.hasNext()) {
			Node tempNode = dataList.next();
			output += "(" + tempNode.getKey2() + "," + tempNode.getData() + ")";
		}
		return output;
	}
	
	// Class Node with getters and setters
	class Node {
		private K1 key1;
		private K2 key2;
		private D data;
		public Node(K1 key1, K2 key2, D data) {
			this.key1 = key1;
			this.key2 = key2;
			this.data = data;
		}
		
		K1 getKey1() {
			return key1;
		}
		
		K2 getKey2() {
			return key2;
		}
		
		D getData() {
			return data;
		}
		
		void setKey1(K1 key1) {
			this.key1 = key1;
		}
		
		void setKey2(K2 key2) {
			this.key2 = key2;
		}
		
		void setData(D data) {
			this.data = data;
		}
	}
}