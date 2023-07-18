242. Valid Anagram
Easy
9.8K
312
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false

  class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26]; // 记录字母频率的数组，长度为26代表26个小写字母

        // 遍历字符串s，统计每个字母的出现次数
        for (int i = 0; i < s.length(); i++) {
            // 将字母s.charAt(i)在记录数组中的对应位置计数器加一
            record[s.charAt(i) - 'a']++; 
        }

        // 遍历字符串t，统计每个字母的出现次数
        for (int i = 0; i < t.length(); i++) {
            // 将字母t.charAt(i)在记录数组中的对应位置计数器减一
            record[t.charAt(i) - 'a']--; 
        }
        
        // 检查记录数组中的每个元素，如果有任何元素不为零，则说明s和t不是字母异位词，返回false
        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        
        // 所有元素都为零，说明s和t是字母异位词，返回true
        return true;
    }
}

349. Intersection of Two Arrays
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.

class Solution {
    //创建两个空的哈希集合 set1 和 resSet 分别用于存储数组 nums1 的元素和结果的交集元素。
    //第一个循环遍历 nums1 数组，将其所有元素添加到 set1 哈希集合中，以便快速查找。
    //第二个循环遍历 nums2 数组，对于每个元素 i，通过检查 set1 是否包含 i 来判断它是否是两个数组的交集元素。如果是，则将其添加到 resSet 哈希集合中。
    //最后，将 resSet 中的元素转换为数组 arr 并返回。
    class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        //traverse nums1
        for(int i : nums1){
            set1.add(i);
        }
        //traverse nums2
        for(int i : nums2){
            if(set1.contains(i)){
                resSet.add(i);
            }
        }

        //目的： 将 resSet 中的元素转换为数组形式，以便作为结果返回。
        //将 resSet 中的元素逐个存储到数组 arr 中，
        //最终，arr 数组中存储了 resSet 中的元素，并按照遍历顺序进行了存储。
        int[] arr = new int[resSet.size()];
        int j = 0;
        //遍历 resSet 中的元
        //将变量 i 的值赋给数组 arr 的第 j 个位置，然后 j 自增，用于指示下一个要存储元素的位置
        for(int i : resSet){
            arr[j] = i;
            j++;
        }
        return arr;
    }
}


202. Happy Number
Easy
9.1K
1.2K
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false

  class Solution {
    /*
    使用了一个哈希集合 seen 来存储已经出现过的数字，用于检测循环。 
    在一个循环中，不断计算当前数字的平方和，并更新 n 的值。
    如果 n 的值变为 1，则说明是快乐数，返回 true。
    如果 n 的值已经在哈希集合 seen 中出现过（形成了循环），则退出循环，并返回 false。
    如果既不是循环也不是快乐数，继续进行下一轮循环。
    */
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) { // 进入循环，直到 n 为 1 或 n 在 seen 集合中出现过
            seen.add(n); // 将当前的 n 加入 seen 集合中，用于检测循环
            n = calculateSumOfSquare(n); // 计算 n 的平方和，并更新 n 的值
        }

        return n == 1; // 如果 n 最终为 1，则是快乐数；否则不是快乐数
    }

    // 计算一个数字的平方和
    private int calculateSumOfSquare(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10; // 取出当前位的数字
            sum += digit * digit; // 将该数字的平方加到总和中
            n /= 10; // 去掉当前位数字，继续处理下一位
        }
        return sum; // 返回平方和
    }
}
