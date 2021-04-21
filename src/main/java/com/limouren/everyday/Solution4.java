package com.limouren.everyday;

import com.limouren.common.Common;

import java.util.Arrays;
import java.util.Date;
import java.util.Stack;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class Solution4 {

    /**
     * 用栈
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<String> stack = new Stack<String>();
        String[] ss = s.replace(" ", "")
                .replace("+", " + ")
                .replace("-", " + -")
                .replace("*", " * ")
                .replace("/", " / ")
                .split(" ");
        for (int i = 0; i < ss.length; i++) {
            if("*".equals(ss[i]))
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) * Integer.parseInt(ss[++ i])));
            else if("/".equals(ss[i]))
                stack.push(String.valueOf(Integer.parseInt(stack.pop()) / Integer.parseInt(ss[++ i])));
            else if(!"+".equals(ss[i]))
                stack.push(ss[i]);
        }
        int res = 0;
        while(!stack.empty())
            res += Integer.parseInt(stack.pop());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(calculate2(" 3/2 "));
        System.out.println(new Date().getTime());
    }

    /**
     * 不用replace，不用Integer.parseInt，不用Stack
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        int[] stack = new int[s.length() + 1];
        int index = 0;
        char sign = '+';
        int tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >='0' && c <='9') {
                tmp = tmp * 10 + c - '0';
            } else if(c != ' ') {
                if(sign == '*')
                    stack[index] *= tmp;
                else if(sign == '/')
                    stack[index] /= tmp;
                else if(sign == '+')
                    stack[++index] = tmp;
                else
                    stack[++index] = -tmp;
                sign = c;
                tmp = 0;
            }
        }
        if(sign == '*')
            stack[index] *= tmp;
        else if(sign == '/')
            stack[index] /= tmp;
        else if(sign == '+')
            stack[++index] = tmp;
        else
            stack[++index] = -tmp;
        int res = 0;
        while(index!= 0)
            res += stack[index --];
        return res;
    }

}
