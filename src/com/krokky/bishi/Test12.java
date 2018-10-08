package com.krokky.bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int m = s.nextInt();
//        int a = s.nextInt();
//        int b = s.nextInt();
//        int len = s.nextInt();

        int m = 3;
        int a = 1;
        int b = 2;
        int len = 0;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(s.nextInt());
        }

        int ans = climbStairs(m, a, b, set);
        System.out.println(ans);
    }


    public static int climbStairs(int n, int a, int b, Set broken) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        if (n > 0) {
            ans[1] = 1;
        }
        if (n >= 2) {
            for (int i = 2; i < ans.length; i++) {
                if (broken.contains(ans[i - 1]) || broken.contains(ans[i - 1])) {
                    break;
                }
                ans[i] = ans[i - a] * ans[i - b];
            }
        }
        return ans[n];
    }
}

