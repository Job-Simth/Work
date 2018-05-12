package com.krokky.pro0422;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int a = (int) (Math.random() * 100 + 1);
            list.add(a);
        }
        System.out.println("原集合的值：");
        list.forEach(e -> System.out.print(e + "\t"));
        System.out.println();

        Collections.sort(list);
        System.out.println("排序后集合的值：");
        list.forEach(e -> System.out.print(e + "\t"));
    }
}
