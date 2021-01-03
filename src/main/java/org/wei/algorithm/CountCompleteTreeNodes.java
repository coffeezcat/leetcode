package org.wei.algorithm;

public class CountCompleteTreeNodes {

    class Solution {
        public int countNodes(TreeNode root) {
            if(root==null){
                return 0;
            }
            return search(root);
        }
        public int search(TreeNode root){
            if(root.left==null&&root.right==null){
                return 1;
            }
            if(root.left!=null&&root.right==null){
                return 1+search(root.left);
            }
            if(root.right!=null&&root.left==null){
                return 1+search(root.left);
            }
            return search(root.left)+search(root.right);
        }
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
