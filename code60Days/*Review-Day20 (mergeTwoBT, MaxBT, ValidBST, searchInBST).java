617. Merge Two Binary Trees
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        //merge
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}

700. Search in a Binary Search Tree

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
 //利用 BST 左小右大的特性，可以避免搜索整棵二叉树去寻找元素，从而提升效率。
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        //search in the left side of BST
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        //search in the right side of BST
        if(root.val < val){
            return searchBST(root.right, val);
        }
        return root;
    }
}
