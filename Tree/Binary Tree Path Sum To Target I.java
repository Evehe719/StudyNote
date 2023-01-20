Given a binary tree and a target sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given target.

Example:
Given the below binary tree and target = 16,

              5
             / \
            4   8
           /   / \
          1    3  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5-8-3 which sum is 16.
                
                
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 1.Use DFS recursiverly check the left and right child, while fit the target
 2. SC: O(N);  TC: O(N);
 */
public class Solution {
  public boolean exist(TreeNode root, int target) {
    // Write your solution here
    if(root == null){
      return false;
    }
    if(root.left == null && root.right == null && root.key == target){
      return true;
    }
    return exist(root.left, target - root.key) || exist(root.right, target - root.key);
  }
}
