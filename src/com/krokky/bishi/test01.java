package com.krokky.bishi;

public class test01 {
    public static void main(String[] args) {
        System.out.println(B.c);
    }
}

class A {


    static {
        System.out.println("A");
    }
}

class B extends A {
    public static String c = "C";

    static {
        System.out.println("B");
    }
}