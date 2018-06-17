package com.krokky.线程;
//创建线程的方式一
public class DemonA {
    public static void main(String[] args) {
        DemonAA a= new DemonAA();
        DemonAB b= new DemonAB();
        a.start();
        b.start();
    }
}
//好处：new出来直接可以用 缺点：继承只能单继承
class DemonAA extends Thread{
    @Override
    public void run() {//当执行时，进入运行状态
        for (int i = 1; i < 11; i++) {
            System.out.println("A:"+i);
        }
    }//死亡状态
}
class DemonAB extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("B:"+i);
        }
    }
}