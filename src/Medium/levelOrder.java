package Medium;

import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//Problem-102
public class levelOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans=new ArrayList<>();
            List<Integer> currAns=new ArrayList<>();
            if(root==null){
                return ans;
            }
            Queue<TreeNode> main=new ArrayDeque<>();
            Queue<TreeNode> helper=new ArrayDeque<>();
            main.add(root);
            while(main.size()>0){
                TreeNode currNode=main.remove();
                currAns.add(currNode.val);
                if(currNode.left!=null){
                    helper.add(currNode.left);
                }
                if(currNode.right!=null){
                    helper.add(currNode.right);
                }
                if(main.size()==0){
                    ans.add(currAns);
                    currAns=new ArrayList<>();
                    main=helper;
                    helper=new ArrayDeque<>();
                }
            }
            return ans;
        }
    }
}
