Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.

Assumptions

There is parent pointer for the nodes in the binary tree

The given two nodes are not guaranteed to be in the binary tree

Examples

        5

      /   \

     9     12

   /  \      \

  2    3      14

The lowest common ancestor of 2 and 14 is 5

The lowest common ancestor of 2 and 9 is 9

The lowest common ancestor of 2 and 8 is null (8 is not in the tree)

/**
 * public class TreeNodeP {
 *   public int key;
 *   public TreeNodeP left;
 *   public TreeNodeP right;
 *   public TreeNodeP parent;
 *   public TreeNodeP(int key, TreeNodeP parent) {
 *     this.key = key;
 *     this.parent = parent;
 *   }
 * }
 Sloution:
1. find the depth of each node by following the parent pointers starting 
   from the given node, counting the number of steps.
2. move the deeper node up to the same level as the shallower node 
  by following the parent pointers the number of steps equal to the difference in depth between the two nodes.
3. iterate up the tree from both nodes at the same time, following the parent pointers, 
  until we find a common ancestor, which is the first node that the two pointers point to at the same time.

  TC: O(D) D means depth
  SC: O(1)
 */
public class Solution {
  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
    // Write your solution here.
    // Find the depth of each node

    int depth1 = getDepth(one);
    int depth2 = getDepth(two);
    // Move the deeper node up to the same level as the shallower node
    if(depth1 > depth2){
      for(int i = 0; i < depth1 - depth2; i++){
        one = one.parent;
      }
    }else{
      for(int i = 0; i < depth2 - depth1; i++){
        two = two.parent;
      }
    }
    // Iterate up the tree from both nodes and find the first common ancestor
    while(one != two){
      one = one.parent;
      two = two.parent;
    }
    return one;
  }
  public int getDepth(TreeNodeP node){
    int depth = 0;
    while(node != null){
      depth++;
      node = node.parent;
    }
    return depth;
  }
}
