package com.krokky.leetcode_Practice;

import java.util.Scanner;

class Solution9 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1) + "$";//给字符数组末尾加一位,统一处理循环的比较
        char[] c = str.toCharArray();
        String Answer = "";
        int count = 1;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                count++;
            } else {
                Answer = Answer + count + c[i];
                count = 1;
            }
        }
        return Answer;
    }
}

public class SayNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        String out = new Solution9().countAndSay(x);
        System.out.println(out);
    }
}