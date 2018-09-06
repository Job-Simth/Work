package com.krokky.bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class find {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int count = 0;

        Set<Integer> set = new HashSet<>();

        if (k > a.length) {
            System.out.println(count);

        }

        for (int i = 0; i < a.length - k + 1; i++) {
            int temp = t;
            for (int j = i; j < i + k; j++) {
                if (set.contains(a[j])) {
                    temp--;
                }
                if (temp <= 1) {
                    count++;
                    break;
                }
                set.add(a[j]);
            }
            set.clear();
        }
        System.out.println(count);
    }
}
