package org.wei.algorithm;

import java.util.Arrays;

/**
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 *  
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 *
 * 链接：https://leetcode-cn.com/problems/sort-the-matrix-diagonally
 */
public class SortTheMatrixDiagonally {
    public static void main(String[] args) {
        int[][] mat ={
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2},
        };
        int[][] mat1 ={
                {75,21,13,24,8},
                {24,100,40,49,62}
        };
        print(mat1);

       int[][] newMat =  new Solution().diagonalSort(mat);
        print(newMat);
    }
    static class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int m = mat.length;
            if (m <= 1) {
                return mat;
            }
            int n = mat[0].length;
            //从竖排开始
            for (int i = m-2; i >=0 ; i--) {
                //取最小值防止越界
                int cl =Math.min(n,m-i);
                int[] temp =new int[cl];
                int index = 0;
                for (int k = i,j=0; k < m&&j<cl; k++,j++) {
                    temp[index++] = mat[k][j];
                }
                Arrays.sort(temp);
                index=0;
                for (int k = i,j=0; k < m&&j<cl; k++,j++) {
                    mat[k][j]=temp[index++];
                }
            }
            
            //从横排开始
            for (int i=n-2; i >0 ; i--) {
                //取最小值防止越界
                int cl =Math.min(m,n-i);
                int[] temp =new int[cl];
                int index = 0;
                for (int k = i,j=0; k < n&&j<cl; k++,j++) {
                    System.out.println(String.format("(%s,%s)",j,i));
                    temp[index++] = mat[j][k];
                }
                Arrays.sort(temp);
                index=0;
                for (int k = i,j=0; k < n&&j<cl; k++,j++) {
                    mat[j][k]=temp[index++];
                }
            }
            return mat;
        }
    }

    static void print(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(mat[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
