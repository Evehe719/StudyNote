78. Subsets
Medium
13.7K
194
Companies
Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

class Solution {
    //记录答案（存放符合条件结果的集合）
    List<List<Integer>> res = new ArrayList<>();
    // 记录走过的路径（用来存放符合条件结果）
    List<Integer> curSet = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, curSet, res);
        return res;
    }

    public void backtracking(int[] nums, int index, List<Integer> curSet, List<List<Integer>> res){
        //遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        res.add(new ArrayList<>(curSet));
        for(int i = index; i < nums.length; i++){
            curSet.add(nums[i]);//选择
            backtracking(nums, i+1, curSet, res);//回溯
            curSet.remove(curSet.size() - 1);//撤销选择
        }
    }
}
90. Subsets II
Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

注意去重！
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
  
    public List<List<Integer>> subsetsWithDup( int[] nums ) {
        Arrays.sort( nums );
        subsetsWithDupHelper( nums, 0 );
        return res;
  }


    private void subsetsWithDupHelper( int[] nums, int start ) {
        res.add( new ArrayList<>( path ) );

        for ( int i = start; i < nums.length; i++ ) {
            // 跳过当前树层使用过的、相同的元素
        if ( i > start && nums[i - 1] == nums[i] ) {
            continue;
        }
        path.add( nums[i] );
        subsetsWithDupHelper( nums, i + 1 );
        path.removeLast();
        }
  }
}
