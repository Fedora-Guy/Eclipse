package BinarySearchTree;

/**
 *
 * 
 */
public class BinaryTree {
	static int globalTimestamp = 0;
	public static class Tree<K extends Comparable<K>,D> {
		
		private class Node {
			public K key;
			public D data;
			public Node left, right;
			
			public Node(K k, D d, Node l, Node r) {
				key = k; data = d; left = l; right = r;
			}
			
			public Node(K k, D d) {
				this(k,d,null,null);
			}
			
			public String toString() { 
				return "(" + key + "," + data + ")";
			}
		}
		
		private Node root;
		private int size;
		
		public Tree() { 
			root = null; size = 0;
		}
		
		public Tree(K[] keys, D[] data) {
			// Assume records are sorted.
			root = buildTree(keys, data, 0, keys.length-1);
		}
		
		private Node buildTree(K[] keys, D[] data, int lo, int hi) {
			// Assumes keys are in order.
			if(lo > hi)
				return null;
			int m = (hi - lo) / 2 + lo;
			return new Node(keys[m], data[m],
					buildTree(keys, data, lo, m-1),
					buildTree(keys, data, m+1, hi));
		}
		
		public int size() { 
			return size; 
		}
		
		private D find(K key, Node x) {
			if(x == null)
				return null;
			int c = key.compareTo(x.key);
			if(c == 0)
				return x.data;
			else if(c < 0)
				return find(key, x.left);
			else // c > 0
				return find(key, x.right);
		}
		
		public D find(K key) {
			return find(key, root);
		}
		
		private Node add(K key, D data, Node root) {
			// returns the tree with the added record.
			if(root == null) {
				size++;
				return new Node(key,data);
			}
			int c = key.compareTo(root.key);
			if(c == 0) {
				System.err.println("Error: duplicate key: "+key);
				System.exit(1);
				return null;
			} else if(c < 0) {
				root.left = add(key, data, root.left);
				return root;
			} else { // c > 0
				root.right = add(key, data, root.right);
				return root;
			}
		}
		
		public void add(K key, D data) {
			root = add(key, data, root);
		}

		private void modify(K key, D data, Node root) {
			if(root == null) {
				System.err.println("Error: key not found: "+key);
				System.exit(1);
			}
			int c = key.compareTo(root.key);
			if(c == 0)
				root.data = data;
			else if(c < 0)
				modify(key, data, root.left);
			else // c > 0
				modify(key, data, root.right);
		}
		
		public void modify(K key, D data) {
			modify(key, data, root);
		}
		
		private String numSpaces(int n) {
			String s = "";
			for(int i=0; i<n; i++)
				s += " ";
			return s;
		}
// private String toString(Node root, int level) {
// if(root == null)
// return "";
// return toString(root.right, level+1)
// + numSpaces(level) + root + "\n"
// + toString(root.left, level+1);
// }
// public String toString() {
// return toString(root, 0);
// }
		private String toString(Node root) {
			if(root == null)
				return "";
			return toString(root.left) + root + toString(root.right);
		}
		
		public String toString() {
			return toString(root);
		}
		
		private Node findLeftmost(Node root) {
			// Assumes root != null.
			return root.left == null ? root : findLeftmost(root.left);
		}
		
		private Node removeLeftmost(Node root) {
			// Assumes root != null.
			if(root.left == null) {
				return root.right;
			} else {
				root.left = removeLeftmost(root.left);
				return root;
			}
		}
		
		private Node delete(K key, Node root) {
			if(root == null) {
				System.err.println("Error: key not found");
				System.exit(1);
				return null;
			}
			int c = key.compareTo(root.key);
			if(c == 0) {
				size--;
				if(root.left == null) {
					return root.right;
				} else if(root.right == null) {
					return root.left;
				} else {
					Node t = root;
					root = findLeftmost(root.right);
					root.right = removeLeftmost(t.right);
					root.left = t.left;
					return root;
				}
			} else if(c < 0) {
				root.left = delete(key, root.left);
				return root;
			} else { // c > 0
				root.right = delete(key, root.right);
				return root;
			}
		}
		
		public void delete(K key) {
			root = delete(key, root);
		}
		
		private Node push() {
			
		}
		public void push(K key) {
			root = push(key, root);
		}
		
		
		private Node pop(Node root) {
			if(root == null) {
				System.err.println("Nothing left to pop");
				System.exit(1);
				return null;
			}
			// Traverse until Latest Node
			Node temp = root;
			Node currentNode = temp;
			while(temp != null) {
				
			}
			return root;
		}
		public void pop() {
			root = pop(root);
		}
	}
	
	public static void main(String[] args) {
		Character[] keys = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		String[] data= { "Atlanta", "Boston", "Charleston", 
				"Denver", "East Hampton", "Foxborough", "Galveston" };
		Tree<Character, String> tree = new Tree<Character, String>(keys, data); //Create balanced tree.
		System.out.println(tree);
		tree.delete('C');
		tree.delete('D');
		tree.add('P', "Pittsburgh");
		tree.modify('A', "Austin");
		System.out.println(tree);
		System.out.println(tree.find('A'));
		System.out.println(tree.find('D'));
		Tree<Character, String> tree2 = new Tree<Character, String>(); // Create stringy tree.
		for(int i=0; i<keys.length; i++)
			tree2.add(keys[i], data[i]);
		System.out.println(tree2);
		
		// New Tree where Key is global Int variable
		// Key is incremeneted every time a key is added to stack or queue.
		// Data is the "key to be inserted into the stack or queue".
		Tree<Integer, Integer> newTree = new Tree<>();
		newTree.push(globalTimestamp);
		System.out.print(newTree);
		newTree.pop();
	}
	/** TODO
	 * 	1. Add in Stack Operations "Void push (K key)" and "K pop()"
	 * 	2. Test for those Methods in Main
	 * 	3. Add in Queue Operations "void add (K key)" and "K remove()"
	 * 	4. Test for those Methods in Main
	 * 	Hints: Use a BST where the key is a global timestamp and the
	 *		   data is the key to be inserted into the stack or queue. 
	 *		   A global timestamp is an int global variable that is
	 *		   incremented every time a key is added to the stack or queue.
	 */
}