package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * https://leetcode-cn.com/problems/basic-calculator-ii/
 */
public class Solution227 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        if(nums1.length > 0)
            System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        if(nums2.length > 0)
            System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        Arrays.sort(nums3);
        if(nums3.length % 2 == 0)
            return (nums3[nums3.length / 2 - 1] + nums3[nums3.length / 2]) / 2d;
        else
            return nums3[nums3.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(findMedianSortedArrays(new int[]{1,2,3}, new int[]{1,2,3}));
        System.out.println(new Date().getTime());
    }

}
