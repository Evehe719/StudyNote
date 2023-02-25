513. Find Bottom Left Tree Value

Given the root of a binary tree, return the leftmost value in the last row of the tree.
Example 1:
Input: root = [2,1,3]
Output: 1
Example 2:


Input: root = [1,2,3,4,null,5,6,null,null,7]
Output: 7
  
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
    private int Deep = -1; // initialize Deep to -1
    private int value = 0; // initialize value to 0
    public int findBottomLeftValue(TreeNode root) {
        value = root.val; // set value to the root value
        findValue(root,0); // call the private helper function with the root and deep level 0
        return value; // return the leftmost value at the deepest level
    }

    private void findValue(TreeNode root, int deep){
        if(root == null) return; // if the root is null, return
        if(root.left == null && root.right == null){ // if the root is a leaf node
            if(deep > Deep){ // check if its deep level is greater than the current deepest level
                value = root.val; // update the leftmost value at the deepest level
                Deep = deep; // update the deepest level
            }
        }
        // recursively call the function on the left child node
        if (root.left != null) findValue(root.left, deep + 1); 
        // recursively call the function on the right child node
        if(root.right != null) findValue(root.right, deep + 1); 
    }
}
