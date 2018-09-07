package com.krokky.bishi;

public class Killer {

    public static int kill(int[] a, int k, int day) {
        if (k == 1) {
            return 0;
        }
        int j = 1;
        for (int i = 1; i < k - 1; i++) {
            if (a[i] <= a[i + 1]) {
                a[j] = a[++i];
                j++;
            }
        }

        if (j > 1) {
            return kill(a, j, day + 1);
        } else {
            return day + 1;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(kill(a, a.length, 0));
    }
}
