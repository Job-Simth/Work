package com.krokky.bishi;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int count = findMax(a, b);
        int sum = (a * count + b * (7 - count)) * 2 + a * 3;
        System.out.println(sum);
    }

    public static int findMax(int a, int b) {

        for (int i = 1; i < 7; i++) {
            if (((a * i + b * (7 - i)) < 0) && (a * ((i + 1) + b * (7 - i - 1)) >= 0)) {
                return i;
            }
        }
        return 0;
    }
}
