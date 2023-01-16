257. Minimum Depth of Binary Tree
Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Example:
Given the below binary tree

             5

          /       \

        3         8

           \

               4

minimum depth is 2,path is 5→8.

Clarification:

  1. The root itself can be a valid path if there is only one node in the binary tree
  2. If root == null, return 0

    /**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 Slousion: DFS
 1. The basic idea is to traverse the tree starting 
    from the root node and recursively go down to the left and right children of the current node, 
 2. while keeping track of the current depth. 
    The minimum depth is the minimum of the depths of the left and right children plus one.
   TC O(n); SC O(Height);

 */
    
public class Solution {
  public int minDepth(TreeNode root) {
    // Write your solution here
    if(root == null){
      return 0;
    }
    if(root.left == null && root.right == null){
      return 1;
    }
    int left = Integer.MAX_VALUE;
    int right = Integer.MAX_VALUE;
    if(root.left != null){
      left = minDepth(root.left);
    }
    if(root.right != null){
      right = minDepth(root.right);
    }
    return Math.min(left,right) + 1;
  }
}
