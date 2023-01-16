/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *   this.key = key;
 *   }
 * }
 Solution: 
 To solve this problem is using recursion. 
 This is the classical method and is straightforward. 
 We can define a helper function to implement recursion.
 TC: O(n); SC: O(n);
 
 Sloution2 is similer like method 1 but using stack.
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

Method 2:
public class Solution{
	public List<Integer> inOrder(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while(cur != null || !stack.isEmpty()){
			while(cur != null){
			stack.push(cur);
			cur = cur.left;
			}
			cur = stack.pop();
			res.add(cur.key);
			cur = cur.right;
		}
		return res;
	}
}
