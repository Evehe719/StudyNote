Post-order Traversal Of Binary Tree (iterative)
  Implement an iterative, post-order traversal of a given binary tree, return the list of keys of each node in the tree as it is post-order traversed.

Examples

        5

      /    \

    3        8

  /   \        \

1      4        11

Post-order traversal is [1, 4, 3, 11, 8, 5]

Corner Cases

What if the given binary tree is null? Return an empty list in this case.
How is the binary tree represented?

We use the level order traversal sequence with a special symbol "#" denoting the null node.

For Example:

The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

    1

  /   \

 2     3

      /

    4

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
Slousion:
1. Use a stack to store traversed nodes.
2. The left subtree is first traversed and the traversed node is pushed onto the stack.
   Traverse the right subtree and push the traversed nodes onto the stack.
   Finally, the root node is traversed, and the traversed node is pushed onto the stack.
3. The stack storage node out of the stack operation, access these nodes in turn

TC O(n), SC O(n);
 */
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
    // Write your solution here
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    while (current != null || !stack.isEmpty()) {
      if (current != null) {
          stack.push(current);
          current = current.left;
      }else{
        TreeNode temp = stack.peek().right;
        if (temp == null) {
            temp = stack.pop();
            result.add(temp.key);
            while (!stack.isEmpty() && temp == stack.peek().right) {
                temp = stack.pop();
                result.add(temp.key);
            }
        } else {
            current = temp;
        }
      }
    }
    return result;
  }
}
