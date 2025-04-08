package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-2816
public class doubleIt {
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

        // Helper function to reverse a linked list
        private ClassPrinter.ListNode reverseLL(ClassPrinter.ListNode head) {
            ClassPrinter.ListNode prev = null;
            while (head != null) {
                ClassPrinter.ListNode nextNode = head.next;
                head.next = prev;
                prev = head;
                head = nextNode;
            }
            return prev;
        }

        public ClassPrinter.ListNode doubleIt(ClassPrinter.ListNode head) {
            // Reverse the list to make it easier to work from least significant digit
            ClassPrinter.ListNode nhead = reverseLL(head);
            ClassPrinter.ListNode dummy = new ClassPrinter.ListNode(-1);
            ClassPrinter.ListNode curr = dummy;
            int carry = 0;

            while (nhead != null) {
                int sum = nhead.val * 2 + carry;
                int digit = sum % 10;
                carry = sum / 10;

                curr.next = new ClassPrinter.ListNode(digit);
                curr = curr.next;

                nhead = nhead.next;
            }

            if (carry > 0) {
                curr.next = new ClassPrinter.ListNode(carry);
            }

            // Reverse the final result to restore correct order
            return reverseLL(dummy.next);
        }
    }

}
