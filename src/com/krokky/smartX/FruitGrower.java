package com.krokky.smartX;

public class FruitGrower {
    private Fruit fruit;

    public FruitGrower(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return "FruitGrower{" +
                "fruit=" + fruit +
                '}';
    }

    public void plant() {
        System.out.println("种植" + this.getFruit());
    }

    public void plant(Fruit fruit) {
        System.out.println("种植");
    }

    public void grow() {
        System.out.println("培育");
    }

    public Fruit harvest() {
        System.out.println("收获");
        return fruit;
    }
}
