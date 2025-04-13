package Easy;

import java.lang.classfile.components.ClassPrinter;

//Problem-141
public class hasCycle {
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
        public boolean hasCycle(ClassPrinter.ListNode head) {
            if(head==null||head.next==null){
                return false;
            }
            ClassPrinter.ListNode slow=head;
            ClassPrinter.ListNode fast=head;
            while(fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
                if(fast==slow){
                    return true;
                }
            }
            return false;
        }
    }
}
