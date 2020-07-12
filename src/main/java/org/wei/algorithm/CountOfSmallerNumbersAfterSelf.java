package org.wei.algorithm;

import java.util.*;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 *
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * */
public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int[] nums ={5,5,2,3,6};
        System.out.println(new Solution2().countSmaller(nums).toString());

    }
   static class Solution1 {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int len = nums.length;
            int[] c= new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    if(nums[j]<nums[i]){
                        c[i]=c[i]+1;
                    }
                }
                res.add(c[i]);
            }
            return res;
        }
    }

    /**
     * 树状数组解法？？？
     *
     * */
    static class Solution2 {
        private int[] c;
        private int[] a;

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> resultList = new ArrayList<Integer>();
            discretization(nums);
            init(nums.length + 5);
            for (int i = nums.length - 1; i >= 0; --i) {
                int id = getId(nums[i]);
                resultList.add(query(id - 1));
                update(id);
            }
            Collections.reverse(resultList);
            return resultList;
        }

        private void init(int length) {
            c = new int[length];
            Arrays.fill(c, 0);
        }

        public int lowBit(int x) {
            return x & (-x);
        }

        private void update(int pos) {
            while (pos < c.length) {
                c[pos] += 1;
                pos += lowBit(pos);
            }
        }

        private int query(int pos) {
            int ret = 0;
            while (pos > 0) {
                ret += c[pos];
                pos -= lowBit(pos);
            }

            return ret;
        }

        /**
         * 描述 用于描述
         * @param nums
         */
        private void discretization(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int size = set.size();
            a = new int[size];
            int index = 0;
            for (int num : set) {
                a[index++] = num;
            }
            Arrays.sort(a);
        }

        private int getId(int x) {
            return Arrays.binarySearch(a, x) + 1;
        }
    }

}
