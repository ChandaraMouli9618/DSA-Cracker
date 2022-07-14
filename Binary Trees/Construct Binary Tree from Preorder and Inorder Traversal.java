/*
Name       : Construct Binary Tree from Inorder and Preorder Traversal
Difficulty : Medium
Link       : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
Author     : Chandra Mouli
*/


class Solution {
    int preOrderPtr = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n = preorder.length;
        HashMap<Integer, Integer> inorderIndex = new HashMap<>();
        
        for(int i=0; i<n; i++)   inorderIndex.put(inorder[i], i);
        
        return buildTreeUtil(preorder, inorder, 0, n-1, inorderIndex);
    }
    
    TreeNode buildTreeUtil(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> inorderIndex){
        
        if(start > end) return null;
        
        TreeNode currNode = new TreeNode(preorder[preOrderPtr]);
        preOrderPtr++;
        currNode.left = buildTreeUtil(preorder, inorder, start, inorderIndex.get(currNode.val)-1, inorderIndex);
        currNode.right = buildTreeUtil(preorder, inorder, inorderIndex.get(currNode.val)+1, end, inorderIndex);
        
        return currNode;
    }
}
