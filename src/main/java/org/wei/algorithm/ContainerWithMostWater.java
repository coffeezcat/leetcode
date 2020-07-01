package org.wei.algorithm;
/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 双指针方式
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height ={1,1};
        int maxWater = new Solution2().maxArea(height);
        System.out.println(maxWater);
    }

    /***
     * 解题方式一：暴力破解法
     * */
    static class Solution1 {
        public int maxArea(int[] height) {
            if(height.length<2){
                return 0;
            }
            int maxWater = 0;

            for (int l=0;l<height.length-1;l++) {
                int r = height.length-1;
                while (l<r){
                    int dif = r-l;
                    int water = dif*Math.min(height[l],height[r]);
                    maxWater = Math.max(maxWater,water);
                    r--;
                }
            }
            return maxWater;
        }
    }

    /***
     * 解题方式二:双指针 单指针移动
     * */
    static class Solution2 {
        public int maxArea(int[] height) {
            if(height.length<2){
                return 0;
            }
            int maxWater = 0;
            int l = 0,r=height.length-1;
            while (l<r){
                int dif = r-l;
                int water = dif*Math.min(height[l],height[r]);
                maxWater = Math.max(maxWater,water);
                if(height[l]<height[r]){
                    l++;
                }else{
                    r--;
                }

            }

            return maxWater;
        }
    }
}
