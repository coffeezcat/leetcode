package org.wei.algorithm;


/**
 *输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abbac"));
    }
    static class Solution {
        public String longestPalindrome(String s) {
            if(s==null||s.equals("")){
                return "";
            }
            int start = 0; int end=0;
            int n = s.length();
            for (int i=0;i<n;i++){
                int even = expandAroundCenter(s,i,i);
                int odd = expandAroundCenter(s,i,i+1);
                int len = Math.max(even,odd);
                System.out.println(len);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }

            return s.substring(start,end+1);
        }

        private int expandAroundCenter(String s,int left,int right){
            int l=left,r=right;
            while (l>=0&&r<s.length()&&(s.charAt(l)==s.charAt(r))){
                --l;
                ++r;
            }
            return r-l-1;
        }
    }
}
