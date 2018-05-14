package com.krokky.pro0512.d;

import java.lang.reflect.Type;

public class DemonA {
    public static void main(String[] args) {
        try {
            // 如何获取到类
            Class c1 = Class.forName("com.krokky.pro0512.d.Demon");// 用的最多的
            Class c2 = new Demon().getClass();
            Class c3 = Demon.class;
            Class c4 = Character.TYPE;// 这种方式只能8大原始类型的封装类使用

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);

            String s = c1.getName();
            Package p = c1.getPackage();
            Type superClass = c1.getGenericSuperclass();

            boolean b1 = c1.isArray();
            boolean b2 = c1.isAssignableFrom(c4);
            boolean b3 = c1.isInterface();

            System.out.println(s);
            System.out.println(p);
            System.out.println(superClass);

            System.out.println(b1 + "\t" + b2 + "\t" + b3);

        } catch (ClassNotFoundException e) {
            System.out.println("类名写错了!");
        }

    }
}
