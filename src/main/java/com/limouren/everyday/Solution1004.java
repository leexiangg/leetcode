package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * https://leetcode-cn.com/problems/max-consecutive-ones-iii/
 */
public class Solution1004 {
    public static int longestOnes(int[] A, int K) {
        int left = 0;
        int max = 0;
        int tmp = K;
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0)
                if(tmp == 0)
                    while(A[left ++] == 1) ;
                else
                    tmp --;
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(new Date().getTime());
    }

}
