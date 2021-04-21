package com.limouren.everyday;

import java.util.Date;

/**
 * 1221. 分割平衡字符串
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 */
public class Solution1221 {
    public static int balancedStringSplit(String s) {
        int ret = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L')
                c++;
            else
                c--;
            if(c == 0) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(new Date().getTime());
    }

}
