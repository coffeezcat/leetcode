package org.wei.algorithm;

/**
 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * */
public class TwoNumSum {

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(6),l1_2= new ListNode(4),l1_3= new ListNode(3);
        //l1_1.next = l1_2;
        //l1_2.next = l1_3;
        ListNode l2_1 = new ListNode(5),l2_2= new ListNode(9),l2_3= new ListNode(4),l2_4= new ListNode(5);
        l2_1.next = l2_2;
        //l2_2.next = l2_3;
        //l2_3.next = l2_4;

        Solution solution = new Solution();
        solution.print(solution.addTwoNumbers(l1_1,l2_1));

    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode res =null,next=null;
            int curr = 0;
            int intL1 =0,intL2=0;
            while (l1!=null||l2!=null||curr!=0){
                if(l1!=null){
                    intL1=l1.val;
                }
                if(l2!=null){
                    intL2=l2.val;
                }

                int sum = intL1+intL2+curr;
                if(res==null){
                    res = new ListNode(sum%10);
                    next=res;
                }else{
                    next.next = new ListNode(sum%10);
                    next=next.next;
                }
                curr = sum/10;
                l1 = l1==null?null:l1.next;
                l2 = l2==null?null:l2.next;
                intL1 =0;
                intL2=0;
            }
            return res;
        }

        public void print(ListNode node){
            while (node!=null){
                System.out.print(node.val+"->");
                node = node.next;
            }
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
