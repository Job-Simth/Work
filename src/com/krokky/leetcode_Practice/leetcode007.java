package com.krokky.leetcode_Practice;

class Solution7 {
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            if (Math.abs(num) > (Integer.MAX_VALUE - Math.abs(x % 10)) / 10) {
                return 0;
            }
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num;
    }
}

public class leetcode007 {
    public static void main(String[] args) {
        int x = 120;
        System.out.println(x);
        System.out.println(new Solution7().reverse(x));
    }
}
