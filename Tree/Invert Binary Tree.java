449. Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 /**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
递归算法的思路是：

1. 首先判断根节点是否为空，如果为空直接返回。
2. 交换根节点的左右子树。
3. 递归地翻转根节点的左子树和右子树。
*/
  
public class Solution {
  public TreeNode invertTree(TreeNode root) {
    // Write your solution here
    if(root == null){
      return null;
    }
    TreeNode left = root.left;
    root.left = root.right;
    root.right = left;
    invertTree(root.left);
    invertTree(root.right);

    return root;
  }
}
