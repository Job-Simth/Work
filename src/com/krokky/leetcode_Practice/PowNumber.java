package com.krokky.leetcode_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution55 {
    public double myPow(double x, int n) {
        double answer = 1;
        long n_abs = Math.abs((long) n);
        double x_abs = Math.abs(x);
        if (n == 0)
            return answer;
        if (x_abs == 1 && n_abs % 2 != 0)
            return x;
        if (x_abs == 1 && n_abs % 2 == 0)
            return x_abs;
        if (n_abs > 999999)
            return 0.0;
        if (n_abs % 2 == 0) {
            for (int i = 0; i < n_abs / 2; i++) {
                answer *= (x * x);
            }
        } else {
            for (int i = 0; i < n_abs / 2; i++) {
                answer *= (x * x);
            }
            answer *= x;
        }
        if (n < 0) {
            return (1.0 / answer);
        }
        return answer;
    }
}

public class PowNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            double x = Double.parseDouble(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            double ret = new Solution55().myPow(x, n);

            System.out.println(ret);
        }
    }
}