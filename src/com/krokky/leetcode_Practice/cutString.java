package com.krokky.leetcode_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class cutString {
    public static void a(String str) {
        int len = str.length();
        int count = 0;
        if (len > 6) {
            if (len % 6 == 0) {
                count = len / 6;
            } else {
                count = len / 6 + 1;
            }
        }
        String[] arr = new String[count];
        for (int i = 0; i < arr.length; i++) {
            int b = 6 * i;
            int e = 6 * (i + 1) > len ? len : 6 * (i + 1);
            arr[i] = str.substring(b, e);
        }
        System.out.println(Arrays.toString(arr));
    }

    int p = 0;

    public int a1(String str) {
        char[] c = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            int m = c[i];
            sum += m;
        }
        a2(sum);
        return p;
    }

    public void a2(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        if (sum > 10) {
            a2(sum);
        } else {
            p = sum;
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        cutString cut = new cutString();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入:");
    }
}
