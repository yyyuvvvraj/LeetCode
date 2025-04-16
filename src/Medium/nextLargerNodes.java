package Medium;

import java.lang.classfile.components.ClassPrinter;
import java.util.Stack;

//Problem-1019
public class nextLargerNodes {
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

        // Get size of linked list
        private int sizeLL(ClassPrinter.ListNode head) {
            int count = 0;
            ClassPrinter.ListNode curr = head;
            while (curr != null) {
                count++;
                curr = curr.next;
            }
            return count;
        }

        // Reverse the linked list
        private ClassPrinter.ListNode reverseLL(ClassPrinter.ListNode head) {
            ClassPrinter.ListNode prev = null;
            ClassPrinter.ListNode curr = head;
            while (curr != null) {
                ClassPrinter.ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            return prev;
        }

        public int[] nextLargerNodes(ClassPrinter.ListNode head) {
            int size = sizeLL(head);
            int[] result = new int[size];

            ClassPrinter.ListNode newHead = reverseLL(head);
            Stack<Integer> stack = new Stack<>();
            ClassPrinter.ListNode curr = newHead;

            for (int i = size - 1; i >= 0; i--) {
                int val = curr.val;
                while (!stack.isEmpty() && stack.peek() <= val) {
                    stack.pop();
                }

                result[i] = stack.isEmpty() ? 0 : stack.peek();
                stack.push(val);
                curr = curr.next;
            }

            return result;
        }
    }

}
