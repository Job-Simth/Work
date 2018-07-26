package com.krokky.Test;

public class Test {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}

class SuperClass {
    public final static int value = 123;

    static {
        System.out.println("---SuperClass init---");
    }
}

class SubClass extends SuperClass {
    static {
        System.out.println("---SubClass init---");
    }
}

//SuperClass[] arr = new SuperClass[10];
//        System.out.println(arr.toString());