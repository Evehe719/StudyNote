459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

 

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.
  
  /*
  检查给定String s是否具有重复的subString模式。方法: 遍历重复subString的所有可能长度，并检查是否存在这样的subString。
  Time complexity of O(n^2) in the worst case, 
  as the loop goes through all possible lengths of the repeated substring and in each iteration, 
  it constructs a new string by repeating the substring, which takes O(n) time.
  */
  
  class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // Loop through possible substring lengths
        for(int i = n/2; i >= 1; i--){
            //check if the length of the string is divisible by i
            if(n % i == 0){
                // Calculate the number of times the substring 
                //is repeated to form the original string
                int m = n / i;
                //Extract the substring of length i
                String sub = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                //repeat the substring m times to form a new string
                for(int j = 0; j < m; j++){
                    sb.append(sub);
                }
                // Check if the new string is equal to the original string
                if (sb.toString().equals(s)) {
                    // Return true if it is
                    return true;
                }
            } 
        }
    return false;
    }
}

/*
there is a more efficient solution to this problem with a time complexity of O(n). 
The idea is to use KMP (Knuth-Morris-Pratt) algorithm to solve this problem.

Here's how the solution works:

1. The solution starts by concatenating the input string s with itself, excluding the first and last characters. 
This creates a new string ss that is twice the length of the original string, but with the first and last characters missing.

2. Then, the solution searches for the original string s in the new string ss using KMP algorithm.

3. If s is found in ss, it means that the original string s is a repeated substring of ss. 
In this case, the function returns true indicating that the input string has a repeated substring pattern.

4. If s is not found in ss, it means that the original string s does not have a repeated substring pattern. 
In this case, the function returns false.

The time complexity of this solution is O(n) because KMP algorithm has a time complexity of O(n). 
This solution is more efficient than the previous solution because it avoids constructing new strings by repeating substrings, which is a time-consuming process.
*/
