package com.krokky.bishi;

import java.util.Arrays;
import java.util.Scanner;

public class findP {
    public static int find() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 1) {
            return 0;
        }
        int m = Math.abs(scanner.nextInt());
        int[] l = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = scanner.nextInt();
        }

        Arrays.sort(l);
        int temp = l.length / 2;

        if (l[l.length - 1] == l[0]) {
            return 0;
        }
        if (m == 0) {
            return l[l.length - 1] - l[0];

        } else {
            if (l.length % 2 == 0) {
                for (int i = 0; i < temp; i++) {
                    l[i] += m;
                }
                for (int i = temp; i < l.length; i++) {
                    l[i] -= m;
                }
            } else {
                for (int i = 0; i < temp; i++) {
                    l[i] += m;
                }
                for (int i = temp + 1; i < l.length; i++) {
                    l[i] -= m;
                }
            }
            Arrays.sort(l);
            return l[l.length - 1] - l[0];
        }
    }

    public static void main(String[] args) {

        int ans = find();
        System.out.println(ans);
    }
}
