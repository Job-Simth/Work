package com.krokky.pro0421;

public class interfaceDemo {
    public static void main(String[] args) {
        Bike bike =new Bike();
        Bus bus =new Bus();
        bike.start("自行车");
        bike.stop("自行车");
        bus.start("公交车");
        bus.stop("公交车");
    }
}

interface Vehicle {
    public  abstract void start(String s);
    public  abstract void stop(String s);
}
class Bike implements Vehicle{

    @Override
    public void start(String s) {
        System.out.println(s+"开车");
    }

    @Override
    public void stop(String s) {
        System.out.println(s+"停车");
    }
}
class Bus implements Vehicle{

    @Override
    public void start(String s) {
        System.out.println(s+"开车");
    }

    @Override
    public void stop(String s) {
        System.out.println(s+"停车");
    }
}