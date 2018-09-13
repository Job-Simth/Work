package com.krokky.bishi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = find(n);
        System.out.println(res);
    }

    public static int find(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        int a = j;
                        int b = i;
                        int c;
                        while ((c = a % b) != 0) {
                            a = b;
                            b = c;
                        }
                        if (b == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}