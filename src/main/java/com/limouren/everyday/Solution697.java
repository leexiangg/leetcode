package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 */
public class Solution697 {

    /**
     * 空间换时间的方式
     * 光是读懂题就很不容易了
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        int maxCount = 0, ret = 0, max = 0, min = 50000;
        for(int n : nums){
            max = Math.max(n, max);
            min = Math.min(n, min);
        }
        // 第一个计数，第二个记第一次出现该数的位置，第三个记最后一个出现该数的位置
        int[] count = new int[max - min + 1];
        int[] left = new int[max - min + 1];
        int[] right = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i] - min;
            if(left[n] == 0)
                left[n] = i + 1;
            right[n] = i + 1;
            if(++count[n] > maxCount) {
                maxCount = count[n];
                ret = right[n] - left[n];
            } else if(count[n] == maxCount) {
                ret = Math.min(ret, right[n] - left[n]);
            }
        }
        return ret + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(new Date().getTime());
    }

    /**
     * 时间换空间
     * @param nums
     * @return
     */
    public static int findShortestSubArray2(int[] nums) {
        int max = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == -1)
                continue;
            int cnt = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    cnt++;
                    nums[j] = -1;
                    if(cnt > max) {
                        max = cnt;
                        ret = j - i;
                    } else if(cnt == max) {
                        ret = Math.min(ret, j - i);
                    }
                }
            }
        }
        return ret + 1;
    }

}
