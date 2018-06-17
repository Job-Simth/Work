package com.krokky.线程;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class DemonG {
    public static void main(String[] args) {
        //定时器
        Timer timer = new Timer();

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("aaa");
//            }
//        }, 0, 100);
        //timer.schedule(操作，延迟)
        //timer.schedule(操作，延迟，间隔)
        //timer.schedule(操作，时间)
        //timer.schedule(操作，时间，间隔)

        DemonGA a =new DemonGA();

        Date date = new Date(new Date().getTime()+2000);
        System.out.println(date);
        timer.schedule(a,date,1000);
    }
}
//操作类->定时器中的操作类
class DemonGA extends TimerTask{
    @Override
    public void run() {
        System.out.println("执行了操作 "+new Date(new Date().getTime()));
    }
}