package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * https://leetcode-cn.com/problems/transpose-matrix/
 */
public class Solution867 {
    public static int[][] transpose(int[][] matrix) {
        int[][] ret = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                ret[j][i] = matrix[i][j];
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(Arrays.deepToString(transpose(new int[][]{new int[]{1,2,3,4,5,6}, new int[]{4,5,6,7,8,9}, new int[]{7,8,9,1,2,3}})));
        System.out.println(new Date().getTime());
    }

}
