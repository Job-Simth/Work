package com.krokky.smartX;

public class Main {
    public static void main(String[] args) {
        Fruit fruit = new Apple(Color.green);
        FruitGrower fruitGrower = new FruitGrower(fruit);
        Produce p = new Produce(fruitGrower);
        p.getFruitGrower(fruit);
    }
}
