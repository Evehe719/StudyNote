/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *   this.key = key;
 *   }
 * }
 */
 
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    // Write your solution here
    List<Integer> res = new ArrayList<Integer>();
    helper(root, res);  
    return res;
  }

  public void helper (TreeNode root, List<Integer> res){
    if(root != null){
			helper(root.left, res);
      res.add(root.key);
      helper(root.right, res);
    }
  } 
}
