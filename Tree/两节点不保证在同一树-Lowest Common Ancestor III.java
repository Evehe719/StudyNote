
Given two nodes in a binary tree, find their lowest common ancestor (the given two nodes are not guaranteed to be in the binary tree).

Return null If any of the nodes is not in the tree.

Assumptions

There is no parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)



/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 在当前节点的左右子树中递归地查找LCA，并在当前节点上组合结果。
 基本情况是当前节点为空、给定节点中的一个为空或另一个为空。在本例中，它返回当前节点，即LCA。
 如果在左子树和右子树中都找到LCA，则返回当前节点，即LCA。
 否则，它将从其中一个子树返回LCA。
 
 如果两个节点不一定保证在同一个树上问题
// case 1: 如果返回了root说明one和two不直接隶属且one和two一定同树
// case 2: 如果返回了one或者two，说明one或者two存在隶属关系或者二者不同树，此时需要再做一次LCA(one, two, two), 即以one(two)为root找两个two(one)   

TC: O(n), where n is the number of nodes in the tree. 
SC: O(n)
 */
 
 
public class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
    // base case: if any of the input nodes is null, return null
    if (root == null || one == null || two ==null) {
      return null;
    }
    // call the helper function LCA to find the LCA of the given nodes
    TreeNode result = LCA(root, one, two);
    // check if the LCA is either one of the given nodes
    if (result == one) {
      // if the second given node is not a descendant of the first given node, return null
      if (LCA(one, two, two) == null) {
        return null;
      }
      return result;
    }
    if (result == two) {
      // if the first given node is not a descendant of the second given node, return null
      if (LCA(two, one, one) == null) {
        return null;
      }
      return result;
    }
    // otherwise, return the LCA
    return result;
  }
  
  private TreeNode LCA(TreeNode root, TreeNode one, TreeNode two) {
    // base case: if the current node is null, one of the given nodes, or the other, return it
    if (root == null || root == one || root == two) {
      return root;
    }
    // recursively find the LCA in the left and right subtrees
    TreeNode left = LCA(root.left, one, two);
    TreeNode right = LCA(root.right, one, two);
    // if the LCA is found in both the left and right subtrees, return the current node
    if (left != null && right != null) {
        return root;
    }
    // otherwise, return the LCA from one of the subtrees
    return left == null? right : left; 
  }
}
