/*
Name       : Construct Binary Tree from Inorder and Postorder Traversal
Difficulty : Medium
Link       : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
Author     : Chandra Mouli
*/


class Solution {
    int postOrderPtr;
     public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = postorder.length;
        postOrderPtr = n-1;
       
        // To obtain the index of an element in inorder array.
        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        
        for(int i=0; i<n; i++)   inorderIndex.put(inorder[i], i);
        
        return buildTreeUtil(postorder, inorder, 0, n-1, inorderIndex);
    }
    
    TreeNode buildTreeUtil(int[] postorder, int[] inorder, int start, int end, HashMap<Integer, Integer> inorderIndex){
        
        if(start > end) return null;
        
        TreeNode currNode = new TreeNode(postorder[postOrderPtr]);
        postOrderPtr--;
        currNode.right = buildTreeUtil(postorder, inorder, inorderIndex.get(currNode.val)+1, end, inorderIndex);
        currNode.left = buildTreeUtil(postorder, inorder, start, inorderIndex.get(currNode.val)-1, inorderIndex);
        
        return currNode;
    }
}
