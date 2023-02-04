24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
This solution uses a recursive approach to swap every two adjacent nodes in a linked list.

Here's how it works:

1. Edge cases: If the linked list is empty or has only one node, 
the function returns the head as is, because there's nothing to swap.

2. Get the next node for the current node: The next node is stored in a variable next.

3. Recursion: The function calls itself on the rest of the linked list, by passing next.next as the new head. 
The result of this call will be stored in the variable newNode. 
This will continue until all nodes have been processed, and eventually, the function will return the new head of the linked list.

4. Swap the values of the current node and the next node: 
   The current node head will point to the new node newNode, and the next node next will point to the current node head.

5. Return the next node as the new head of the linked list: The function returns the next node, which is now the head of the linked list.
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        // Edge case: If the linked list is empty or has only one node, return the head as is
        if(head == null || head.next == null) return head;

        // Get the next node for the current node
        ListNode next = head.next;

        // Recursively call the `swapPairs` function for the rest of the linked list
        ListNode newNode = swapPairs(next.next);

        // Swap the values of the current node and the next node
        next.next = head;
        head.next = newNode;

        // Return the next node as the new head of the linked list
        return next;
    }
}


19. Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 主函数
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}

