package com.krokky.bishi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[][] ans;
        int a = 0;
        int b = 0;
        int c = 0;
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    c = nums[k];
                    if (0 == a + b + c) {
                        set.add(a + "," + b + "," + c);
                    }
                }
            }
        }
        for (String s : set) {
            System.out.println(s);
        }
    }
}
