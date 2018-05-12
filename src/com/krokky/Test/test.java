package com.krokky.Test;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int[] a = {1, 100, 23, 565, 156};
        int j = a.length;
        for (int i = 0; i < j; ) {
            System.out.println(Arrays.toString(a));
            j--;
        }
    }
}
