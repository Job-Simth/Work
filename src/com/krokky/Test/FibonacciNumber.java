package com.krokky.Test;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FibonacciNumber().Fibonacci(0, 1, 10)));
    }

    public int[] Fibonacci(int i, int j, int count) {
        int temp = j;
        j = i + j;
        i = temp;
        System.out.println(i+"\t"+j);
        if (count <=1) {
            return new int[]{i, j};
        } else return Fibonacci(i, j, --count);
    }
}