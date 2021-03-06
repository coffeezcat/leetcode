package org.wei.algorithm;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * */
public class ClimbingStairs {

    public static void main(String[] args) {

    }

   static class Solution {
        public int climbStairs(int n) {
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    /**
     * DP方案
     */
    static class SolutionDP {
        public int climbStairs(int n) {
            if(n==1){
                return 1;
            }
            if(n==2){
                return 2;
            }
            int[] f = new int[n+1];
            f[1] = 1;
            f[2] = 2;
            for (int i = 3; i <= n; i++) {
                f[i]= f[i-1]+f[i-2];
            }
            return f[n];
        }
    }
}
