704. Binary Search
二分搜索的基本形式
  class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
}

27. Remove Element
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

用counter类似于快慢指针，这种方法与快慢指针的区别在于，快慢指针通常用于解决一些特定的问题，如链表中的删除操作，而这里的计数器仅用于记录元素的个数，并没有直接修改链表结构。
class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;  // 记录不等于给定值的元素数量
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];  // 将不等于给定值的元素移动到前面
                count++;
            }
        }
        return count;  // 返回修改后数组的长度
    }
}
时间复杂度为 O(n)，其中 n 是数组的长度。空间复杂度为 O(1)，只使用了常数级别的额外空间。
