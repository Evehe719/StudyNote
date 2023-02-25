108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a 
height-balanced
binary search tree.
Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

// 不断中间分割，然后递归处理左区间，右区间，也可以说是分治。 递归: 左闭右闭 [left,right]


class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
          return dfs (nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end){
        if(end < start){
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, start, mid - 1);
        root.right = dfs(nums, mid+ 1, end); 
        return root;
    }
}
