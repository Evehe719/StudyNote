Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K. Notice that each subset returned will be sorted for deduplication.



Assumptions

There could be duplicate characters in the original set.

​

Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "abb", K = 2, all the subsets are [“ab”, “bb”].

Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

Set = null, K = 0, all the subsets are [].
  
//
使用递归方法来寻找一个给定集合的所有子集。检查，以确保每个子集的大小都等于k。

1.首先初始化一个空列表来存储子集，并处理输入集为空或k小于0或大于集的长度的边缘情况。

2. 然后，将输入的字符串转换为char数组，并对其进行排序，这将有助于我们以后对子集进行重复计算。

3.当前子集的长度等于k时，在这种情况下我们将子集添加到res中。如果index到达数组的末端，返回。

4. 在递归的情况下，我们首先考虑的是挑选当前的字符，并通过将其追加到StringBuilder中，将其添加到当前的子集。
然后，我们通过再次调用findSubset方法，用更新的参数，转到下一个索引。

5. 之后，当回溯到上一级时，我们需要通过调用sb.deleteCharAt(sb.length()-1)来删除添加的字符.

TC: O(2^n), SC: O(n);
//
public class Solution {
  public List<String> subSetsIIOfSizeK(String set, int k) {
    // Initialize an empty list to store the subsets
    List<String> result = new ArrayList<>();
    
    // Edge case: if the input set is null or k is less than 0 or greater than the length of the set, return an empty list
    if (set == null || k < 0 || k > set.length()) {
      return result;
    }
    
    // Convert the input string to a char array for easier traversal
    char[] arraySet = set.toCharArray();
    Arrays.sort(arraySet);  //sort the array to deduplicate the subsets
    StringBuilder sb = new StringBuilder(); // SB to record the current subset
    findSubset(arraySet, sb, 0, k, result);
    return result;
  }

  private void findSubset(char[] set, StringBuilder sb, int index, int k, List<String>result){
    // when we finished pick/NP for all characters ----> have a complete subset.
    if(sb.length() == k){
      result.add(sb.toString());
      return;
    }
    if(index == set.length){
      return;
    }
    findSubset(set, sb.append(set[index]), index+1, k, result); //pick at index
    sb.deleteCharAt(sb.length()-1);    // remove the added character when backtracking to perivous level
    while (index + 1 < set.length && set[index] == set[index + 1]) { //skip the duplicates
        index++;
    }
    findSubset(set, sb, index+1, k, result); 
  }
}
