package com.krokky.pro0513.builderAndUser;

public class Main {
    public static void main(String[] args) {
        经销商 j = new 经销商();
        消费者 x = new 消费者(j);
        生产者 s = new 生产者(j);

        s.start();
        x.start();
    }
}
