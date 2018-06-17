package com.krokky.线程;

public class DemonB {
    public static void main(String[] args) {
        DemonBA a = new DemonBA();
        DemonBB b = new DemonBB();
        //必学借助Tread类，将实现了runnable接口的对象初始化
        Thread ta = new Thread(a);
        Thread tb = new Thread(b);
        ta.start();
        tb.start();
    }
}
//好处：接口可以多继承 缺点：必须借助Tread类实现
class DemonBA implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("A:"+i);
        }
    }
}
class DemonBB implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("B:"+i);
        }
    }
}
