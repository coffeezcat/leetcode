package org.wei.algorithm;
/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
   static class Solution {
        public int reverse(int x) {
            long n =0;
           while (x!=0){
               n = n*10 + x%10;
               x = x/10;
           }
            return (int)n==n? (int)n:0;
        }
    }
}
