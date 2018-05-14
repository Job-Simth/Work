package com.krokky.pro0513;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//第三种线程的实现可以获取到线程的返回值
public class DemonC {
    public static void main(String[] args) {
        try {
            DemonCA a = new DemonCA();//产生类对象
            DemonCB b = new DemonCB();
            FutureTask<Integer> ta = new FutureTask<>(a);//将类对象包装
            FutureTask<Integer> tb = new FutureTask<>(b);

            Thread threadA = new Thread(ta);//新建状态，产生了线程对象
            Thread threadB = new Thread(tb);

            threadA.start();//线程就绪
            threadB.start();

            Integer ia = ta.get();//获取到了线程的返回值
            Integer ib = tb.get();

            System.out.println(ia + "\t" + ib);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class DemonCA implements Callable<Integer> {

    @Override
    public Integer call() {
        int i = 1;
        for (; i < 11; i++) {
            System.out.println("A:" + i);
        }
        return i;
    }
}

class DemonCB implements Callable<Integer> {

    @Override
    public Integer call() {
        int i = 1;
        for (; i < 11; i++) {
            System.out.println("B:" + i);
        }
        return i;
    }
}