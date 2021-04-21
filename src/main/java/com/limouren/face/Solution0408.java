package com.limouren.face;

import java.util.Arrays;
import java.util.Date;

/**
 * 面试题 04.08. 首个共同祖先
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * https://leetcode-cn.com/problems/first-common-ancestor-lcci/
 */
public class Solution0408 {
    /**
     * 从root开始看每一个节点下面是否有这两个节点，如果有，把这个节点记下来，从这个节点再往下看是否有这两个节点
     * 用时非常久
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        while(true) {
            if(find(root.left, p.val, q.val) == 2)
                root = root.left;
            else if(find(root.right, p.val, q.val) == 2)
                root = root.right;
            else
                break;
        }
        return root;
    }

    /**
     * 遍历节点，看该节点下是否有p和q
     * @param tmp
     * @param p
     * @param q
     * @return
     */
    static int find(TreeNode tmp, int p, int q) {
        if(tmp == null)
            return 0;
        int ret = 0;
        if(tmp.val == p || tmp.val == q)
            ret ++;
        ret += find(tmp.left, p, q) + find(tmp.right, p, q);
        return ret;
    }

    /**
     * 找到p点和q点的坐标，计算出那个点
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val == p.val || root.val == q.val)
            return root;
        String pxy = number(root, p.val, "1");
        String qxy = number(root, q.val, "1");
        for (int i = 1; i < Math.min(pxy.length(), qxy.length()); i++) {
            if(pxy.charAt(i) != qxy.charAt(i))
                break;
            if(pxy.charAt(i) == '0')
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }

    /**
     * 找p节点的父系
     * @param root 根节点
     * @param p 要找的数
     * @return
     */
    static String number(TreeNode root, int p, String s) {
        if(root.val == p)
            return s;
        String tmp = null;
        if(root.left != null) {
            tmp = number(root.left, p, s + "0");
        }
        if(tmp == null && root.right != null) {
            tmp = number(root.right, p, s + "1");
        }
        return tmp;
    }

    public static void main(String[] args) {
        // 3,5,1,6,2,0,8,null,null,7,4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        System.out.println(new Date().getTime());
        System.out.println(lowestCommonAncestor2(root, p, q));
        System.out.println(new Date().getTime());
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static TreeNode niubiPlus(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p == root || q == root) return root;
        TreeNode left = niubiPlus(root.left, p, q);
        TreeNode right = niubiPlus(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

}
