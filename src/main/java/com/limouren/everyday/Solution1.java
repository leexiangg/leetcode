package com.limouren.everyday;

import com.limouren.common.Common;

import java.util.Arrays;
import java.util.Date;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class Solution1 {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target)
                    return new int[] {i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(new Date().getTime());
    }

}
