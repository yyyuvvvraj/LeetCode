package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-142
public class detectCycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ClassPrinter.ListNode detectCycle(ClassPrinter.ListNode head) {
            if(head==null){
                return null;
            }
            ClassPrinter.ListNode fast=head;
            ClassPrinter.ListNode slow=head;
            ClassPrinter.ListNode ptr=head;
            while(fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(slow==fast){
                    while(ptr!=slow){
                        ptr=ptr.next;
                        slow=slow.next;
                    }
                    return ptr;
                }
            }
            return null;
        }
    }
}
