package org.wei.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = ，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 链接：https://leetcode-cn.com/problems/3sum
 * */
public class ThreeSum {

    public static void main(String[] args) {
        //int[] sums = {-1, 0, 1, 2, -1, -4};
        int[] sums = {0,0,0,0};
        //int[] sums = {-1,0,1,2,-1,-4};
        //-4,-1,-1,0,1,2
        System.out.println(new Solution().threeSum(sums));
    }
    /**
     * 排序+双指针
     * */
   static   class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if(nums.length<3){
                return result;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if(nums[i]>0)continue;
                if(i>0&&nums[i]==nums[i-1])continue;

                int left = i+1;
                int right = nums.length-1;
                while (left<right){
                    int sum =nums[i]+nums[left]+nums[right];
                    if(sum==0){
                        result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                        left++;
                        right--;
                        //去重
                        while (left<right&&nums[left]==nums[left-1]){left++;}
                        while (left<right&&nums[right]==nums[right+1]){right--;}
                    }else if(sum>0){
                        right--;
                    }else {
                        left++;
                    }
                }
            }
            return result;
        }


    }
}
