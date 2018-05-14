package com.krokky.pro0513.builderAndUser;

public class 生产者 extends Thread{
    private 经销商 j;

    public 生产者(经销商 j) {
        this.j = j;
    }

    @Override
    public void run() {
        for (int i = 1; i < 21; i++) {
            商品 s = new 商品(i);
            System.out.println("生产了"+s);
            j.进货(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
