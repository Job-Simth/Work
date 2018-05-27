package com.krokky.Test;


public class Son {
    public static void main(String[] args) {
        String str4 =new StringBuilder("hello").append("world").toString();
        System.out.println(str4.intern()==str4);
        String str5 = new StringBuilder("ja").append("va").toString();
        System.out.println(str5.intern()==str5);
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }
}