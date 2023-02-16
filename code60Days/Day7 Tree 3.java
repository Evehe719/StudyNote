104. Maximum Depth of Binary Tree


Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.



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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //go ti get the maxdepth from left and right side
        int leftMax = maxDepth(root.left);
	    int rightMax = maxDepth(root.right);
        //choose the max and add the first root
        int res = Math.max(leftMax, rightMax) + 1;
        
        return res;
    }
}
