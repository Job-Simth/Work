package com.krokky.bishi;

import java.util.*;

public class findNum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        Map<Integer, String> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        while (!"END".equals(str)) {
            String[] a = str.split("#");
            int m = Integer.valueOf(a[1], Integer.parseInt(a[0]));
            if (!map.containsKey(m)) {
                map.put(m, str);
                list.add(m);
            } else {
                map.put(m, "true");
            }
            str = s.nextLine();
        }
        boolean bool = false;
        for (Integer aList : list) {
            if (!"true".equals(map.get(aList))) {
                bool = true;
                System.out.println(map.get(aList));
            }
        }
        if (!bool) {
            System.out.println("None");
        }
    }
}