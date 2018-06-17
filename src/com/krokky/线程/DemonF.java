package com.krokky.线程;

public class DemonF {
    public static void main(String[] args) {
        DemoFA a = new DemoFA();

        DemoFB b = new DemoFB();
        b.setDaemon(true);
        a.start();
        b.start();
    }
}

class DemoFA extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A" + (i + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class DemoFB extends Thread {
    @Override
    public void run() {
        //setDaemon(true);//设置为后台线程
        while (true) {
            System.out.println("B");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}