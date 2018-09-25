package com.krokky.bishi;

import java.util.*;

public class Main implements Comparable<Main> {

    private int W;
    private int L;

    public int getW() {
        return W;
    }

    public void setW(int w) {
        W = w;
    }

    public int getL() {
        return L;
    }

    public void setL(int l) {
        L = l;
    }

    public Main(int w, int l) {
        W = w;
        L = l;
    }

    public static int findFloor(int n, List<Main> list) {
        int count = 1;

        for (int i = 1; i < n; i++) {
            Main x = list.get(i - 1);
            Main y = list.get(i);
            if (x.getW() <= y.getW() && x.getL() <= y.getL()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Main> list = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();


        for (int i = 0; i < n; i++) {
            list.add(new Main(s.nextInt(), s.nextInt()));
        }

//        int n = 5;
//
//        list.add(new Main(2, 2));
//        list.add(new Main(2, 4));
//        list.add(new Main(3, 3));
//        list.add(new Main(2, 5));
//        list.add(new Main(4, 5));

        Collections.sort(list);


        System.out.println(findFloor(n, list));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Main Main = (Main) o;
        return W == Main.W &&
                L == Main.L;
    }

    @Override
    public int hashCode() {

        return Objects.hash(W, L);
    }

    @Override
    public int compareTo(Main o) {
        if (this.W == o.getW()) {
            return this.L - o.L;
        } else {
            return this.W - o.getW();
        }
    }

    @Override
    public String toString() {
        return "W=" + W + "L=" + L;
    }
}
