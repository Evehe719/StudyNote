There are bugs in the given code, please fix them.

Given a target integer T and an integer array A sorted in ascending order, find the index of the first occurrence of T in A or return -1 if there is no such index.

Assumptions

There can be duplicate elements in the array.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 2, 3}, T = 4, return -1
A = {1, 2, 2, 2, 3}, T = 2, return 1
Corner Cases

What if A is null or A of zero length? We should return -1 in this case.

1.
public class Solution {
  // Returns the index of the first occurrence of target in array.
  // If target is not found, returns -1.
  public int firstOccur(int[] array, int target) {
    // Check if the array is null or has zero length
    if (array == null || array.length == 0) {
      return -1;
    }
    int left = 0;
    int right = array.length - 1;
    // Keep looping until left and right pointers are adjacent
    while (left < right - 1) {
      int mid = left + (right - left) / 2;
      // If target is less than or equal to the value at mid, move the right pointer to mid
      if (array[mid] >= target) {
        right = mid;
      }
      // Otherwise, move the left pointer to mid
      else {
        left = mid;
      }
    }
    // Check if the target value is found at the left or right index
    if (array[left] == target) {
      return left;
    }
    if (array[right] == target) {
      return right;
    }
    // If target is not found, return -1
    return -1;
  }
}


2. 
public class Solution {
  public int firstOccur(int[] array, int target) {
    // Check if the input array is null or has a length of 0
    if (array == null || array.length == 0) {
      // Return -1 if the array is null or has a length of 0
      return -1;
    }
    // Set the initial left and right pointers
    int left = 0;
    int right = array.length - 1;
    // Repeat until the left pointer is not less than the right pointer
    while (left < right) {
      // Calculate the midpoint
      int mid = (right - left) / 2 + left;
      // If the midpoint element is greater than or equal to the target
      if (array[mid] >= target) {
        // Move the right pointer to the midpoint
        right = mid;
      } else {
        // Move the left pointer to the midpoint + 1
        left = mid + 1;
      }
    }
    // Check if the left pointer points to an element that is equal to the target
    if (array[left] == target) {
      // Return the left pointer if it points to an element that is equal to the target
      return left;
    }
    // Return -1 if the target is not found
    return -1;
  }
}

  

/* TC for both solutions is O(log n), where n is the length of the input array. 
This is because both solutions use binary search to find the target element in the array, which takes O(log n) time in the worst case.
   SC for both is O(1), because it only uses a few variables to store the indices, which do not take up much memory.
*/
