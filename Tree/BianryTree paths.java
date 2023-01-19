Given a binary tree, return all root-to-leaf paths from left to right.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]



to solve this problem is to use a depth-first search (DFS) traversal of the binary tree, 
and keep track of the current path as a string. 
When a leaf node is reached, the current path string is added to the list of paths. 
When backtracking, the last node in the path string is removed.

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
  Attention: res.toArray(new String[paths.size()]) to convert the list of paths to an array of strings.
  TC: O(N), SC: O(H)
 */
 
public class Solution {
  public String[] binaryTreePaths(TreeNode root) {
    // Write your solution here
    List<String> res = new ArrayList<>();
    if(root == null){
      return new String[0];
    }
    dfs(root,"", res);
    return res.toArray(new String[res.size()]);
  }

  public void dfs(TreeNode root, String path, List<String> res){
    if(root == null){
      return;
    }
    path += root.key;
    if(root.left == null && root.right == null){
      res.add(path);
      return;
    }
    path += "->";
    dfs(root.left, path, res);
    dfs(root.right, path, res);
  }
}
