package com.krokky.Test;

import java.util.Arrays;

public class BigArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 8};
        int b = 5;
        int[] answer = new BigArray().add(a, b);
        System.out.println(Arrays.toString(answer));
    }

    public int[] add(int[] a, int b) {
        int[] added = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            added[i] = a[i];
        }
        added[a.length] = b;
        return added;
    }
}
