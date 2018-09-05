package com.krokky.leetcode_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*实现一个数组自增，带进位
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 输入[9]
 * 输出[1,0]
 * 解释: 输入数组表示数字 10。
 */

class Solution99 {
    public int[] plusOne(int[] digits) {
        int[] temp = new int[digits.length + 1];
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1]++;
            }
        }
        if (digits[0] == 10) {
            for (int i = 0; i < digits.length - 1; i++) {
                temp[i + 1] = digits[i];
            }
            temp[0] = 1;
            temp[1] = 0;
            return temp;
        }
        return digits;
    }
}

public class 数组求和 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] digits = stringToIntegerArray(line);

            int[] ret = new Solution99().plusOne(digits);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}