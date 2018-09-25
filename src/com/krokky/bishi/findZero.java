package com.krokky.bishi;

public class findZero {
    public static void main(String[] args) {
        int n = 666;
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n = n / 5;
        }
        System.out.println(count);
    }
}
