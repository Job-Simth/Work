package com.krokky.leetcode_Practice;

public class ZipWord {
    public static void main(String[] args) {
        char[] chars = {'a'};
        int i = new Solution80().compress(chars);
        for (int j = 0; j < i; j++) {
            System.out.print(chars[j]+" ");
        }
    }
}

class Solution80 {
    public int compress(char[] chars) {
        int count = 1;
        int temp = 0;
        for (int i = 0; i <chars.length; ++i) {
            if (i + 1 == chars.length) {
                temp = Write(chars, count, temp, i);
                count = 1;
            } else if (chars[i] == chars[i + 1]) {
                ++count;
            } else {
                temp = Write(chars, count, temp, i);
                count = 1;
            }
        }
        return temp;
    }


    private static int Write(char[] chars, int count, int temp, int i) {
        final int IntToChar = 48;
        chars[temp] = chars[i];
        ++temp;
        if (count == 1) {
            return temp;
        } else if (count > 1 && count < 10) chars[temp] = (char) (count + IntToChar);
        else if (count < 100) {
            chars[temp] = (char) (count / 10 + IntToChar);
            chars[++temp] = (char) (count % 10 + IntToChar);
        } else if (count < 1000) {
            chars[temp] = (char) (count / 100 + IntToChar);
            chars[++temp] = (char) (count / 10 % 10 + IntToChar);
            chars[++temp] = (char) (count / 100 % 10 + IntToChar);
        } else if (count == 1000) {
            chars[temp] = (char) (1 + IntToChar);
            chars[++temp] = (char) (0 + IntToChar);
            chars[++temp] = (char) (0 + IntToChar);
            chars[++temp] = (char) (0 + IntToChar);
        }
        return ++temp;
    }
}

