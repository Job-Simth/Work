package com.krokky.leetcode_Practice;

import java.util.Arrays;

public class ZipWord {
    public static void main(String[] args) {
        char[] c = {'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd'};
        int length = c.length - 1;
        int count = 1;
        int temp = 0;
        for (int i = 0; i < length - 1; ++i) {
            if (c[i] == c[i + 1]) {
                ++count;
            } else {
                temp = Write(c, count, temp, i);
                count = 1;
            }
        }
        System.out.println(temp);
        System.out.println(Arrays.toString(c));
    }

    private static int Write(char[] c, int count, int temp, int i) {
        final int IntToChar = 48;
        c[temp] = c[i];
        temp++;
        if (count > 1) {
            if (count < 10) c[temp] = (char) (count + IntToChar);
            else if (count < 100) {
                c[temp] = (char) (count / 10 + IntToChar);
                c[++temp] = (char) (count % 10 + IntToChar);
            } else if (count < 1000) {
                c[temp] = (char) (count / 100 + IntToChar);
                c[++temp] = (char) (count / 10 % 10 + IntToChar);
                c[++temp] = (char) (count / 100 % 10 + IntToChar);
            } else if (count == 1000) {
                c[temp] = (char) (1 + IntToChar);
                c[++temp] = (char) (0 + IntToChar);
                c[++temp] = (char) (0 + IntToChar);
                c[++temp] = (char) (0 + IntToChar);
            }
        }
        return ++temp;
    }
}
