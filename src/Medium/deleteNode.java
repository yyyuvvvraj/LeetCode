package Medium;

import java.lang.classfile.components.ClassPrinter;

//Problem-237
public class deleteNode {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ClassPrinter.ListNode node) {
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }
}
