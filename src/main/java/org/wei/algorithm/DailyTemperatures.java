package org.wei.algorithm;

import org.wei.utils.OutputUtil;

import java.util.Stack;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：
 * 要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 */
public class DailyTemperatures {


    /**
     * 暴力破解
     */
    static class SolutionViolence {
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] R = new int[len];
            for (int i = 0; i <len ; i++) {

                for (int j = i+1; j <len ; j++) {
                     if(T[i]<T[j]){
                         R[i]=j-i;
                         break;
                     }
                }

            }
            return R;
        }
    }

    /**
     * 使用递减堆栈
     */
    static class SolutionStack {
        public int[] dailyTemperatures(int[] T) {
            int len = T.length;
            int[] R = new int[len];
            Stack<Integer> stack = new Stack<Integer>();

            for (int i = 0; i < len; i++) {
                if(stack.empty()){
                    stack.push(i);
                }else {
                    if(T[i]>=T[stack.peek()]){
                        while (!stack.empty()){
                            int pop = stack.peek();
                            if(T[pop]<T[i]){
                                R[pop]=i-pop;
                                stack.pop();
                            }else{
                                break;
                            }
                        }
                    }
                    stack.push(i);
                }
            }
            return  R;
        }
    }


    public static void main(String[] args) {
        int [] T = {34,80,80,34,34,80,80,80,80,34};
        int[] R = new SolutionStack().dailyTemperatures(T);
        OutputUtil.print(R);
    }
}
