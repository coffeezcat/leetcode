package org.wei.algorithm;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(1232221));
    }

  public static   class Solution {
        public boolean isPalindrome(int x) {
            int tmp = x;
            if(x<0){
                return false;
            }
            if(x == 0){
                return true;
            }
            int n =0;
            while (x!=0){
                n = n*10+x%10;
                x=x/10;
            }
            return n==tmp;
        }
    }
}
