package com.limouren.everyday;

import java.util.Date;

/**
 * 1550. 存在连续三个奇数的数组
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * https://leetcode-cn.com/problems/three-consecutive-odds/
 */
public class Solution1550 {
    public static boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int a : arr)
            if(a % 2 == 1) {
                cnt++;
                if(cnt == 3)
                    return true;
            } else
                cnt = 0;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(threeConsecutiveOdds(new int[] {1,2,34,3,4,5,7,23,12}));
        System.out.println(new Date().getTime());
    }

}
