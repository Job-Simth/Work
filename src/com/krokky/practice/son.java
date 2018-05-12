package com.krokky.practice;

public class son extends father {
    private son() {
        super("李四");
        System.out.println("子类被创建了");
    }

    public static void main(String[] args) {
        son s = new son();
        System.out.println(s.toString());
    }
}
