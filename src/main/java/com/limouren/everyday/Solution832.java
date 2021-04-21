package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 832. 翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 */
public class Solution832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        int l = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (l + 1) / 2; j++) {
                if (j == l - j - 1) {
                    A[i][j] = Math.abs(A[i][j] - 1);
                } else {
                    int tmp = Math.abs(A[i][j] - 1);
                    A[i][j] = Math.abs(A[i][l - j - 1] - 1);
                    A[i][l - j - 1] = tmp;
                }
            }
        }
        return A;
    }


    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{new int[]{1, 1, 0}, new int[]{1, 0, 1}, new int[]{0, 0, 0}})));
        System.out.println(new Date().getTime());
    }

}
