/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 1. 使用递归方法找到两个键的最低共同祖先（LCA）。你可以通过递归遍历树来实现，如果当前节点的键是k1或k2，则返回它。
    如果左边和右边的子树都返回非空节点，这意味着k1和k2在不同的子树中，当前节点是LCA。
2. 一旦找到了LCA，你可以通过再次递归地遍历树并计算所遍历的边的数量来找到从k1到LCA的距离。
  类似地，你可以找到从k2到LCA的距离。
3. 最后，将k1到LCA的距离和k2到LCA的距离相加，得到k1和k2的总距离。
TC: O(N); SC: O(H)
 */
public class Solution {
  public int distance(TreeNode root, int k1, int k2) {
    // Write your solution here
    TreeNode lca = LCA(root, k1, k2);
    int level1 = level(lca, k1, 0);
    int level2 = level(lca, k2, 0);
Find distance between two given keys of a Binary Tree, no parent pointers are given. Distance between two nodes is the minimum number of edges to be traversed to reach one node from other.

Assumptions:

There are no duplicate keys in the binary tree.
The given two keys are guaranteed to be in the binary tree.
The given two keys are different.
Examples:

    1

   /  \

  2    3

 / \  /  \  

4   5 6   7

       \

         8

distance(4, 5) = 2

distance(4, 6) = 4
    
    // Return the sum of the levels of k1 and k2 minus twice the level of the LCA
    return level1 + level2 - 2 *level(lca, lca.key, 0);
  }
  public TreeNode LCA(TreeNode root, int k1, int k2){
    if(root == null){
      return null;
    }
    // If the root's key is equal to either k1 or k2, return the root
    if(root.key == k1 || root.key == k2){
      return root;
    }
    // Otherwise, recursively search the left and right subtrees
    TreeNode left = LCA(root.left, k1, k2);
    TreeNode right = LCA(root.right, k1, k2);
    // If both left and right are not null, the current root is the LCA
    if(left != null && right != null){
      return root;
    }
    // Otherwise, return the non-null value (either left or right)
    return (left != null)? left : right;
  }

  public int level(TreeNode root, int key, int level){
    if(root == null) return -1;
    // If the root's key is equal to the key, return the current level
    if(root.key == key) return level;

    //recursively search the left and right subtrees
    int left = level(root.left, key, level + 1);
    int right = level(root.right, key, level + 1);

    return (left != -1)? left : right;
  }
}
