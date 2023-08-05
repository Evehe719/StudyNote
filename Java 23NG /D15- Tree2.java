102. Binary Tree Level Order Traversal
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
通过一个 while 循环控制从上向下一层层遍历，for 循环控制每一层从左向右遍历：

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        // store res
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        //travsel level to level
        while(!q.isEmpty()){
            int levelSize = q.size();
            //store all of the node in this level
            List<Integer> curLevel = new LinkedList<>();
            //for loop to go through all node in this level
            for(int i = 0; i <levelSize; i++){
                TreeNode node = q.poll();
                curLevel.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }if(node.right != null){
                    q.offer(node.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}

226. Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:
Input: root = []
Output: []

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
    // 定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        // 利用函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 然后交换左右子节点
        root.left = right;
        root.right = left;
        // 和定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }
}

101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Example 1:
Input: root = [1,2,2,3,4,4,3]
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
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，树在定义上是对称的
        if (root == null) {
            return true;
        }
        
        // 调用辅助函数来比较左子树和右子树
        return compare(root.left, root.right);
    }
    
    public boolean compare(TreeNode left, TreeNode right) {
        // 如果左右子树都为空，它们是对称的
        if (left == null && right == null) {
            return true;
        }
        // 如果一个子树为空而另一个不为空，它们不对称
        else if (left == null || right == null) {
            return false;
        }
        // 如果左右节点的值不相等，它们不对称
        else if (left.val != right.val) {
            return false;
        }

        // 比较外侧（left.left, right.right）和内侧（left.right, right.left）子树
        // 递归地检查子树是否对称
        boolean compareOut = compare(left.left, right.right);
        boolean compareIn = compare(left.right, right.left);
        
        // 当且仅当外侧和内侧子树都对称时，树才对称
        return compareOut && compareIn;
    }
}
