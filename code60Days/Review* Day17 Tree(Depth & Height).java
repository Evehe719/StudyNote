110. Balanced Binary Tree

Given a binary tree, determine if it is 
height-balanced
Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //height - postOrder ; depth: preOrder 
  
class Solution {
    public boolean isBalanced(TreeNode root) {
     if(root == null){
      return true;
    }
    int leftHeight = getHeight(root.left);
    int rightHeight = getHeight(root.right);
    if(Math.abs(leftHeight - rightHeight) > 1){
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right); 
  }
  
  public int getHeight(TreeNode root){
  if(root == null){
    return 0;
    }
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
}

257. Binary Tree Paths
Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]

/**
1. 递归函数参数以及返回值
要传入根节点，记录每一条路径的path，和存放结果集的result，这里递归不需要返回值
2. 确定递归终止条件
本题要找到叶子节点，就开始结束的处理逻辑了（把路径放进result里）。
那么什么时候算是找到了叶子节点？ 是当 cur不为空，其左右孩子都为空的时候，就找到叶子节点。
所以本题的终止条件是：
if (cur->left == NULL && cur->right == NULL) {
    终止处理逻辑
}


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        //store the res
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        //as the path of res
        List<Integer> paths = new ArrayList<>();
        traversal(root, paths, res);
        return res;
    }
    public void traversal(TreeNode root, List<Integer> paths, List<String> res){
        paths.add(root.val);
        if(root.left == null && root.right == null){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < paths.size() - 1; i++){
                sb.append(paths.get(i)).append("->");
            }
            sb.append(paths.get(paths.size() - 1));
            res.add(sb.toString());
            return;
        }
         // 递归和回溯是同时进行，所以要放在同一个花括号里
        if (root.left != null) { // 左
            traversal(root.left, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
        if (root.right != null) { // 右
            traversal(root.right, paths, res);
            paths.remove(paths.size() - 1);// 回溯
        }
    }
}

404. Sum of Left Leaves

Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

 

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
Example 2:

Input: root = [1]
Output: 0
  
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int mid = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            mid = root.left.val;
        }
        int sum = mid + leftValue + rightValue;
        return sum;
    }
}
//  还不太明白sum 明天复习一下
