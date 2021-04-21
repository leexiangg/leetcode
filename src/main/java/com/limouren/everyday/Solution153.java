package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 */
public class Solution153 {

    /**
     * 一个一个遍历，当然也很快，毕竟最多就5000个元素
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int ret = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] < nums[i]) {
                ret = nums[i + 1];
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(findMin2(new int[]{4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,0,1,2,3}));
        System.out.println(new Date().getTime());
    }

    /**
     * 二分法查找
     * 如果改成500000000个元素也不怕，因为时间复杂度只有O(logN)
     * @param nums
     * @return
     */
    public static int findMin2(int[] nums) {
        int ret = nums[0], left = 0, right = nums.length;
        do {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
                ret = nums[mid];
            } else {
                left = mid;
            }
            System.out.println(left + "   " + right);
        } while (left + 1 != right);
        return ret;
    }
}
