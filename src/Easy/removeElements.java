package Easy;

import java.lang.classfile.components.ClassPrinter;

//Problem-203
public class removeElements {
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
        public ClassPrinter.ListNode removeElements(ClassPrinter.ListNode head, int val) {
            if(head==null){
                return null;
            }
            ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(-1);
            dummy.next=head;
            ClassPrinter.ListNode curr=dummy;

            while(curr.next!=null){
                if(curr.next.val==val){
                    curr.next=curr.next.next;
                }else{
                    curr=curr.next;
                }
            }
            return dummy.next;
        }
    }
}
