package com.krokky.pro0513;
//阻塞的两个常见方法
public class DemonE {
    public static void main(String[] args) {
        DemonEA ea = new DemonEA();
        ea.start();
        DemonEB eb = new DemonEB();
        eb.start();
    }
}
class DemonEA extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);//将线程睡眠两秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class DemonEB extends Thread{
    @Override
    public synchronized void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
            try {
                wait(1000);//等待，需要实现线程同步
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}