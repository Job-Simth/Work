package com.krokky.leetcode_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution6 {
    public int mySqrt(int x) {
        int answer = 0;
        if (x == 0 || x == 1)
            return x;
        for (long i = 0; (i*i) <= x; i++) {
            answer = (int)i;
        }
        return answer;
    }
}

public class IntSqrt {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution6().mySqrt(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}