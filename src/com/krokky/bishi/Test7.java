package com.krokky.bishi;

public class Test7 {
    public static void main(String[] args) {
        int[] values = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int place = 0;
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
                place = i;
            }
        }
        System.out.println(water(values, place));
    }

    public static int water(int[] values, int place) {
        int ans = 0;
        int temp = values[0];
        for (int i = 1; i < place; i++) {
            if (values[i] <= temp) {
                ans += temp - values[i];
            } else {
                temp = values[i];
            }
        }
        temp = values[values.length - 1];
        for (int i = values.length - 2; i > place; i--) {
            if (values[i] <= temp) {
                ans += temp - values[i];
            } else {
                temp = values[i];
            }
        }
        return ans;
    }
}