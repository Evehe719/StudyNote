1047. Remove All Adjacent Duplicates In String
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"

//游戏对对碰，如果相同的元素挨在一起就要消除。1.遍历input string， for each char指针指向的 没有出现过加res里去，出现一样的————删除。
//(TC) : O(n), where n is the length of the input string. This is because the solution iterates over each character in the string once.
//(SC): O(n), uses a StringBuffer object to store the result, and the length of this object can be as long as the input string in the worst case. 



class Solution {

    public String removeDuplicates(String s) {
        // Create a StringBuffer object to store the result
        StringBuffer res = new StringBuffer();
        
        // Initialize a variable "top" to represent the length of the res
        int top = -1;
        
        // Iterate over each character in the input string
        for(int i = 0; i < s.length(); i++){
            // Get the current character
            char ch = s.charAt(i);
            
            // If "top" is greater than or equal to 0, and the last character in the result is equal to the current character
            if(top >= 0 && res.charAt(top) == ch){
                // Remove the last character from the result
                res.deleteCharAt(top);
                
                // Decrement "top" to reflect the change in the result
                top--;
            }
            // If the last character in the result is not equal to the current character
            else{
                // Add the current character to the result
                res.append(ch);
                
                // Increment "top" to reflect the change in the result
                top++;
            }
        }
        
        // Return the result as a string
        return res.toString();
    }
}

150. Evaluate Reverse Polish Notation
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
/*
SLoution: 按顺序遍历逆波兰表达式中的字符，如果是数字，则放入栈；如果是运算符，则将栈顶的两个元素拿出来进行运算，再将结果放入栈。
          对于减法和除法，运算顺序attention，栈顶第二个数是被除（减）数。
          直接按照运算规则借助栈计算表达式结果即可。
          TC: O(N), SC: O(N).
*/

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        // Iterate over the elements in the tokens array
        for (String token : tokens) {
            // If the current token is "+", it represents the addition operator
            if ("+".equals(token)) {
                // Pop the top two elements from the stack, add them, and push the result back onto the stack
                stack.push(stack.pop() + stack.pop());
            } 
            // If the current token is "-", it represents the subtraction operator
            else if ("-".equals(token)) {
                // Pop the top two elements from the stack, subtract the second popped element from the first, and push the result back onto the stack
                int temp2 = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp1 - temp2);
            } 
            // If the current token is "*", it represents the multiplication operator
            else if ("*".equals(token)) {
                // Pop the top two elements from the stack, multiply them, and push the result back onto the stack
                stack.push(stack.pop() * stack.pop());
            } 
            // If the current token is "/", it represents the division operator
            else if ("/".equals(token)) {
                // Pop the top two elements from the stack, divide the first popped element by the second, and push the result back onto the stack
                int temp2 = stack.pop();
                int temp1 = stack.pop();
                stack.push(temp1 / temp2);
            } 
            // If the current token is not an operator, it represents an operand (i.e., a number)
            else {
                // Convert the token to an integer and push it onto the stack
                stack.push(Integer.valueOf(token));
            }
        }
        
        // Return the final result, which is stored at the top of the stack
        return stack.pop();
    }
}

