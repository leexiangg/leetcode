package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 链接：https://leetcode-cn.com/problems/next-permutation
 */
public class Solution31 {
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for(; i >= 0 && nums[i] > nums[i+1]; i--) {}
        if(i == -1) {
            return;
        }
        int k = i+1;
        for(; k < nums.length && nums[k] > nums[i]; k++) {}
        int t = nums[i];
        nums[i] = nums[k - 1];
        nums[k - 1] = t;
        Arrays.sort(nums,i+1, nums.length);
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        int[] a = new int[]{5, 1, 1};
        nextPermutation(a);
        System.out.println(Arrays.toString(a));
        System.out.println(new Date().getTime());
    }

}
