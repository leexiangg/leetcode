package com.limouren.everyday;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class Solution2 {
    /**
     * 按链表处理
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(l1.val + l2.val), tmp = l3;
        while(l1.next != null || l2.next != null) {
            if(tmp.val > 9) {
                tmp.val -= 10;
                tmp.next = new ListNode(1);
            }
            if(tmp.next == null)
                tmp.next = new ListNode();
            tmp = tmp.next;
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            tmp.val += l1.val + l2.val;
        }
        if(tmp.val > 9) {
            tmp.val -= 10;
            tmp.next = new ListNode(1);
        }
        return l3;
    }

    /**
     * 按数字处理
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        while(l1 != null) {
            s1.insert(0, l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            s2.insert(0, l2.val);
            l2 = l2.next;
        }
        String s3 = new BigInteger(s1.toString()).add(new BigInteger(s2.toString())).toString();
        ListNode l3 = new ListNode(Integer.parseInt(new String(String.valueOf(s3.charAt(s3.length() - 1))))), tmp = l3;
        for (int i = s3.length() - 2; i >= 0; i--) {
            tmp.next = new ListNode();
            tmp = tmp.next;
            tmp.val = Integer.parseInt((String.valueOf(s3.charAt(i))));
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(new Date().getTime());
        ListNode ret = addTwoNumbers2(l1, l2);
        while (ret != null) {
            System.out.println(ret.val);
            ret = ret.next;
        }
        System.out.println(new Date().getTime());
    }

    /**
     * 链表
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
