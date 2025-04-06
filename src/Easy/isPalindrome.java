package Easy;

import java.lang.classfile.components.ClassPrinter;
import java.util.Stack;

//Problem-234
public class isPalindrome {
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
        public boolean isPalindrome(ClassPrinter.ListNode head) {
            Stack<Integer> st=new Stack<>();
            ClassPrinter.ListNode ptr=head;
            while(ptr!=null){
                st.push(ptr.val);
                ptr=ptr.next;
            }
            ClassPrinter.ListNode ptr2=head;
            while(ptr2!=null){
                int val1=ptr2.val;
                int val2=st.pop();
                if(val1!=val2){
                    return false;
                }
                ptr2=ptr2.next;
            }
            return true;
        }
    }
}
