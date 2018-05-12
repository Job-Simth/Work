package com.krokky.pro0421;

import com.krokky.pro0421.陈幸.Addition;

public class Test {
    public static void main(String[] args) {
        Addition i =new Addition();
        System.out.println(i.add(1,2));
        System.out.println(i.add(124204L,2042044L));
        System.out.println(i.add(1.01F,2.01F));
        System.out.println(i.add(1.0001414,2.0141414));
        System.out.println(i.add("OJ","BK"));
    }
}
