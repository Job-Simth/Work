package com.krokky.leetcode_Practice;

class Solution8 {
    public int myAtoi(String str) {
        int i = 0;
        int flag = 0;
        double count = 0;
        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(0) == '-') {
            flag = -1;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        for (; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                count = count * 10 + str.charAt(i) - '0';
            } else {
                break;
            }
        }

        if (-1 == flag) {
            count = count * (-1);
            if (count < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int) count;
            }
        } else {
            if (count > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int) count;
            }
        }
    }
}

public class leetcode008 {
    public static void main(String[] args) {
        String str = "-91283472332";
        System.out.println(new Solution8().myAtoi(str.trim()));
    }
}
