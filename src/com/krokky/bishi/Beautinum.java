package com.krokky.bishi;

import java.util.Scanner;

public class Beautinum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int k = s.nextInt();
        System.out.println(find(a, b, k));
    }

    public static int find(int a, int b, int k) {
        int count = 0;
        int ans = 0;
        int MAX = (int) Math.pow(10, k);
        for (int i = 1; i < MAX; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == a || num % 10 == b) {
                    count += num % 10;
                } else {
                    break;
                }
                num = num / 10;
            }
            while (count > 0) {
                if (count % 10 == a || count % 10 == b) {
                } else {
                    break;
                }
                count = count / 10;
            }
            ans++;
        }
        return ans;
    }
}
