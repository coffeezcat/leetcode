package org.wei.algorithm;

/**
 *给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,返回 13。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * */
public class KthSmallestElementInASortedMatrix {

    public static void main(String[] args) {
        int[] A = {1,  5,  9};
        int[] B = {4,  5,  7};

        int[][] matrix = {
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}};
        System.out.println(new Solution1().kthSmallest(matrix,8));
    }

   /**
    *归并排序
    * */
   static class Solution1 {
        public int kthSmallest(int[][] matrix, int k) {
            int[] sort = {};
            for (int[] tmp:matrix) {
                sort = mergeSort(sort,tmp);
            }
            return sort[k-1];
        }

       private int[] mergeSort(int[] A,int[] B){
            int m = A.length;
            int n =B.length;
            int[] arr = new int[m+n];
            int j =0,i=0,index=0;
            while (j<m&&i<n){
                if(A[j]<B[i]){
                    arr[index++] = A[j];
                    j++;
                }else{
                    arr[index++] = B[i];
                    i++;
                }
            }
            if(j<m){
                for (; j < m; j++) {
                    arr[index++] = A[j];
                }
            }else if(i<n){
                for (; i < n; i++) {
                    arr[index++] = B[i];
                }
            }
            return arr;
       }
    }
}
