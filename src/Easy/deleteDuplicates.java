package Easy;

import java.lang.classfile.components.ClassPrinter;

//Problem-83
public class deleteDuplicates {
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
        public ClassPrinter.ListNode deleteDuplicates(ClassPrinter.ListNode head) {
            if(head==null || head.next==null){
                return head;
            }
            ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(head.val);
            ClassPrinter.ListNode ans=dummy;
            ClassPrinter.ListNode ptr=head.next;
            while(ptr!=null){
                if(ptr.val!=dummy.val){
                    ClassPrinter.ListNode temp=new ClassPrinter.ListNode(ptr.val);
                    dummy.next=temp;
                    dummy=dummy.next;
                }
                ptr=ptr.next;
            }
            return ans;
        }
    }
}
