package org.wei.algorithm;
/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * */
public class Qiu12nLcof {

    public static void main(String[] args) {
        System.out.println(new Solution1().sumNums(9));
    }

    /**
     * 递归加短路运算
     * */
    static class Solution1 {
        public int sumNums(int n) {
            boolean flag = n>0&&(n+=sumNums(n-1))>0;
            return n;
        }
    }
}
