Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

For example:
Given binary tree,

              5
             / \
            1   5
           / \   \
          5   5   5
return 4.
               
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
1. The function countUnivalSubtrees takes in the root of the binary tree 
as a parameter and initializes a variable count to keep track of the number of uni-value subtrees.
2. It first checks if the root node is null, in which case it returns 0 as there are no uni-value subtrees in the tree.
3. If the root node is not null, it checks if the subtree rooted at the current node is a uni-value subtree using the isUnival function. If it is, it increments the count by 1.
4. Next, it recursively calls the countUnivalSubtrees function for the left and right children of the current node (root.left and root.right).
5. Finally, it returns the count of uni-value subtrees.
 traverse all node when the value as same as root, count++
 
 TC: O(N) 
 SC: O(H);
 */
public class Solution {
  int count = 0;
  public int countUnivalSubtrees(TreeNode root) {
    // Write your solution here
    if(root == null) return 0;
    if(isUnival(root, root.key)){
      count++;
    }
    countUnivalSubtrees(root.left);
    countUnivalSubtrees(root.right);
    return count;
  }
  public boolean isUnival(TreeNode root, int key){
    if(root == null){
      return true;
    }
    if(root.key != key){
      return false;
    }
    return isUnival(root.left, key) && isUnival(root.right, key);
  }
}
