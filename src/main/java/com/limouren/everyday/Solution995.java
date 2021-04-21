package com.limouren.everyday;

import com.limouren.common.Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

/**
 * 995. K 连续位的最小翻转次数
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 * https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 */
public class Solution995 {

    /**
     * @param A
     * @param K
     * @return
     */
    public static int minKBitFlips(int[] A, int K) {
        int cnt = 0, res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= 2)
                cnt--;
            if (((cnt ^ A[i]) & 1) == 0) {
                if (i + K > A.length)
                    return -1;
                res ++;
                cnt ++;
                if (i + K < A.length)
                    A[i + K] += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(minKBitFlips(Common.readArray(), 14750));
        System.out.println(new Date().getTime());
    }

}
