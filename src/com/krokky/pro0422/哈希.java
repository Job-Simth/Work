package com.krokky.pro0422;

import java.util.*;

public class 哈希 {
    public void a() {
        Set<Integer> set1 = new HashSet<>();//空集
        Set<Integer> set2 = new HashSet<>(set1);//创建集合，内容为指定set
    }

    public void b() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(1);
        Set<Integer> set = new HashSet<>();
        set.add(7);//添加
        set.add(5);
        set.addAll(list);//复制，批量添加

        set.forEach(System.out::println);
    }

    public void c() {
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(1);
        set.add(2);

        Object[] arr = set.toArray();//转数组
        List<Integer> list = new ArrayList<>(set);
        list.forEach(System.out::println);
    }

    public void d() {
        Set<ClassInfo> set = new HashSet<>();
        ClassInfo ci1 = new ClassInfo(1, "软件1班", 23);
        ClassInfo ci2 = new ClassInfo(2, "软件2班", 25);
        ClassInfo ci3 = new ClassInfo(3, "软件3班", 27);
        ClassInfo ci4 = new ClassInfo(4, "软件4班", 30);
        ClassInfo ci5 = ci2;
        ClassInfo ci6 = new ClassInfo(6, "软件6班", 35);
        set.add(ci1);
        set.add(ci2);
        set.add(ci3);
        set.add(ci4);
        set.add(ci5);
        set.add(ci6);
        set.add(ci3);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        set.forEach(System.out::println);
        System.out.println("---------------------------------------");
        Set<ClassInfo> set1 = new TreeSet<>(set);
        set1.forEach(System.out::println);
        System.out.println("---------------------------------------");
        List<ClassInfo> set2 = new ArrayList<>(set);
        Collections.sort(set2);
        set2.forEach(System.out::println);
    }

    public static void main(String[] args) {
        new 哈希().d();
    }
}
