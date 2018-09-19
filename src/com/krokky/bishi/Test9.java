package com.krokky.bishi;

public class Test9 {
    public static int Solution(int[] array) {
        int count = 0;

        if (array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            int sum = 4;
            while (array[i] >= sum) {
                if (array[i] == sum) {
                    count++;
                }
                sum *= 4;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 4, 64, 16};
        System.out.println(Solution(array));
    }
}
