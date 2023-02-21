102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // create a list to store the results
        List<List<Integer>> res = new ArrayList<>();
        
        // if the root is null, return the empty list
        if (root == null) return res;
        
        // create a queue to store the nodes to be processed
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        // loop until the queue is empty
        while (!queue.isEmpty()) {
            // get the number of nodes in the current level
            int qlen = queue.size();
            
            // create a list to store the nodes in the current level
            List<Integer> row = new ArrayList<>();
            
            // loop through the nodes in the current level
            for (int i = 0; i < qlen; i++) {
                // remove the first node from the queue 
                // and add its value to the current level list
                TreeNode curr = queue.poll();
                row.add(curr.val);
                
                // add the left and right children of the current node 
                // to the queue if they are not null
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            
            // add the current level list to the results list
            res.add(row);
        }
        
        // return the results list
        return res;
    }
}

226. Invert Binary Tree

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        //swap
        root.left = right;
        root.right = left;
        return root;
    }
}
