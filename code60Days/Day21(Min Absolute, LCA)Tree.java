530. Minimum Absolute Difference in BST
Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
Example 1:
Input: root = [4,2,6,1,3]
Output: 1
Example 2:
Input: root = [1,0,48,null,null,12,49]
Output: 1
//遇到在二叉搜索树(BST)上求什么最值，求差值之类的，都要思考一下二叉搜索树可是有序的，要利用好这一特点。
//中序遍历会有序遍历 BST 的节点，遍历过程中计算最小差值即可。
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
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }
    TreeNode prev = null;
    int res = Integer.MAX_VALUE;

    //traverse
    public void traverse(TreeNode root){
        if(root == null) return;
        //left
        traverse(root.left);
        //mid
        if(prev != null){
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        //right
        traverse(root.right);
    }
}


236. Lowest Common Ancestor of a Binary Tree

Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Example 1:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:
Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1
  
  
  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        //postOrder
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //case1
        //如果 p 和 q 都不在以 root 为根的树中，直接返回 null
        if(left == null && right == null){// all can not find
            return null;
        }else if(left == null && right != null) { // find right one
            return right;
        }else if( left != null && right == null){ // find left one
            return left;
        }else{// find two node
            return root;
        }
        
    }
}
