package com.krokky.pro0513.builderAndUser;

import java.util.ArrayList;
import java.util.List;

//容器
public class 经销商 {

    private List<商品> list = new ArrayList<>();
    private int max = 5;//经销商只能存放十个货物

    public synchronized 商品 售卖() {
        while (list.size() == 0) {
            System.out.println("现在没货了，需要等待");
            try {
                wait();//现在没货了，需要等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //当唤醒时
        notify();

        商品 s = list.get(0);
        list.remove(0);
        return s;
    }

    public synchronized void 进货(商品 s) {
        while (list.size() >= max) {
            System.out.println("仓库满了，请不要生产");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
        list.add(s);
    }
}
