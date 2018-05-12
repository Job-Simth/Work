package com.krokky.pro0512.a;

public class School implements Intro{
    private Print print = new Print();

    public String detail(){
        return "我是学校";
    }

    public void print(Intro intro) {
        print.print(intro.detail());
    }
}
