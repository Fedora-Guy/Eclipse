/* Name: Keith Reis
 * Program Name: TwoKey
 * Due Date: 4/25/22
 * Description: Creates an ADT based on two keys utilizing two Binary Trees
 * Assistance: Used TreeMap API documentation page, Used W3schools for Collections/Iterator (used in list1/list2 and a bit of insert)
 */


import java.util.Iterator; // https://www.w3schools.com/java/java_iterator.asp and https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
import java.util.TreeMap; // https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/TreeMap.html


public class TwoKeyUpdated<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	
	// Creates two trees with TreeMap API
	// tree1 using K1 as key, tree2 using K2 as key, 
	// and both using an Node class for the value type.
	private TreeMap<K1, Node<K1, K2, D>> tree1 = new TreeMap<>();
	private TreeMap<K2, Node<K1, K2, D>> tree2 = new TreeMap<>();
	private Node<K1, K2, D> node; // At the bottom of the file
	
	//Inserts value into both trees ~ Only if neither key has been used before ~AND if the record DOES NOT already exist~
	void insert(K1 key1, K2 key2, D data) {
		
		if(tree1.containsKey(key1) || tree2.containsKey(key2)) {
			//ERROR a key is already in a tree ~ should use modify method instead or chose a new key
			System.out.println("A key is already inserted ~ should use modify method instead or chose a new key");
			return;
		} else {
		/* I read the insert method requirement wrong:	insert a record into the database. it is an
		 * 												error if record already exists. (I assumed record meant data alone)
			
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
			}	*/			
		} 
		Node<K1, K2, D> tempNode = new Node<>(key1, key2, data);
		tree1.put(key1, tempNode); // Putting the actual value into the tree
		tree2.put(key2, tempNode);
	}
	
	//return the D data from a given key
	D search1(K1 key1) {
		return tree1.get(key1).returnData();
	}
	
	D search2(K2 key2) {
		return tree2.get(key2).returnData();
	}
	
	//Given the Key, get the original data, store it in tempNode, change the data index in temp, put the new data back into both trees.
	void modify1(K1 key1, D data) {
		Node<K1, K2, D> tempNode = tree1.get(key1);
		tempNode.setData(data);
		tree1.put(tempNode.returnKey1(), tempNode);
		tree2.put(tempNode.returnKey2(), tempNode);
	}
	
	void modify2(K2 key2, D data) {
		Node<K1, K2, D> tempNode = tree2.get(key2);
		tempNode.setData(data);
		tree1.put(tempNode.returnKey1(), tempNode);
		tree2.put(tempNode.returnKey2(), tempNode);
	}
	
	//Remove the data from the given key, and remove it from the other tree as well.
	void delete1(K1 key1) {
		Node<K1, K2, D> tempNode = tree1.remove(key1);
		tree2.remove(tempNode.returnKey2());
	}
	
	void delete2(K2 key2) {
		Node<K1, K2, D> tempNode = tree2.remove(key2);
		tree1.remove(tempNode.returnKey1());
	}
	
	//Grab the data from tree using the given key, remove the link to the old key, update it to the new key, and add the new link.
	void change1(K1 key1, K2 key2) {
		Node<K1, K2, D> tempNode = tree1.get(key1);
		tree2.remove(tempNode.returnKey2());
		tempNode.setKey2(key2); 
		tree2.put(key2, tempNode);
		
	}
	
	void change2(K2 key2, K1 key1) {
		Node<K1, K2, D> tempNode = tree2.get(key2);
		tree1.remove(tempNode.returnKey1());
		tempNode.setKey1(key1);
		tree1.put(key1, tempNode);
	}
	
	// Assistance: https://www.w3schools.com/java/java_iterator.asp
	// Did not know how to get the actual values from Collection/Iterator. Tried tree1.toArray(), but couldn't get it to work.
	// The website W3schools showed me both how to get values, and how to loop through it.
	String list1() {
		String output = "";
		Iterator<Node<K1, K2, D>> dataList = tree1.values().iterator();
		while(dataList.hasNext()) {
			Node<K1, K2, D> tempNode = dataList.next();
			output += "(";
			output += tempNode.returnKey1();
			output += ",";
			output += tempNode.returnData();
			output += ")";
		}
		
		return output;
	}
	
	// Same as above
	String list2() {
		String output = "";
		Iterator<Node<K1, K2, D>> dataList = tree2.values().iterator();
		while(dataList.hasNext()) {
			Node<K1, K2, D> tempNode = dataList.next();
			output += "(";
			output += tempNode.returnKey2();
			output += ",";
			output += tempNode.returnData();
			output += ")";
		}
		return output;
	}
	
} 

class Node<K1 extends Comparable<K1>, K2 extends Comparable<K2>, D> {
	private K1 key1;
	private K2 key2;
	private D data;
	
	Node(K1 key1, K2 key2, D data) {
		this.key1 = key1;
		this.key2 = key2;
		this.data = data;
	}
	
	Node(Node<K1, K2, D> tempNode) {
		this.key1 = tempNode.returnKey1();
		this.key2 = tempNode.returnKey2();
		this.data = tempNode.returnData();
	}
	
	public void setKey1(K1 key1) {
		this.key1 = key1;
	}
	
	public void setKey2(K2 key2) {
		this.key2 = key2;
	}
	
	public void setData(D data) {
		this.data = data;
	}
	
	public void setNode(K1 key1, K2 key2, D data) {
		this.key1 = key1;
		this.key2 = key2;
		this.data = data;
	}
	
	public K1 returnKey1() {
		return key1;
	}
	
	public K2 returnKey2() {
		return key2;
	}
	
	public D returnData() {
		return data;
	}
	
	public Node<K1, K2, D> returnNode() {
		return this;
	}
}