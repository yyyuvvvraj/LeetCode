package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-19
public class removeNthFromEnd {
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
        public ClassPrinter.ListNode removeNthFromEnd(ClassPrinter.ListNode head, int n) {
            if(head==null){
                return null;
            }
            ClassPrinter.ListNode fast=head;
            ClassPrinter.ListNode slow=head;

            while(n>0){
                fast=fast.next;
                n--;
            }
            if(fast==null){
                return head.next;
            }
            while(fast.next!=null){
                fast=fast.next;
                slow=slow.next;
            }
            slow.next=slow.next.next;
            return head;
        }
    }
}
