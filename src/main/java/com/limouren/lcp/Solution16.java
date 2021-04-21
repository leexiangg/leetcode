package com.limouren.lcp;

import java.util.Date;

/**
 * LCP 16. 游乐园的游览计划
 * 又到了一年一度的春游时间，小吴计划去游乐场游玩 1 天，游乐场总共有 N 个游乐项目，编号从 0 到 N-1。
 * 小吴给每个游乐项目定义了一个非负整数值 value[i] 表示自己的喜爱值。两个游乐项目之间会有双向路径相
 * 连，整个游乐场总共有 M 条双向路径，保存在二维数组 edges中。 小吴计划选择一个游乐项目 A 作为这一
 * 天游玩的重点项目。上午小吴准备游玩重点项目 A 以及与项目 A 相邻的两个项目 B、C （项目A、B与C要求是
 * 不同的项目，且项目B与项目C要求相邻），并返回 A ，即存在一条 A-B-C-A 的路径。 下午，小吴决定再游玩
 * 重点项目 A以及与A相邻的两个项目 B'、C'，（项目A、B'与C'要求是不同的项目，且项目B'与项目C'要求相邻
 * ），并返回 A ，即存在一条 A-B'-C'-A 的路径。下午游玩项目 B'、C' 可与上午游玩项目B、C存在重复项
 * 目。 小吴希望提前安排好游玩路径，使得喜爱值之和最大。请你返回满足游玩路径选取条件的最大喜爱值之和，如
 * 果没有这样的路径，返回 0。 注意：一天中重复游玩同一个项目并不能重复增加喜爱值了。例如：上下午游玩路
 * 径分别是 A-B-C-A与A-C-D-A 那么只能获得 value[A] + value[B] + value[C] + value[D] 的总和。
 *
 * 链接：https://leetcode-cn.com/problems/you-le-yuan-de-you-lan-ji-hua
 */
public class Solution16 {

    public static int maxWeight(int[][] edges, int[] value) {
        if(edges.length < 3)
            return 0;
        if(value.length == 3)
            return value[0] + value[1] + value[2];


        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(maxWeight(new int[][]{new int[]{0,1}, new int[]{1,2}, new int[]{0, 2}}, new int[]{1, 2, 3}));
        System.out.println(new Date().getTime());
    }
}
