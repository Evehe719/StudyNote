学会二叉树的层序遍历，可以一口气打完以下十题：

102.二叉树的层序遍历
107.二叉树的层次遍历II
199.二叉树的右视图
637.二叉树的层平均值
429.N叉树的层序遍历
515.在每个树行中找最大值
116.填充每个节点的下一个右侧节点指针
117.填充每个节点的下一个右侧节点指针II
104.二叉树的最大深度
111.二叉树的最小深度

102
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        //to hold res
        List<List<Integer>> res = new ArrayList<>();
        //to hold the node need to process
        Queue<TreeNode> queue = new LinkedList<>();
        //if rootnode not null add to the queue
        if(root != null) queue.add(root);
        //process the node in the queue until done
        while(!queue.isEmpty()){
            //get the current level's nood 
            int levelSize = queue.size();
            //to hod the val of node in curlevel
            List<Integer> level = new ArrayList<>(levelSize);
            //process all the node in cur level
            for(int i = 0; i < levelSize; i++){
                // remove the first node in queue
                TreeNode cur = queue.poll();
                //add the left and right child of the current node to the queue (if they exist)
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                level.add(cur.val);
            }
            // Add the list for the current level to the result list
            res.add(level);
        }
        return res;
    }
}

107. Binary Tree Level Order Traversal II
//相对于102.二叉树的层序遍历，就是最后把result数组反转一下就可以了。
Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root).
  
Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[15,7],[9,20],[3]]
Example 2:

Input: root = [1]
Output: [[1]]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
     //to hold res in list
        List<List<Integer>> list = new ArrayList<>();
        //to hold the node need to process
        Queue<TreeNode> queue = new LinkedList<>();
        //if rootnode not null add to the queue
        if(root != null) queue.add(root);
        //process the node in the queue until done
        while(!queue.isEmpty()){
            //get the current level's nood 
            int levelSize = queue.size();
            //to hod the val of node in curlevel
            List<Integer> level = new ArrayList<>(levelSize);
            //process all the node in cur level
            for(int i = 0; i < levelSize; i++){
                // remove the first node in queue
                TreeNode cur = queue.poll();
                //add the left and right child of the current node to the queue (if they exist)
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
                level.add(cur.val);
            }
            // Add the list for the current level to the result list
            list.add(level);
        }
        // new a ArrayList to hold res
        List<List<Integer>> result = new ArrayList<>();
        // reverse the list of res 
        for (int i = list.size() - 1; i >= 0; i-- ) {
            result.add(list.get(i));
        }

        return result;
    }
}
 
