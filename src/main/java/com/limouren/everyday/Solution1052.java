package com.limouren.everyday;

import com.limouren.common.Common;

import java.util.Date;

/**
 * 1052. 爱生气的书店老板
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner
 */
public class Solution1052 {
    /**
     * 滑块
     * @param customers
     * @param grumpy
     * @param X
     * @return
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, max;
        for (int i = 0; i < customers.length; i++) {
            if(grumpy[i] == 0 || i < X)
                sum += customers[i];
        }
        max = sum;
        for (int i = 0; i < customers.length - X; i++) {
            sum = sum - (grumpy[i] == 1 ? customers[i] : 0) + (grumpy[X + i] == 1 ? customers[X + i] : 0);
            max = Math.max(max, sum);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(maxSatisfied(new int[]{10,1,7}, new int[]{0,0,0}, 2));
        System.out.println(new Date().getTime());
    }

}
