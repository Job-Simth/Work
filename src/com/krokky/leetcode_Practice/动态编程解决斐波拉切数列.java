package com.krokky.leetcode_Practice;

import java.util.Scanner;

public class 动态编程解决斐波拉切数列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入一个数:");
        int index = in.nextInt();
        System.out.println(index + " " + fib(index));
    }

    public static long fib(long n) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 1;

        if (n == 0) return f0;
        if (n == 1) return f1;
        if (n == 2) return f2;

        for (int i = 3; i <= n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }
        return f2;
    }
}
