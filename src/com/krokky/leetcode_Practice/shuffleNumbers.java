package com.krokky.leetcode_Practice;

import java.util.Arrays;
import java.util.Random;

class Solution10 {
    private int[] origin;
    private int[] current;

    public Solution10(int[] nums) {
        origin = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int tmp;
        int value;
        current = new int[origin.length];
        for (int i = 0; i < origin.length; i++) {
            current[i] = origin[i];
        }
        Random random = new Random();
        for (int i = current.length - 1; i >= 0; i--) {
            value = random.nextInt(i + 1);
            tmp = current[value];
            current[value] = current[i];
            current[i] = tmp;
        }
        return current;
    }
}

public class shuffleNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution10 solution10 = new Solution10(nums);
//        for (int i:A
//             ) {
//            System.out.println(i);
//        }
        while (true)
            System.out.println(
                    Arrays.toString(solution10.shuffle()) + " " +
                            Arrays.toString(solution10.reset()));
    }
}
