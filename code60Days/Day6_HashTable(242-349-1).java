242. Valid Anagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
  
/*异位词中字符出现的次数肯定都是一样的，所以可以把 s, t 中的字符计数器作为编码，比较每个字符的出现次数即可判断 s 和 t 是否是异位词。
The time complexity (TC) of this solution is O(n),where n is the length of the input string. 
The reason for this is that the solution requires two passes through the input string: 
one pass in the encode function and one pass in the isAnagram function. In each pass, the length of the string is iterated once.

The space complexity (SC) of this solution is O(1), because the size of the count array is fixed at 26, 
regardless of the length of the input string. 
The array is used to store the number of occurrences of each letter in the alphabet, so the amount of memory required is constan
*/

  class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count1 = encode(s);
        int[] count2 = encode(t);
        //for sure all chars of two string shows with same time
        for(int i = 0; i < count1.length; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }
    // Count the number of character occurrences
    public int[] encode(String s){
        int[] count = new int[26];
        // loop all char and count the occure time
        for(char c: s.toCharArray()){
            int delta = c - 'a';
            count[delta]++;
        }
        return count;
    }
}


349. Intersection of Two Arrays
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
  
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
  
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //traversal set1
        for(int i : nums1){
            set1.add(i);
        }
        //历数组2的过程中判断哈希表中是否存在该元素
        for(int i : nums2){
            if(set1.contains(i)){
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}


1. TwoSUm
/*对于一个元素 nums[i]，你想知道有没有另一个元素 nums[j] 的值为 target - nums[i]，
这很简单，我们用一个哈希表记录每个元素的值到索引的映射，这样就能快速判断数组中是否有一个值为 target - nums[i] 的元素了。

简单说，数组其实可以理解为一个「索引 -> 值」的哈希表映射，而我们又建立一个「值 -> 索引」的映射即可完成此题。
*/

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

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


class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //check is there elements and add nums[i] == target
            int need = target - nums[i];
            if(valToIndex.containsKey(need)){
                return new int[]{valToIndex.get(need), i};
            }
            //save val -> index
            valToIndex.put(nums[i], i);
        }
        return null;
    }
}
