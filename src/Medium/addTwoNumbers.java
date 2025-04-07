package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-2
public class addTwoNumbers {
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
        public ClassPrinter.ListNode addTwoNumbers(ClassPrinter.ListNode l1, ClassPrinter.ListNode l2) {
            if(l1==null){
                return l2;
            }else if(l2==null){
                return l1;
            }
            ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(-1);
            ClassPrinter.ListNode ans=dummy;

            ClassPrinter.ListNode ptr1=l1;
            ClassPrinter.ListNode ptr2=l2;
            int carry=0;

            while(ptr1!=null||ptr2!=null){
                int val1=ptr1!=null?ptr1.val:0;
                int val2=ptr2!=null?ptr2.val:0;
                int sum=val1+val2+carry;

                int d=sum%10;
                carry=sum/10;

                ClassPrinter.ListNode temp=new ClassPrinter.ListNode(d);

                dummy.next=temp;
                dummy=dummy.next;

                ptr1=ptr1!=null?ptr1.next:null;
                ptr2=ptr2!=null?ptr2.next:null;
            }
            if(carry>0){
                ClassPrinter.ListNode temp=new ClassPrinter.ListNode(carry);
                dummy.next=temp;
                dummy=dummy.next;
            }
            return ans.next;
        }
    }
}
