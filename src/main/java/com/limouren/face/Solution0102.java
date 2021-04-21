package com.limouren.face;

import java.util.Date;

/**
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class Solution0102 {
    public static boolean CheckPermutation(String s1, String s2) {
        int[] cs = new int[128];
        for (int i = 0; i < s1.length(); i++)
            cs[s1.charAt(i)] ++;
        for (int i = 0; i < s2.length(); i++)
            cs[s2.charAt(i)] --;
        for (int c : cs)
            if(c != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(CheckPermutation("abc", "bca"));
        System.out.println(new Date().getTime());
    }

}
