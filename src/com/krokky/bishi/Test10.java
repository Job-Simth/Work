package com.krokky.bishi;

import java.util.ArrayList;
import java.util.List;

public class Test10 {
    public List lists = new ArrayList();

    public synchronized void add(String name) {
        lists.add(name);
    }

    public synchronized void printAll() {
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i) + "");
        }
    }

    public static void main(String[] args) {
        final Test10 t = new Test10();
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    t.add("A");
                    t.add("B");
                    t.add("C");
                    t.printAll();
                }
            }.start();
        }
    }
}
