package com.krokky.bishi;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int t = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scan.nextInt();
        }
        int res = find(nums, k, t);
        System.out.println(res);
    }

    private static int find(int[] nums, int k, int t) {
        int res = 0;
        if (k > nums.length) {
            return res;
        }
        for (int i = 0; i < nums.length - k + 1; ++i) {
            Map<Integer, Integer> help = new HashMap<>();
            boolean bool = false;
            for (int j = 0; j < k; ++j) {
                if (help.containsKey(nums[j + i])) {
                    int e = help.get(nums[j + i]);
                    help.put(nums[j + i], e + 1);
                } else {
                    help.put(nums[j + i], 1);
                }

            }
            for (Integer value : help.values()) {
                bool = value >= t;
                if (bool) {
                    break;
                }
            }
            if (bool) {
                res++;
            }
        }
        return res;
    }
}