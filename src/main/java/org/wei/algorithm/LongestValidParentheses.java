package org.wei.algorithm;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * */
public class LongestValidParentheses {
    private static final String KH = "))))))()((()(((()((()((())()((()))()()(()()))))()())()))())())))(((()()()()(()()))()((()))))()(()()(((()())(((())(((())((()))))()(()(())(()(()(((((())(())))(()))())(((((())))))))()(())((((((()())()))))(()))(((()()(()(())()((())))()(())))())()())((((()))))()()((((((())()((((()(())((((()()())(())()())))()(()((())))))))()())((((()))())())))()))((())))()((()(())((()((())))((())((()())()))))())))())(((((((()))(((())(((()((()))(((()(())))((((()()())))))))())()))(()))())))()(()))((())()))((())))((())(()())(((()((()()))))()()(())))))()))))()((()((()(((()())(((())))(()(())())))((((((()()()))))((()))))(()(())()(()((())((()))()()()()(()((()())((((())()((()()))()))))()(((()())())))(()(((()()))()())))()()))))((()((((()(()))()(()()(((()()()()())((())()(((())(())))))()))))()())()()())(())))((())(()))(((())()))))))())()())((()((()()(())))())((()(((()(((((()(())(())()()))()))(()((((((((()(()()))()(()(()))(())(())())))))(())))))))()))))()())()()(((())()))((()))))))(())((()))(()((()()())())((()))))((()()())(()(((()))))(())(((()(()()()()((())())(())()))()())))())))()(((()))(()))()))()((((()()()(()(()))(((())()()(((())()((()(())((())())(((()()))((()())))())(()(())(()()))(((()(())(())))(()())(()()()()(()((()()()))(())(()(((()())))()((((())()())((()(()(())))(()()(()(()))))))(()())((()))()))()(()))((()()))))()()()))(())(())(())))()(()))(()()(((()((((())())))(()(())(()()))))))((()((()()))())))((((((())()))())(())())(()()(()(()()))()))((()((())(()((()(())))()((()))()(((()()()())()((())))(()()()()(()((()()((()((()()()(()(((())))))(())(()()(()())((((()()()()((()(())()(((()))(()(())(((()())())((()()))(";

    private static final String KH1 = "(()((()))";
    public static void main(String[] args) {
        System.out.println(new Solution2().longestValidParentheses(KH1));
    }

    /**
     * 暴力破解永远适用
     * */
   static class Solution1 {
        public int longestValidParentheses(String s) {
            char[] chars = s.toCharArray();
            int m = chars.length;
            int ans = 0;
            for (int i=0;i<m;i++){
                for (int j= i+1;j<m;j++){
                    if(isValid(chars,i,j)){
                        ans = Math.max(ans,j-i+1);
                    }
                }
            }
            return ans;
        }

        public boolean isValid(char[] chars,int r,int l){
            Stack<Character> stack = new Stack<>();
            for (int i = r; i <= l; i++) {
                if(chars[i]=='('){
                    stack.push(chars[i]);
                }else if(chars[i]==')'&&!stack.empty()){
                    stack.pop();
                }else{
                    return false;
                }
            }
            return stack.empty();
        }
    }

    /**
     * DP动态规划
     * */
    static class Solution2 {
        public int longestValidParentheses(String s) {
            int maxans = 0;
            int dp[] = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;

                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }

            for (int i = 0; i < s.length(); i++) {
                System.out.println("db["+(i+1)+"]="+dp[i]);
            }
            return maxans;
        }
    }
}
