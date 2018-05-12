package com.krokky.pro0422;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class D {
    public void a() {

        Set<String> set = new TreeSet<>();
        set.add("陕西");
        set.add("山西");
        set.add("山东");
        set.add("陕西");
        set.add("湖南");
        System.out.println(set.size());
        set.forEach(e -> System.out.print(e + "\t"));
    }

    public void b() {
        Set<Integer> set = new TreeSet<>();
        set.add((int) (Math.random() * 100));
        set.add((int) (Math.random() * 100));
        set.add((int) (Math.random() * 100));
        set.add((int) (Math.random() * 100));
        set.add((int) (Math.random() * 100));
        set.add((int) (Math.random() * 100));

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
//        set.forEach(System.out::println);
    }

    public void d2() {
        Set<Person> set = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            Person p = new Person(i);
            set.add(p);
        }
        boolean b = set.contains(new Person(1));
        System.out.println(b);
    }

    public static void main(String[] args) {
        new D().d2();
    }
}

