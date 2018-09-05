package com.krokky.leetcode_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * 写一个程序，输出从 1 到 n 数字的字符串表示。
 * 1. 如果 n 是3的倍数，输出“Fizz”；
 * 2. 如果 n 是5的倍数，输出“Buzz”；
 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
 */

class Solution999 {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i + "");
            if (i % 3 == 0 && i % 5 != 0) {
                list.remove(i - 1);
                list.add("Fizz");
            }
            if (i % 5 == 0 && i % 3 != 0) {
                list.remove(i - 1);
                list.add("Buzz");
            }
            if (i % 3 == 0 && i % 5 == 0) {
                list.remove(i - 1);
                list.add("FizzBuzz");
            }
        }
        return list;
    }
}

public class 字符替换 {
    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            List<String> ret = new Solution999().fizzBuzz(n);

            String out = stringListToString(ret);

            System.out.print(out);
        }
    }
}