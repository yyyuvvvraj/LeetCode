package DailyChallenges.Medium;

import javax.swing.tree.TreeNode;

//Problem-1123
public class treeNode {
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
    class T{
        public TreeNode lca;
        public int depth;
        public T(TreeNode lca,int depth){
            this.lca=lca;
            this.depth=depth;
        }
    }
    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return dfs(root).lca;
        }
        private T dfs(TreeNode root){
            if(root==null){
                return new T(null,0);
            }
            T left=dfs(root.left);
            T right=dfs(root.right);
            if(left.depth>right.depth){
                return new T(left.lca,left.depth+1);
            }
            if(left.depth<right.depth){
                return new T(right.lca,right.depth+1);
            }
            return new T(root,left.depth+1);
        }
    }
}
