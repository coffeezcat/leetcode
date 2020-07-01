package org.wei.algorithm;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 * 链接：https://leetcode-cn.com/problems/assign-cookies
 * */
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s={1,2,3};
        System.out.println(new Solution().findContentChildren(g,s));
    }
    static class Solution {
        /**
         * 双指针
         * @param g 孩子的胃口
         * @param s 权重
         * */
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int match = 0;
            for (int i = 0,j=0; i < g.length&&j<s.length; ) {
                if(s[j]>=g[i]){
                    match++;
                    i++;j++;
                }else{
                    j++;
                }
            }
            return match;
        }
    }
}
