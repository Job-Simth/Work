package com.krokky.leetcode_Practice;

class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = check(s, i, i);
            int len2 = check(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展算法：判断左右两边的是否相等，相等就L与R左右各扩大一位
     */
    public int check(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}

public class leetcode005 {

    public static void main(String[] args) {
        String s = "adas";
        System.out.println(new Solution5().longestPalindrome(s));
    }
}
