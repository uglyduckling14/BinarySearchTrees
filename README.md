# Assn 2: Recursion  
## Introduction:  
Using recursion, travers and report information on binary search trees.

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

}  
### public String inOrderToString(){  
    //output is:  
    // Tree 1: 10 14 25 55 56 58 60 63  
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
}

### public BinaryTreeNode<E> getByKey(E key){
    // returns given BST key
}
### public int nodesInLevel(int level){
    //returns number of nodes in specified level,
    /*      100     Level 0
           /    \
         90      102    Level 1
        /  \    /   \
      85    95 101   106    Level 2 etc.
    */
    
}
### public void printAllPaths(){
    /*
        25 10 14
        25 60 55 58
        25 60 63
    */
}
### public BinaryTreeNode<E> inOrderSuccessor(BinaryTreeNode<E> node){
    // Traverse the tree to find the value closest to the given value
}
### public int countBST(){
    // returns valid BST subtrees
}