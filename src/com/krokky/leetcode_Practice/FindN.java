package com.krokky.leetcode_Practice;

import java.util.Scanner;

public class FindN {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        char[] c = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '8', '7', '6', '5', '4', '3', '2'};
        n = s.nextInt();
        int num = (n - 1) % 16;
        System.out.println(c[num]);
    }
}
