344. Reverse String
  Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
双指针用一个temp hold
class Solution {
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while( i < j){
           // Swap the characters at the left and right positions.
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
}

541. Reverse String II
  Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"
  
class Solution {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for(int i = 0; i < n; i += 2 * k){
            int start = i;
            int end = Math.min(i + k - 1, n - 1);

            while(start < end){
                char temp = charArray[start];
                charArray[start] = charArray[end];
                charArray[end] = temp;
                start++;
                end--;
            }
        }
    return new String(charArray);
    }
}
