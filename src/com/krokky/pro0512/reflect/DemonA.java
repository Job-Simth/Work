package com.krokky.pro0512.reflect;

import com.krokky.pro0512.d.Demo;

public class DemonA {
    public static void main(String[] args) {
        try {
            Class c1 = Class.forName("com.krokky.pro0512.d.Demo");//用的最多
            Class c2 = new Demo().getClass();
            Class c3 = Demo.class;
            Class c4 = Character.TYPE;

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
        } catch (ClassNotFoundException e) {
            System.out.println("未找到");
        }
    }
}
