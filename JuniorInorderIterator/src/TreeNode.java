public class TreeNode {
  
  // Value of the node
  int val;
  
  // Children of the node
  TreeNode left = null;
  TreeNode right = null;

  // Constructor given value alone
  TreeNode(int x) { val = x; }

  // Constructor given value and child nodes
  TreeNode(int x, TreeNode left, TreeNode right) {
    val = x;
    this.left = left;
    this.right = right;
  }
}