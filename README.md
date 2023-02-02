# Assn 2: Recursion  
## Introduction:  
Using recursion, traverse and report information on binary search trees.

### public String toString(){  
    //output is:  
    //Tree 1  
        //63 [60]  
    //60 [25]  
        //58 [55]  
            //56 [58]  
    //55 [60]  
    //25 [no parent]  
            //14 [10]  
        //10 [25] 
    System.out.println(tree.label);
    if(root == null){
        return " ";
    }
    String tree ="";
    recursive function(String tree, root.right, 0, root);
    recursive function(String tree, BST childNode, int indent, BST parentNode){
        indent +=10;
        recursive(tree,childNode.right, indent, childNode);
        tree += indent + childNode+[parentNode]+\n; 
        tree = "";
        recursive function(tree, childNode.left, indent, childNode);
    }
    
}  
### public String inOrderToString(){  
    //output is:  
    // Tree 1: 10 14 25 55 56 58 60 63 
    if node is null return;
    call recursive function(left node);
    print(node.key+ " ");
    call recursive function(right node);
}
### public void balanceTree(){
    /* Before:          After:
        Tree 1              Tree 1
            63 [60]             63 [60]
        60 [25]             60[58]
            58 [55]       58 [55]
                56 [58]     56 [58]
        55 [60]         55 [no parent]
    25 [no parent]          25 [14]
        14 [10]           14 [55]
    10 [25]                 10 [14]
    */
    add each value in order to the arraylist. Once done, divide in half and insert into a new tree.
    starting with Tree # then print right most value with parent node in [].
    private ArrayList inOrder(root){
        if(root == null){
            add root to ArrayList
        }
        recursive function(root.left);
        add root to ArrayList;
        recursive function(root.right);
    }
    private boolean checkBalance(BST){
        int leftHeight;
        int rightHeight;
        if(node == null){
            return true;
        }
        leftHeight = height(node.left);
        rightHeight = height(node.right);
        if(Math.abs(leftHeight-rightHeight)<=1 && checkBalance(node.left) && checkBalance(node.right)){
            return true;
        }
        return false;
    }
    private int height(BST){
        if(node == null){
            return 0;
        }    
        return 1+ Math.max(height(node.left),height(node.right));
    }
    private Node balanced(ArrayList, start, end){
        if(start>end){
            return null;
        }
        int middle = (start + end)/2;
        Node root = ArrayList.get(middle);
        root.left = balanced(nodes,start, mid-1);
        root.right = balanced(nodes, mid+1, end);
        return root;
    }
}
### public void flip(){
    /* Before:                   After:             
        Tree 1                   Tree 1       
            63 [60]                10 [25]    
          60 [25]                    14 [10]     
              58 [55]            25 [no parent]     
                 56 [58]             55 [60]      
            55 [60]                      56 [58]      
        25 [no parent]                 58 [55]        
            14 [10]                60 [25]         
          10 [25]                    63 [60] 
    */
        call recursive function(root){
            temp = root.left
            root.left = root.right;
            root.right = temp;
            if(root.left != null){
                recursive function(root.left);
            }
            if(root.right != null){
                recursive function(root.right);
            }
        }
    }
}
### public BinaryTreeNode<E> getByKey(E key){
    // returns given BST key
    start with root node;
    if key is < root.key{
        private getByKey(root.right, key);
    }else if key is > root.key{
        private getByKey(root.left, key);
    }
    if(node.key == key) return key;
    
}
### public int nodesInLevel(int level){
    //returns number of nodes in specified level,
    /*      100     Level 0
           /    \
         90      102    Level 1
        /  \    /   \
      85    95 101   106    Level 2 etc.
    */
    if(level==0){
        return 1;
    }
    countingLevel(level, 0,0);
    call recursive countingLevel function(int level, int counter, int currentLevel){
        traverse BST when left level is reached
        call countingLevel(level, counter,0)
        traverse BST when right level is reached)
        return counter;
    }
    
}
### public void printAllPaths(){
    /*
        25 10 14
        25 60 55 58
        25 60 63
    */
    String path = "";
    call recursive function(node,path){
        if(node == null){
            return;
        }
        path+=node;
        if(node.left == null && node.right==null){
            System.out.println(path);
            path = " ";
        }else{
            call recursive function(node.left, path);
            call recursive function(node.right, path);
        }
    }
}
### public BinaryTreeNode<E> inOrderSuccessor(BinaryTreeNode<E> node){
    // Traverse the tree to find the value closest to and above the given value
    if(node == null){
        return node;
    }
    if(node.right>node){
        return inOrderSuccessor(node.right);
    }else{
    
    }
}
### public int countBST(){
    // returns valid BST subtrees
    call recursive function;
    start int count = 0;
    if(root.left and root.right == null){
        return count;
    }else{
        if(root.left<root){
            count++;
            call recursive count function(count,root);
        }else(root.right>root){
            count++;
            call recursive count function(count,root);
        }
    }
}

## Notes:
Major Changes:   
* Removed inOrder, height and checkBalance from balanceTree().   
* 