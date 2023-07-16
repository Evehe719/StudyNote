24. Swap Nodes in Pairs
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
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //输入以 head 开头的单链表，将这个单链表中的每两个元素翻转，
        if(head == null || head.next == null){
            return head;
        }
        ListNodeL first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        second.next = first;
        swapPairs()
    }
}
