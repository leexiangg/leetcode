package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 链接：https://leetcode-cn.com/problems/toeplitz-matrix
 */
public class Solution766 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if(matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(isToeplitzMatrix(new int[][]{new int[]{3,4,5,6,9,3}, new int[]{2,3,4,5,6,9}, new int[]{1,2,3,4,5,6}}));
        System.out.println(new Date().getTime());
    }

}
