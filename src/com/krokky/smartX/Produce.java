package com.krokky.smartX;

public class Produce {
    private FruitGrower fruitGrower;

    public Produce(FruitGrower fruitGrower) {
        this.fruitGrower = fruitGrower;

        fruitGrower.plant();
        fruitGrower.grow();
    }

    public Fruit getFruitGrower(Fruit fruit) {
        return fruitGrower.harvest();
    }

    public void setFruitGrower(FruitGrower fruitGrower) {
        this.fruitGrower = fruitGrower;
    }

    @Override
    public String toString() {
        return "Produce{" +
                "fruitGrower=" + fruitGrower +
                '}';
    }
}
