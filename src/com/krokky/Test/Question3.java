package com.krokky.Test;

import java.util.*;

public class Question3 {
    public void useMap() {
        int i = 20070301;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int j = 0; j < 30; i++, j++) {
            map.put(i, (int) (Math.random() * 40 + 60));
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //然后通过比较器来实现排序
//        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<Integer, Integer> mapping : list) {
            System.out.println("学号：" + mapping.getKey() + "成绩:" + mapping.getValue());
        }
    }

    public void useSet() {
        int i = 20070301;
        TreeSet<student> ts = new TreeSet<>();
        for (int j = 0; j < 30; i++, j++) {
            ts.add(new student(i, (int) (Math.random() * 40 + 60)));
        }
        for (student s : ts) {
            System.out.println("学号：" + s.getNumber() + "成绩:" + s.getValue());
        }
    }

    public void useList() {
        int i = 20070301;
        List<student> list = new ArrayList<>();
        for (int j = 0; j < 30; i++, j++) {
            list.add(new student(i, (int) (Math.random() * 40 + 60)));
        }
        Collections.sort(list);
        for (student s : list) {
            System.out.println("学号：" + s.getNumber() + "成绩:" + s.getValue());
        }
    }

    public static void main(String[] args) {
        new Question3().useMap();
    }
}

class student implements Comparable<student> {
    private int Number;
    private int Value;

    public student(int number, int value) {
        Number = number;
        Value = value;
    }

    public int getNumber() {
        return Number;

    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }


    @Override
    public int compareTo(student s) {
        return this.Value - s.Value;
    }
}