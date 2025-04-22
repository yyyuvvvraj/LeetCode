package Easy;

import javax.swing.tree.TreeNode;

//Problem-101
public class isSymmetric {
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
        public boolean helper(TreeNode root1, TreeNode root2){
            if(root1==null||root2==null){
                return root1==root2;
            }
            if(root1.val==root2.val){
                boolean ans1=helper(root1.left,root2.right);
                boolean ans2=helper(root1.right,root2.left);
                return ans1&&ans2;
            }else{
                return false;
            }
        }
        public boolean isSymmetric(TreeNode root) {
            if(root==null){
                return true;
            }
            return helper(root.left,root.right);
        }
    }
}
