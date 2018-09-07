package com.krokky.bishi;

public class Test {

    public enum Color {
        RED(0xff0000), GREEN(0x00ff00), BLUE(0x0000ff);


        private final int color;

        Color(int color) {
            this.color = color;
        }

        public int getColor() {
            return this.color;
        }
    }

    public static void main(String[] args) {
        Color heart = Color.RED;
        System.out.println(heart);
    }
}
