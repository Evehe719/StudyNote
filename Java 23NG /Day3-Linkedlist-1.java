203. Remove Linked List Elements
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []

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
    public ListNode removeElements(ListNode head, int val) {
        // while循环用于处理头结点为val的情况
        while(head != null && head.val == val){
            head = head.next;
        }
        // 已经是null，则返回结束
        if(head == null){
            return head;
        }
        // pre指向当前节点的前一个节点，cur指向当前节点
        ListNode pre = head;
        ListNode cur = head.next;
         // traverse the list and remove nodes with value equal to val
        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        // 返回链表的头结点
        return head;
    }
}
707. Design Linked List
//周末着重复习这个
  class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
}

class MyLinkedList {
    int size;
    ListNode head;
    //初始化链表
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    //获取第一个index个节点的数值，index start from 0； 
    public int get(int index) {
        if(index < 0 || index >= size){
            return - 1;
        }
        ListNode currentNode = head;
        for(int i = 0; i <= index; i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
	    return;
        }
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
206. Reverse Linked List

对于递归算法，最重要的就是明确递归函数的定义。具体来说，我们的 reverse 函数定义是这样的：
输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。

  // 递归 
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
}
双指针方法更简单生动点
