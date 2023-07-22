1. Two Sum
Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
//使用了哈希映射来实现快速查找，TC: O(n) SC: O(n)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 检查输入数组是否为空
        if(nums == null || nums.length == 0){
            return res;
        }
        //creat a new map to store the index and value traversed
        Map<Integer, Integer> record = new HashMap<>();
        //traversal the nums and find is there paired answer
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            //if found
            if(record.containsKey(temp)){
                //因为第一个元素肯定已经加了所以当前的是第一个以后的元素所以是答案的第二位
                res[1] = i;
                res[0] = record.get(temp);
                break;
            }
            //if not add to map
            record.put(nums[i], i);
        }
        return res;
    }
}

454. 4Sum II
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 

Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1
给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。

例如:

输入:

A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
输出:

2

解释:

两个元组如下:

(0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
(1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

  public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 初始化结果
        int res = 0;

        // 创建一个映射来记录数组nums1和nums2中元素之和的出现次数
        Map<Integer, Integer> map = new HashMap<>();

        // 对数组nums1和nums2进行双重遍历，计算所有可能的元素之和
        for(int i : nums1){
            for(int j : nums2){
                // 计算和
                int sum = i + j;
                // 如果这个和在映射中已经存在，那么获取当前值并加1，否则直接存入1
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // 对数组nums3和nums4进行双重遍历，计算所有可能的元素之和的负数是否在映射中
        for(int i : nums3){
            for(int j : nums4){
                // 从映射中获取当前负和的出现次数（如果没有则为0），然后加到结果上
                res += map.getOrDefault(0 - i - j, 0);
            }
        }

        // 返回结果
        return res;
    }
}
SC: O(n^2)
TC: O(N^2)
