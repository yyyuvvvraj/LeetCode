package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-328
public class oddEvenList {
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
        public ClassPrinter.ListNode oddEvenList(ClassPrinter.ListNode head) {
            if(head==null||head.next==null||head.next.next==null){
                return head;
            }
            ClassPrinter.ListNode oddHead=head;
            ClassPrinter.ListNode evenHead=head.next;
            ClassPrinter.ListNode evenStart=evenHead;

            while(evenHead!=null&&evenHead.next!=null){
                oddHead.next=oddHead.next.next;
                evenHead.next=evenHead.next.next;

                oddHead=oddHead.next;
                evenHead=evenHead.next;
            }
            oddHead.next=evenStart;
            return head;
        }
    }
}
