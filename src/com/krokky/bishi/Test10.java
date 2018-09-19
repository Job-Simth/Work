package com.krokky.bishi;

public class Test10 {
    public int truckCount(int truckLoadLimit, int[] weights) {

        for (int i = 0; i < truckLoadLimit; i++) {
            for (int j = 0; j < weights.length; j++) {
                weights[j]--;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}
