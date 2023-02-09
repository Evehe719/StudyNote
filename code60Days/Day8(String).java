344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
//双指针左右替换 用char暂存 TC: O(N), SC: O(1).
class Solution {
    public void reverseString(char[] s) {
        // l is the left pointer and r is the right pointer
        int l = 0;
        int r = s.length - 1;
        // keep swapping the characters at the pointers until the pointers meet in the middle
        while(l < r){
            // swap characters at l and r
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            // move the pointers closer to the center
            l++;
            r--;
        }
    }
}
541. Reverse String II
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

 

Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
class Solution {
    public String reverseStr(String s, int k) {
        // Convert the input string to a character array
        char[] ch = s.toCharArray();
        
        // Loop through the character array with a step of 2 * k
        for(int i = 0;i < ch.length;i += 2 * k){
            // Define the start and end indices for the reverse operation
            int start = i;
            int end = Math.min(ch.length - 1, start + k -1);
            
            // Reverse the characters between the start and end indices
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;
                start++;
                end--;
            }
        }
        // Return the reversed string
        return new String(ch);
    }
}

剑指 Offer 05. 替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."
  
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

