package com.limouren.everyday;

import com.limouren.common.Common;

import java.util.Date;

/**
 * 992. K 个不同整数的子数组
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * 返回 A 中好子数组的数目。
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 */
public class Solution992 {
    static int getMost(int[] A, int K){
        int n = A.length, l = 0, r = 0;
        int[] cnt = new int[n+1];
        int count = 0, res = 0;
        while(r<n){
            if(cnt[A[r]]==0)
                count++;
            cnt[A[r++]]++;
            while(count>K){
                if(cnt[A[l]]==1) count--;
                cnt[A[l++]]--;
            }
            res += r-l;
        }
        return res;
    }

    static int subarraysWithKDistinct(int[] A, int K) {
        return getMost(A, K) - getMost(A, K-1);
    }

    public static void main(String[] args) {
        System.out.println(new Date().getTime());
        System.out.println(niubiPlus(Common.readArray(), 2));
        System.out.println(new Date().getTime());
    }

    static int niubiPlus(int[] A, int K) {
        int length = A.length, left = 0, right = 0, diff = 0, ans = 0;
        int[] arr = new int[length + 1];

        while (right < length) {
            if (arr[A[right]]++ == 0) {
                diff++;
            }
            while (diff > K) {
                if (--arr[A[left]] == 0) {
                    diff--;
                }
                left++;
            }
            if (diff == K) {
                int leftTemp = left;
                while (diff == K) {
                    if (--arr[A[leftTemp]] == 0) {
                        diff--;
                    }
                    leftTemp++;
                    ans++;
                }
                for (int i = left; i < leftTemp; i++)
                    if (arr[A[i]]++ == 0) {
                        diff++;
                    }
            }
            right++;
        }
        return ans;
    }

}
