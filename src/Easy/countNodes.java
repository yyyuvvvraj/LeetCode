package Easy;

import javax.swing.tree.TreeNode;

//Problem-222
public class countNodes {
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
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            int leftAns=countNodes(root.left);
            int rightAns=countNodes(root.right);
            return leftAns+rightAns+1;
        }
    }
}
