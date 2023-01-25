Given two nodes in a binary tree, find their lowest common ancestor.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

 
 
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 Sloution:
 Use DFS
 为了找到二叉树中两个节点的最低共同祖先（LCA），可以使用深度优先搜索（DFS）算法。
 其基本思想是递归地遍历树，从根节点开始，在每个节点，检查当前节点是否是给定的节点之一，或者当前节点的左或右子树是否包含给定的节点之一。
 如果当前节点是给定的节点之一，返回它作为LCA。如果左边和右边的子树都包含给定的节点之一，返回当前节点作为LCA。
 如果只有一个子树包含给定的节点之一，则将该子树作为LCA返回。

 TC:O(N);
 SC; O(H);
 */
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root,
      TreeNode one, TreeNode two) {
    // Write your solution here.
    if(root == null || root == one || root == two){
    return root;}
    TreeNode left = lowestCommonAncestor(root.left, one, two);
    TreeNode right = lowestCommonAncestor(root.right, one, two);
    if(left != null && right != null){
      return root;
    }
    return left != null ? left : right;
  }
}
