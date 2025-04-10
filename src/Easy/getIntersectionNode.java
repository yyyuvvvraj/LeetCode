package Easy;

import java.lang.classfile.components.ClassPrinter;

//Problem-160
public class getIntersectionNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public int sizeLL(ClassPrinter.ListNode head){
            int count = 0;
            ClassPrinter.ListNode ptr=head;
            while(ptr!=null){
                count++;
                ptr=ptr.next;
            }
            return count;
        }
        public ClassPrinter.ListNode getIntersectionNode(ClassPrinter.ListNode headA, ClassPrinter.ListNode headB) {
            if(headA==null||headB==null){
                return null;
            }
            int size1=sizeLL(headA);
            int size2=sizeLL(headB);
            int diff=size1-size2;
            ClassPrinter.ListNode ptr1=headA;
            ClassPrinter.ListNode ptr2=headB;
            if(diff>0){
                while(diff>0){
                    ptr1=ptr1.next;
                    diff--;
                }
            }else{
                while(diff<0){
                    ptr2=ptr2.next;
                    diff++;
                }
            }
            while(ptr1!=ptr2){
                ptr1=ptr1.next;
                ptr2=ptr2.next;
            }
            return ptr1;
        }
    }
}
