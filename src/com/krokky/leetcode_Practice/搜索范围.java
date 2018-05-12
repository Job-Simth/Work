package com.krokky.leetcode_Practice;

class Solution4 {
    public int[] searchRange(int[] nums, int target) {
        return search2(nums, target);    //非递归
        /*
        //递归
        //空数组
        int start = -1;
        int end = -1;
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        //单一数组
        else if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        } else {
            start = search(nums, target, nums.length - 1, 0);
            if (start != -1)
                end = search(nums, target, nums.length - 1, start);
        }
        return new int[]{start, end};
        */
    }

    public int[] search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int start = -1;
        int end = -1;
        //空数组
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        //单一数组
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }
        //找头
        while ((low + 1) < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (nums[low] == target) {
            start = low;
        } else if (nums[high] == target) {
            start = high;
        }
        //找尾
        low = 0;
        high = nums.length - 1;
        while ((low + 1) < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (nums[high] == target) {
            end = high;
        } else if (nums[low] == target) {
            end = low;
        }
        // 校验 : [-1, -1] , [-1, end], [start, -1]
        if (start == -1) {
            start = end;
        }
        if (end == -1) {
            end = start;
        }
        return new int[]{start, end};
    }

    public int search(int[] nums, int target, int high, int low) {
        int midValue = (high + low) / 2;
        if (target < nums[low] || target > nums[high] || high <= (low + 1)) {
            if (nums[low] == target) {
                return low;
            } else if (nums[high] == target) {
                return high;
            } else return -1;
        }
        if (nums[midValue] > target) {
            return search(nums, target, midValue, low);
        } else if (nums[midValue] < target) return search(nums, target, high, midValue);
        else return midValue;
    }
}

public class 搜索范围 {
    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 5, 5, 6, 6, 6, 9, 9};
        int target = 6;
        int[] ret = new Solution4().searchRange(nums, target);

        String out = integerArrayToString(ret);

        System.out.print(out);
    }
}
