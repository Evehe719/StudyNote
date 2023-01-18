Given a binary tree in which each node contains an integer number. The diameter is defined as the longest distance from one leaf node to another leaf node. The distance is the number of nodes on the path.

If there does not exist any such paths, return 0.

Examples

    5

  /    \

2      11

     /    \

    6     14

The diameter of this tree is 4 (2 → 5 → 11 → 14)

How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 the reason we need to + 1 for leftDepth + rightDepth + 1, 
 coz we're updating the diameter based on the nodes traveled not the edges.
 SC: O(Height）

 */
public class Solution {
  int maxDiameter = 0;
  public int diameter(TreeNode root) {
    // Write your solution here
    maxDepth(root);
    return maxDiameter;
  }
  public int maxDepth(TreeNode root){
    if(root == null){
      return 0;
    }
    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    if(root.left != null && root.right != null){
      maxDiameter = Math.max(maxDiameter, maxLeft + maxRight + 1);
    }
    return 1 + Math.max(maxLeft, maxRight);
  }
}
