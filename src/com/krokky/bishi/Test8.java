package com.krokky.bishi;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        int ans = findNum();
        System.out.println(ans);
    }

    public static int findNum() {
        int ans[] = {0, 0};
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String[] strs = str.split(" ");
        if (strs.length == 0) {
            return 0;
        }
        int[] temp = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].matches("^[0-9]*$")) {
                temp[i] = Integer.parseInt(strs[i]);
            }
        }


        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {
                ans[0] += temp[i];
            } else if (temp[i] == 0) {
                ans[0] += temp[i];
                if (ans[0] > ans[1]) {
                    ans[1] = ans[0];
                }
                ans[0] = 0;
            }
        }
        return Math.max(ans[0], ans[1]);
    }
}
