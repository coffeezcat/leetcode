package org.wei.algorithm;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        
    }

   static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
          return toBst(nums,0,nums.length-1);
        }
        private TreeNode toBst(int[] nums,int l,int r){
            if(l>r){
                return null;
            }
            int mid = (r+l)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left =toBst(nums,l,mid-1);
            node.right =toBst(nums,mid+1,r);
            return node;
        }
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
