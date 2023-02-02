import java.util.*;

public class Tree<E extends Comparable<? super E>> {
    private BinaryTreeNode root;  // Root of tree
    private String name;     // Name of tree

    /**
     * Create an empty tree
     *
     * @param label Name of tree
     */

    public Tree(String label) {
        name = label;
    }

    /**
     * Create BST from ArrayList
     *
     * @param arr   List of elements to be added
     * @param label Name of tree
     */
    public Tree(ArrayList<E> arr, String label) {
        name = label;
        for (E key : arr) {
            insert(key);
        }
    }

    /**
     * Create BST from Array
     *
     * @param arr   List of elements to be added
     * @param label Name of  tree
     */
    public Tree(E[] arr, String label) {
        name = label;
        for (E key : arr) {
            insert(key);
        }
    }

    /**
     * Return a string containing the tree contents as a tree with one node per line
     */
    public String toString() {
        System.out.println(name);
        return toString("",root,0,root);
    }
    private String toString(String tree, BinaryTreeNode childNode, int indent, BinaryTreeNode parentNode){
        if(childNode==null){
            return "";
        }
        tree = toString(tree, childNode.right, indent+=2, childNode);
        String indentTree="";
        for(int i = 0; i<indent; i++){
            indentTree += " ";
        }
        if(childNode == root){
            //System.out.println('t');
            tree = tree + childNode.key+" [no parent]"+"\n";
        }else {
            indent+=2;
            tree = tree +indentTree+childNode.key + " [" + parentNode.key + "]" + "\n";
        }
        //indent++;
        return tree+toString(tree, childNode.left, indent, childNode);
    }
    /**
     * Return a string containing the tree contents as a single line
     */
    public String inOrderToString() {
        name+=":";
        return inOrder(root);
    }
    private String inOrder(BinaryTreeNode node){
        if (node == null){
            return name;
        }
        //System.out.println(order);
        inOrder(node.left);
        name+=" "+node.key;
        inOrder(node.right);
        return name;
    }

    /**
     * reverse left and right children recursively
     */
    public void flip() {
        if(root == null){
            return;
        }
        rFlip(root);
    }
    private void rFlip(BinaryTreeNode node){
        BinaryTreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.left != null){
            rFlip(node.left);
        }
        if(node.right != null){
            rFlip(node.right);
        }
    }

    /**
     * Returns the in-order successor of the specified node
     * @param node node from which to find the in-order successor
     */
    public BinaryTreeNode inOrderSuccessor(BinaryTreeNode node) {
        if(node.right!=null){
            return leftSuccessor(node.right);
        }
        BinaryTreeNode parent = node.parent;
        while(parent != null && node == parent.right){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }
    private BinaryTreeNode leftSuccessor(BinaryTreeNode node){
        if(node.left==null){
            return node;
        }
        return leftSuccessor(node.left);
    }
    /**
     * Counts number of nodes in specified level
     *
     * @param level Level in tree, root is zero
     * @return count of number of nodes at specified level
     */
    public int nodesInLevel(int level) {
        if(level==0){
            return 1;
        }
        if(root == null){
            return 0;
        }
        return countingLevel(level, 0, root);
    }
    private int countingLevel(int level, int currentLevel, BinaryTreeNode node){
        if(node == null){
            return 0;
        }
        if(level == currentLevel){
            return 1;
        }
        return countingLevel(level,currentLevel+1,node.left)+countingLevel(level,currentLevel+1,node.right);
    }

    /**
     * Print all paths from root to leaves
     */
    public void printAllPaths() {
        String path = "";
        allPath(root,path);
    }
    private void allPath(BinaryTreeNode node, String path){
            if(node == null){
                return;
            }
            path+=node.key+" ";
            if(node.left == null && node.right==null){
                System.out.println(path);
            }else{
                allPath(node.left, path);
                allPath(node.right, path);
            }
    }

    /**
     * Counts all non-null binary search trees embedded in tree
     *
     * @return Count of embedded binary search trees
     */
    int count = 1;
    public int countBST() {
        count=1;
        count=counter(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
        return count;
    }
    private int counter(BinaryTreeNode node, int min, int max){
        if(node == null){
            return count;
        }
        //System.out.println('x');
        //System.out.println(count);
        //System.out.println(node.key);
        counter(node.left,min,(Integer)node.key);
        counter(node.right,(Integer)node.key,max);
        if((Integer)node.key >= min && (Integer)node.key<=max){
            //System.out.println('x');
            return count++;
        }
        return count;
    }

    /**
     * Insert into a bst tree; duplicates are allowed
     *
     * @param x the item to insert.
     */
    public void insert(E x) {
        root = insert(x, root, null);
    }

    public BinaryTreeNode getByKey(E key) {
        if(root==null){
            return null;
        }
        if(root.key == key){
            return root;
        }
        return getKey(key, root);
    }
    private BinaryTreeNode getKey(E key, BinaryTreeNode node){
        if(node == null){
            return null;
        }
        if(node.key == key){
            return node;
        }
        if((Integer)node.key > (Integer)key){
            return getKey(key,node.left);
        }else{
            return getKey(key,node.right);
        }
    }
    /**
     * Balance the tree
     */
    public void balanceTree() {
        root = balanceTree(root);
    }
    private BinaryTreeNode balanceTree(BinaryTreeNode node){
        ArrayList<BinaryTreeNode> nodes = new ArrayList<>();
        storer(node,nodes);
        int length = nodes.size();
        return builder(nodes,0, length-1);
    }
    private void storer(BinaryTreeNode node, ArrayList<BinaryTreeNode> list){
        if(node == null){
            return;
        }
        storer(node.left,list);
        list.add(node);
        storer(node.right, list);
    }
    private BinaryTreeNode builder(ArrayList<BinaryTreeNode> list,int start, int end){
        if(start>end){
            return null;
        }
        int middle = (start+end)/2;
        BinaryTreeNode node = list.get(middle);
        node.left = builder(list,start, middle-1);
        node.right = builder(list, middle+1, end);
        return node;
    }

    /**
     * Internal method to insert into a subtree.
     * In tree is balanced, this routine runs in O(log n)
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryTreeNode insert(E x, BinaryTreeNode t, BinaryTreeNode parent) {
        if (t == null) return new BinaryTreeNode(x, null, null, parent);

        int compareResult = x.compareTo(t.key);
        if (compareResult < 0) {
            t.left = insert(x, t.left, t);
        } else {
            t.right = insert(x, t.right, t);
        }

        return t;
    }


    /**
     * Internal method to find an item in a subtree.
     * This routine runs in O(log n) as there is only one recursive call that is executed and the work
     * associated with a single call is independent of the size of the tree: a=1, b=2, k=0
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     *          SIDE EFFECT: Sets local variable curr to be the node that is found
     * @return node containing the matched item.
     */
    private boolean contains(E x, BinaryTreeNode t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.key);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else {
            return true;    // Match
        }
    }

    // Basic node stored in unbalanced binary trees
    public class BinaryTreeNode {
        E key;            // The data/key for the node
        BinaryTreeNode left;   // Left child
        BinaryTreeNode right;  // Right child
        BinaryTreeNode parent; //  Parent node

        // Constructors
        BinaryTreeNode(E theElement) {
            this(theElement, null, null, null);
        }

        BinaryTreeNode(E theElement, BinaryTreeNode lt, BinaryTreeNode rt, BinaryTreeNode pt) {
            key = theElement;
            left = lt;
            right = rt;
            parent = pt;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node:");
            sb.append(key);
            if (parent == null) {
                sb.append("<>");
            } else {
                sb.append("<");
                sb.append(parent.key);
                sb.append(">");
            }

            return sb.toString();
        }
    }
}
