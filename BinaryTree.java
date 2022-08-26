public class BinaryTree {
  
  BNode root;
  BinaryTree()
    {
        root = null;
    }
  
  //insert nodes (iteration)
  public void addNode(int key, String data) {
    BNode newNode = new BNode(key, data);
    
    //if root is empty, set new node as root.
    if (root == null) {
      root = newNode;
    } 
    //if not, traverse tree starting from the root
    else {
      BNode focusNode = root;
      BNode parent;
      while (true){
        parent = focusNode;
        if (key < focusNode.key) {
          focusNode = focusNode.leftChild;
          if (focusNode == null) {
            //set new Node as child of Parent
            parent.leftChild = newNode;
            return;
          }
        } 
        else {
          focusNode = focusNode.rightChild;
          if (focusNode == null) {
            //set new Node as child of Parent
            parent.rightChild = newNode;
            return;
          }
        }
      }
    }
  }
  
  //remove nodes (iteration)
  public boolean remove(int key) {
    BNode focusNode = root;
    BNode parent = root;
    boolean isItALeftChild = true;
    while (focusNode.key != key) {
      parent = focusNode;
      if (key < focusNode.key) {
        isItALeftChild = true;
        focusNode = focusNode.leftChild;
      }
      else {
        isItALeftChild = false;
        focusNode = focusNode.rightChild;
      }
      if (focusNode == null) return false;
    }
    if (focusNode.leftChild == null && focusNode.rightChild == null) {
      if (focusNode == root) root = null;
      else if (isItALeftChild) parent.leftChild = null;
      else parent.rightChild = null;
    }
    else if (focusNode.rightChild == null) {
      if (focusNode == root) root = focusNode.leftChild;
      else if (isItALeftChild) parent.leftChild = focusNode.leftChild;
      else parent.rightChild = focusNode.leftChild;
    }
    else if (focusNode.leftChild == null) {
      if (focusNode == root) root = focusNode.rightChild;
      else if (isItALeftChild) parent.leftChild = focusNode.rightChild;
      else parent.rightChild = focusNode.rightChild;
    }
    else {
      BNode replacement = getReplacementNode(focusNode);
      if (focusNode == root) root = replacement;
      else if (isItALeftChild) parent.leftChild = replacement;
      else parent.rightChild = replacement;
      replacement.leftChild = focusNode.leftChild;
    }
    return true;
  }
  
  //finds a replacement for deleted Node
  public BNode getReplacementNode(BNode replacedNode) {
    BNode replacementParent = replacedNode;
    BNode replacement = replacedNode;
    BNode focusNode = replacedNode.rightChild;
    while (focusNode != null) {
      replacementParent = replacement;
      replacement = focusNode;
      focusNode = focusNode.leftChild;
    }
    if (replacement != replacedNode.rightChild) {
      replacementParent.leftChild = replacement.rightChild;
      replacement.rightChild = replacedNode.rightChild;
    }
    return replacement;
  }

  //Inserts nodes recursively
  public BNode recursiveInsert(BNode head, int key, String data) {
    BNode rightChild;
    BNode leftChild;
    if(head == null){
      head = new BNode(key, data);
      return head;
    }
    if(head.key < key) {
      head.rightChild = recursiveInsert(head.rightChild, key, data);
    } 
    else {
      head.leftChild = recursiveInsert(head.leftChild, key, data);
    }
    return head;
  }
  
  //getter for Binary Search Tree root
  public BNode getRoot(){
    return root;
  }
  
  public void postOrder(BNode node){
    if (node == null) return;
 
    // first recur on left subtree
    postOrder(node.leftChild);
    // then recur on right subtree
    postOrder(node.rightChild);
 
    // now deal with the node
    System.out.print(node.key + " ");
  }
 
    /* Given a binary tree, print its nodes in inorder*/
  void inOrder(BNode node){
    if (node == null) return;
 
    /* first recur on left child */
    inOrder(node.leftChild);
 
    /* then print the data of node */
    System.out.print(node.key + " ");
 
    /* now recur on right child */
    inOrder(node.rightChild);
  }
 
    /* Given a binary tree, print its nodes in preorder*/
  void preOrder(BNode node){
    if (node == null)return;
 
    /* first print data of node */
    System.out.print(node.key + " ");
 
    /* then recur on left sutree */
    preOrder(node.leftChild);
 
    /* now recur on right subtree */
    preOrder(node.rightChild);
  }
  
  /*
  void deleteSplay(int key){
    int max = getMax();
    remove(key);
    if (key == max) splayNode = getMax();
    else splayNode = getNextLargest();
  }
  */
  
}