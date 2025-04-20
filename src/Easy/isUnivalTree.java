package Easy;

import javax.swing.tree.TreeNode;

//Problem-965
public class isUnivalTree {
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
        public boolean helper(TreeNode root, int val){
            if(root==null){
                return true;
            }
            if(root.val!=val){
                return false;
            }
            boolean leftans=helper(root.left,val);
            boolean rightans=helper(root.right,val);
            return leftans&&rightans;
        }
        public boolean isUnivalTree(TreeNode root) {
            return helper(root,root.val);
        }
    }
}
