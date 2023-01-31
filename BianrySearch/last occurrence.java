Given a target integer T and an integer array A sorted in ascending order, find the index of the last occurrence of T in A or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array.

Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 3
Corner Cases

What if A is null or A is array of zero length? We should return -1 in this case.
  
  public class Solution {
  public int lastOccur(int[] array, int target) {
    // Check if the input array is valid, return -1 if the input array is invalid
    if (array == null || array.length == 0) {
      return -1;
    }

    // Initialize two pointers, left and right
    int left = 0;
    int right = array.length - 1;

    // The loop condition is left < right to make sure that we can exit the loop
    // after finding the result or it's impossible to find the result
    while (left < right) {
      // Find the mid position of the current interval
      int mid = left + (right - left) / 2;

      // If the target is greater than or equal to the mid value, we update the left pointer
      // to the mid position, which means that the target could possibly be on the right side
      if (array[mid] <= target) {
        left = mid;
      } 
      // If the target is smaller than the mid value, we update the right pointer
      // to the mid position, which means that the target could possibly be on the left side
      else {
        right = mid;
      }
    }

    // After the loop, we need to check the left and right position of the array
    // If the right position of the array is equal to the target, return right
    if (array[right] == target) {
      return right;
    }
    // If the left position of the array is equal to the target, return left
    else if (array[left] == target) {
      return left;
    }
    // If both left and right position do not contain the target, return -1
    else {
      return -1;
    }
  }
}
