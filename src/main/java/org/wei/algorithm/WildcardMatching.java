package org.wei.algorithm;

/**
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * */
public class WildcardMatching {

    public static void main(String[] args) {
        new SolutionDP().isMatch("aa","*");
    }
    /**
     *dp[i][j]  s的前i个字符串 p的前j个字符串匹配
     * */
    static class SolutionDP {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m+1][n+1];

            //初始化第0个
            dp[0][0]=true;
            for (int j =1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    dp[0][j]=true;
                }else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }
}
