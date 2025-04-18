package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-2181
public class mergeNodes {
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
        public ClassPrinter.ListNode mergeNodes(ClassPrinter.ListNode head) {
            ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(-1);
            ClassPrinter.ListNode ans=dummy;
            ClassPrinter.ListNode curr=head.next;
            int sum=0;
            while(curr!=null){
                if(curr.val!=0){
                    sum+=curr.val;
                }else{
                    ClassPrinter.ListNode temp=new ClassPrinter.ListNode(sum);
                    dummy.next=temp;
                    dummy=dummy.next;
                    sum=0;
                }
                curr=curr.next;
            }
            return ans.next;
        }
    }
}
