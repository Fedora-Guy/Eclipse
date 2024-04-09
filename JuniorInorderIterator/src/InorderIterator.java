import java.util.Iterator;
import java.util.Stack;

public class InorderIterator implements Iterator {
  
  Stack<TreeNode> stack = new Stack<>();
  Stack<Integer> integerStack = new Stack<>();
  // You can add more instance variables here
  
  public boolean hasNext() {
	// Add code here
	  // Returns return true if the tree has not yet been fully traversed and false if it has.
	  return !(integerStack.empty());
    
  }
  
  public Integer next() {
	// Add code here
	  return integerStack.pop();
  }
  
  public InorderIterator(TreeNode root) {
    // Add code here
	  while(!stack.empty() || root != null) {
		  if(root != null) {
			  stack.push(root);
			  root = root.left;
		  } else {
			  root = stack.pop();
			  integerStack.add(0, root.val); // Shifts elements at that position to the right
			  // Source: https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html#add-int-E-
			  // (Source: Vector on Java Docs)
			  // Reason: Makes it so Integers are stored in-order
			  root = root.right;
		  }
	  }
	  // Source: Wikipedia Article attached
	  /*
	   * root.left.left;
	   * root.left;
	   * root.left.right;
	   * root;
	  */
  }
}