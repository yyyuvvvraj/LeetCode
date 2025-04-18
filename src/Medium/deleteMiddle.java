package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-2095
public class deleteMiddle {
    public ClassPrinter.ListNode deleteMiddle(ClassPrinter.ListNode head) {
        if(head.next==null){
            return null;
        }
        ClassPrinter.ListNode fast=head;
        ClassPrinter.ListNode slow=head;
        ClassPrinter.ListNode pre=slow;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=pre.next.next;
        return head;
    }
}
