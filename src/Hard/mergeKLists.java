package Hard;

import java.lang.classfile.components.ClassPrinter;
import java.util.PriorityQueue;

public class mergeKLists /**
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
    public ClassPrinter.ListNode mergeKLists(ClassPrinter.ListNode[] lists) {
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        PriorityQueue<ClassPrinter.ListNode>pq=new PriorityQueue<>((a, b)->a.val-b.val);
        for(int i=0;i<lists.length;i++){
            ClassPrinter.ListNode temphead=lists[i];
            while(temphead!=null){
                pq.add(temphead);
                temphead=temphead.next;
            }
        }
        ClassPrinter.ListNode dummy=new ClassPrinter.ListNode(-1);
        ClassPrinter.ListNode ans=dummy;
        while(pq.size()>0){
            ClassPrinter.ListNode node=pq.remove();
            dummy.next=node;
            dummy=dummy.next;
        }
        dummy.next=null;
        return ans.next;
    }
}{
}
