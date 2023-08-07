104. Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

559. Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: 3
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: 5

class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        
        int maxChildDepth = 0;
        for (Node child : root.children) { // Corrected the typo "childeren" to "children"
            maxChildDepth = Math.max(maxChildDepth, maxDepth(child));
        }
        
        return maxChildDepth + 1;
    }
}

222. Count Complete Tree Nodes

Given the root of a complete binary tree, return the number of the nodes in the tree.
According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
Design an algorithm that runs in less than O(n) time complexity.

Example 1:
Input: root = [1,2,3,4,5,6]
Output: 6
Example 2:

Input: root = []
Output: 0
Example 3:

Input: root = [1]
Output: 1
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
}
当我们谈论/完全二叉树/时，可以想象成一个二叉树的样子，它有几个特点：
节点排列： 它的节点是按层级排列的，就像楼梯一样，从上到下，从左到右。所以每一层的节点数是越来越多的。
填充规则： 在这个树的最后一层，节点从左到右依次填充，没有留空。如果最后一层没有被填满，那么缺失的节点也只会在最右边。
节点数量： 如果这个树的高度是h，前面h-1层的节点数是最多的，就是2^(h-1)个节点。最后一层的节点数会比前面少一些，但至少有1个节点。
插入顺序： 在构建这样的树时，节点的插入通常是按顺序进行的，从上到下、从左到右。

可以把完全二叉树想象成一种很整齐的二叉树，特别是在节点插入的时候，总是先填满一层再往下一层填。
这种规律性使得完全二叉树在某些情况下很方便，比如在优先队列（Priority Queue）和堆（Heap）这些数据结构中使用，
因为它们需要能够高效地找到最大或最小值，而完全二叉树的结构可以帮助实现这些操作。

