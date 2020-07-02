package org.wei.algorithm;
/**
 *给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 示例：
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 * */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        int[] A ={1,2,3,2,1};
        int[] B ={3,2,1,4,7};
        System.out.println(new Solution2().findLength(A,B));
    }
    /**
     * 暴力破解方法
     * */
  static  class Solution1 {
        public int findLength(int[] A, int[] B) {
            if(A.length==0||B.length==0){
                return 0;
            }
            int ans = 0;
            for (int i=0;i<A.length-1;i++){
                for (int j=0;j<B.length-1;j++){
                    int k =0;
                    while (i+k<A.length&&j+k<B.length&&A[i+k] == B[j+k]){
                        k++;
                    }
                    ans = Math.max(ans,k);
                }
            }
            return ans;
        }

    }

    /**
     * 暴力破解方法
     * */
    static  class Solution2 {
        public int findLength(int[] A, int[] B) {
            if(A.length==0||B.length==0){
                return 0;
            }
            int[][] dp = new int[A.length+1][B.length+1];
            int ans = 0;
            for (int i=1;i<=A.length;i++){
                for (int j=1;j<=B.length;j++){
                    dp[i][j] = A[i-1]==B[j-1]?dp[i-1][j-1]+1:0;
                    ans = Math.max(ans,dp[i][j]);
                }
            }
            return ans;
        }

    }
}
