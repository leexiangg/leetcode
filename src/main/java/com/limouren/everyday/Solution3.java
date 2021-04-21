package com.limouren.everyday;

import java.util.Arrays;
import java.util.Date;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution3 {
    /**
     * 记有没有
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int[] flag = new int[128];
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(flag[cs[i]] == 0)
                flag[cs[i]] = 1;
            else
                while(left < i && cs[i] != cs[left ++])
                    flag[cs[left - 1]] = 0;
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(lengthOfLongestSubstring2("abba"));
        System.out.println(new Date().getTime());
    }

    /**
     * 记位置
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        int[] flag = new int[128];
        char[] cs = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(flag[cs[i]] != 0) {
                left = Math.max(left, flag[cs[i]]);
            }
            flag[cs[i]] = i + 1;
            max = Math.max(max, i - left + 1);
            System.out.println(i + "    " + left + "    " + max);
        }
        return max;
    }

}
