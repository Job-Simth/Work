package com.krokky.pro0513;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemonD {
    public Map<String, List<Integer>> map;

    public DemonD() {
        map = new HashMap<>();
        for (int i = 65; i < 75; i++) {
            char a = (char) i;
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                int m = (int) (Math.random() * 500);
                list.add(m);
            }
            map.put(a + "", list);
        }
    }

    public static void main(String[] args) {
        DemonD d = new DemonD();
        int num = 97;
        for (char i = 65; i < 75; i++) {
            ListThread lt = new ListThread(i + "", d.map, num);
            lt.start();
        }
    }
}

class ListThread extends Thread {
    private String key;//指定哪个集合
    private Map<String, List<Integer>> map;//大集合
    private Integer num;//需要判断的数字

    public ListThread(String key, Map<String, List<Integer>> map, Integer num) {
        this.key = key;
        this.map = map;
        this.num = num;
    }

    @Override
    public void run() {
        List<Integer> list = map.get(key);
        for (Integer i : list) {
            System.out.println("在" + key + "集合中匹配：" + num);
            if (i == num) {
                System.out.println("在" + key + "集合中找到了");
                break;
            }
        }
    }
}