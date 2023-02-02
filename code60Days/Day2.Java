977. Squares of a Sorted Array
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

class Solution {
    public int[] sortedSquares(int[] nums) {
        // initialize pointers to the start and end of the array
        int l = 0;
        int r = nums.length - 1;
        // initialize result array with the same length as the input array
        int[] res = new int[nums.length];
        // initialize a pointer to the end of the result array
        int j = nums.length - 1;
        
        // while the two pointers have not crossed each other
        while (l <= r) {
            // if square of the element pointed to by l is greater
            if (Math.pow(nums[l], 2) > Math.pow(nums[r], 2)) {
                // add it to the result array
                res[j--] = (int) Math.pow(nums[l++], 2);
            } else {
                // if square of the element pointed to by r is greater
                // add it to the result array
                res[j--] = (int) Math.pow(nums[r--], 2);
            }
        }
        
        // return the sorted result array
        return res;
    }
}

209. Minimum Size Subarray Sum ( not really good today, must review tomorrow)

Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // left pointer
        int left = 0;
        // running sum of elements between left and right pointers
        int sum = 0;
        // minimum length of subarray with sum >= target
        int res = Integer.MAX_VALUE;
        
        // right pointer
        for(int right = 0; right < nums.length; right++){
            // add current element to the running sum
            sum += nums[right];
            
            // while the running sum is greater than or equal to target
            while(sum >= target){
                // update the minimum length
                res = Math.min(res, right - left + 1);
                // decrement the running sum by subtracting the value at the left pointer
                sum -= nums[left++];
            }
        }
        
        // return 0 if no subarray with sum >= target was found, else return minimum length
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

59. Spiral Matrix II
// TBH I do not llike matrix question
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.


Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

1 2 3
8 9 4
7 6 5

Input: n = 1
Output: [[1]]

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int col_start = 0, col_end = n - 1;
        int row_start = 0, row_end = n - 1;
        int element = 1;
        while(col_start <= col_end && row_start <= row_end) {
            //top
            for(int j = col_start; j <= col_end; j++) {
                matrix[row_start][j] = element++;
            }
             
            // right side
            for(int i = row_start + 1; i <= row_end; i++) {
                matrix[i][col_end] = element++;
            }
            
            //bottom side
            for(int j = col_end - 1; j >= col_start; j--) {
                matrix[row_end][j] = element++;
            }
            
            //left side
            for(int i = row_end - 1; i > row_start; i--) {
                matrix[i][col_start] = element++;
            }
            
            col_start++;
            col_end--;
            row_start++;
            row_end--;
        }
        return matrix;
    }
}
