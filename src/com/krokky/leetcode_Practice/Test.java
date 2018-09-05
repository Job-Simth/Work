package com.krokky.leetcode_Practice;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = s.nextInt();
        }
        int z = s.nextInt();
        int[] m = new int[z];
        for (int i = 0; i < z; i++) {
            m[i] = s.nextInt();
        }
        int count = 0;

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int aM : m) {
                for (int j = 0; j < y.length; j++) {
                    count += y[j];
                    if (count > aM) {
                        System.out.println(j + 1);
                        count = 0;
                        break;
                    }
                }
            }
        }
    }
}
