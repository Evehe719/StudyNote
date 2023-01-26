Given a binary tree, delete the nodes only if it is 0 and all the nodes on the paths from the node to any leaf nodes are all 0.

In another word, delete the leaf nodes with 0 recursively until there are no such nodes in the tree.

You only need to return the final tree after deletion.

Examples:

          0
        /    \
       0      3
      / \    / \
     0   0   0  7
    /            \
    0             0

     \

      0

After first round, deleting all the leaf nodes with 0, the tree becomes:

          0
        /   \
       0     3
      /     / \
     0     0   7
    /
   0

After second round, deleting all the leaf nodes with 0, the tree becomes:

          0
        /   \
       0     3
      /       \
     0         7

After third round, deleting all the leaf nodes with 0, the tree becomds:

          0
        /   \
       0     3
              \
               7

After another round, deleting all the leaf nodes with 0, the tree becomds:

          0
           \
            3
             \
              7   

The deletion end at this step since there are no more nodes to delete.

You only need to return the final binary tree after deletion.
            
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 One approach to solving this problem is to use a post-order traversal of the tree, 
 where we first recursively delete the left and right subtrees, 
 then check if the current node should be deleted based on the condition given. 
 If the current node should be deleted, we return null, otherwise we return the node itself.


 */
public class Solution {
  public TreeNode deleteZero(TreeNode root) {
    // Write your solution here
    if(root == null) return null;
    // recursively delete the left and right subtrees
    root.left = deleteZero(root.left);
    root.right = deleteZero(root.right);
    // check if the current node should be deleted
    if(root.key == 0 && root.left == null && root.right == null){
      // if the current node is a leaf node with value 0, set it to null
      return null;
    }
    // otherwise, keep the current node in the tree
    return root;
  }
}
