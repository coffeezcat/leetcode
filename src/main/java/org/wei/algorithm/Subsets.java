package org.wei.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class Subsets {
    /**
     * 位列举
     */
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            int len = nums.length;
            if(len==0){
                result.add(new ArrayList<Integer>());
                return result;
            }

            int maxIndex = (int)Math.pow(Double.valueOf(2),Double.valueOf(len));

            for (int i = 0; i < maxIndex; i++) {
                List<Integer> var1=  new ArrayList<Integer>();
                for (int j = len-1; j>=0; j--) {
                    int mask = (int)Math.pow(Double.valueOf(2),Double.valueOf(j));
                    if((mask&i)!=0){
                        var1.add(nums[len-j-1]);
                    }
                }
                result.add(var1);
            }

            return result;
        }
    }

    /**
     * 循环列举
     */
    static class SolutionLoop{
        /**
         *
         * @param nums
         * @return
         */
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            for (int num:nums) {
                int size = res.size();
                for (int i = 0; i < size; i++) {
                    List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                    newSub.add(num);
                    res.add(newSub);
                }
            }

            return res;
        }
    }
    static class SolutionRecursion{
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(new ArrayList<Integer>());
            recursion(nums,0,res);
            return res;
        }

        /**
         * 递归方法
         * @param nums
         * @param i
         * @param res
         */
        public void recursion(int[] nums,int i,List<List<Integer>> res ){
            if (i >= nums.length) return;
            int size = res.size();

            for (int j = 0; j < size; j++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(j));
                newSub.add(nums[i]);
                res.add(newSub);
            }

            recursion(nums, i + 1, res);
        }

    }

    public static void main(String[] args) {
        int[] nums = {3,2,5};
        System.out.println(new SolutionRecursion().subsets(nums));
    }
}
