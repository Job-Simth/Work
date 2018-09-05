package com.krokky.leetcode_Practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 暴力遍历
 */
//class Solution {
//    public static int[] twoSum(int[] nums, int target) {
//        int[] answer = new int[2];
//        if (nums == null || nums.length < 2)
//            return answer;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    answer[0] = i;
//                    answer[1] = j;
//                    return answer;
//                }
//            }
//        }
//        return null;
//    }
//}

/**
 * 本来是需要先将数值加入到HashMap中再查找，可以优化为
 * 一次查找再加入HashMap
 */
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

public class leetcode001 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] anwser = new Solution1().twoSum(nums, 9);
        System.out.println(Arrays.toString(anwser));
    }
}
