class Main {
  public static void main(String[] args) {
    /*
      
    */
    TreeNode root = new TreeNode(4,
                                new TreeNode(2,
                                            new TreeNode(1),
                                            new TreeNode(3)),
                                null);
    /*
    Above is a representation of the tree
                    4
                  /   
                2       
              /   \
            1      3
    */
    // Create an inorder iterator over this tree
    InorderIterator iter = new InorderIterator(root);
    
    // Prints nodes of tree one at a time according to an inorder 
    // traversal. Should print 1, 2, 3, 4 for the above tree.
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }

    // Second test
    System.out.println("\nSecond test");
    root = new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(4,
                                     new TreeNode(3),
                                     null));
    /*
             2
           /    \
          1      4
                / 
               3
    */
    iter = new InorderIterator(root);

    // Prints nodes of tree one at a time according to an inorder 
    // traversal. Should print 1, 2, 3, 4 for the above tree.
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}