package Easy;

import java.lang.classfile.components.ClassPrinter;

//Problem-21
public class mergeTwoLists {
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
        public ClassPrinter.ListNode mergeTwoLists(ClassPrinter.ListNode list1, ClassPrinter.ListNode list2) {
            ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(-1);
            ClassPrinter.ListNode ans=dummy;
            ClassPrinter.ListNode ptr1=list1;
            ClassPrinter.ListNode ptr2=list2;

            while(ptr1!=null && ptr2!=null){
                if(ptr1.val<ptr2.val){
                    dummy.next=ptr1;
                    ptr1=ptr1.next;
                }else{
                    dummy.next=ptr2;
                    ptr2=ptr2.next;
                }
                dummy=dummy.next;
            }
            if(ptr1==null){
                dummy.next=ptr2;
            }else{
                dummy.next=ptr1;
            }
            return ans.next;
        }
    }
}
