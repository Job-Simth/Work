package com.krokky.bishi;

public class Test8 {
    public static void main(String[] args) {
        Base b = new Subclass();
        System.out.println(b.x);
        System.out.println(b.method());
    }

    static class Base {
        int x = 2;

        int method() {
            return x;
        }
    }

    static class Subclass extends Base {
        int x = 3;

        @Override
        int method() {
            return x;
        }
    }
}
