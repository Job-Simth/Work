package com.krokky.smartX;

public class Apple extends Fruit {
    private Color color;

    public Apple(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color=" + color +
                '}';
    }
}
