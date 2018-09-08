package com.krokky.bishi;

import java.util.Scanner;

public class Test5 {

    public static int[][] function(int[][] m) {
        int[][] ans = new int[m.length][2];

        for (int i = 0; i < m.length; i++) {
            ans[i][0] = 0;
            if (m[i][1] == 0) {
                ans[i][1] = 0;
            } else if (m[i][1] < ((m[i][0] + 1) / 2)) {
                ans[i][1] = m[i][1] - 1;
            } else if (m[i][1] > ((m[i][0] + 1) / 2)) {
                ans[i][1] = m[i][0] - m[i][1];
            } else if (m[i][1] == ((m[i][0] + 1) / 2) && m[i][0] % 2 == 0) {
                ans[i][1] = m[i][1] - 1;
            } else if (m[i][1] == ((m[i][0] + 1) / 2) && m[i][0] % 2 == 1) {
                ans[i][1] = m[i][0] - m[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[][] m = new int[a][2];

        for (int i = 0; i < a; i++) {
            m[i][0] = scanner.nextInt();
            m[i][1] = scanner.nextInt();
        }

        int[][] value = function(m);

        for (int[] i : value) {
            System.out.println(i[0] + " " + i[1]);
        }

    }
}
