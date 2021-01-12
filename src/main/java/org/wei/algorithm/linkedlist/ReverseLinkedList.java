package org.wei.algorithm.linkedlist;


import java.util.Stack;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode curr = head;
            while (curr!=null){
                ListNode nextItem = curr.next;
                curr.next = pre;
                pre = curr;
                curr=nextItem;
            }
            return pre;
        }
    }

    public static class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode(int x) { val = x; }
    }
}
