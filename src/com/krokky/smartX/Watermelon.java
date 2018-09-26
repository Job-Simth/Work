package com.krokky.smartX;

public class Watermelon extends Fruit {

    private SeedType seedType;

    public Watermelon(SeedType seedType) {
        this.seedType = seedType;
    }

    public SeedType getSeedType() {
        return seedType;
    }

    public void setSeedType(SeedType seedType) {
        this.seedType = seedType;
    }

    @Override
    public String toString() {
        return "Watermelon{" +
                "seedType=" + seedType +
                '}';
    }

}