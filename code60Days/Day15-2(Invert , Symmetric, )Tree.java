226. Invert Binary Tree
//其实就是把二叉树上的每个节点的左右子节点都交换一下, 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
Given the root of a binary tree, invert the tree, and return its root.

Example 1
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:
Input: root = []
Output: []

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }
}


101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

 

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 TC: O(N)
 SC: O(H)
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        // If the values of the two nodes are not equal, they are considered unequal
        //如果上述情况都不适用，该函数将递归调用自己，分别传递左子树的左和右子节点与右子树的右和左子节点进行比较。然后，如果这些递归调用都返回真，则该函数返回真。
        if(left.val != right.val) return false;
        // Recursively compare the outer (left and right) and inner (right and left) subtrees
        boolean compareOut = compare(left.left, right.right);
        boolean compareIn = compare (left.right, right.left);
        return compareOut && compareIn;
    }
}
/*
TC: O(N), where n is the number of nodes in the binary tree, since we visit each node once. 
SC: O(H) where h is the height of the binary tree, since the maximum depth of the recursion is limited by the height of the tree. 
    1. In the worst case, where the binary tree is completely unbalanced, the space complexity could be O(n), if each node only has one child. 
    2. However, in a balanced tree, the height is O(log n), so the space complexity would be O(log n) in that case.
 */
