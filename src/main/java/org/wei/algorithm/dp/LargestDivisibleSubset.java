package org.wei.algorithm.dp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *
 * 如果有多个目标子集，返回其中任何一个均可。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 示例 2:
 *
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 *
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().largestDivisibleSubset(nums));
    }


      static   class Solution {
           public List<Integer> largestDivisibleSubset(int[] nums) {
               int len = nums.length;
               if(len==0)return new ArrayList<Integer>();

               List<ArrayList> dts = new ArrayList<ArrayList>();
               for (int num:nums) {
                   dts.add(new ArrayList());
               }

               Arrays.sort(nums);
               for (int i = 0; i < len; ++i) {
                   ArrayList<Integer> maxSubList = new ArrayList<Integer>();
                   for (int j = 0; j < i; ++j) {
                       if(nums[i]%nums[j]==0&&maxSubList.size()<dts.get(j).size()){
                           maxSubList = dts.get(j);
                       }
                   }
                   dts.get(i).addAll(maxSubList);
                   dts.get(i).add(nums[i]);
               }
               ArrayList<Integer> ret = new ArrayList<Integer>();

               for (int i = 0; i < len; ++i) {
                    if(dts.get(i).size()>ret.size())
                        ret=dts.get(i);
               }
               return ret;
           }
       }

}
