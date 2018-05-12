package com.krokky.pro0422;

import java.util.*;

public class G {
    public void a() {
        //Map结构：键值对结构，k->v
        //K:key的缩写，代表唯一标示，别名
        //V:value的缩写，代表确切的“值”
        //Map<K,V> map = new HashMap<K,V>();
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("张三", 5);
        map1.put("李四", 5);
        map1.put("王五", 5);
        map1.put("王五", 8);//后面的会把前面的覆盖

        Integer v1 = map1.get("张三");
        Integer v2 = map1.get("李四");
        Integer v3 = map1.get("王五");
        System.out.println(v1 + "\t" + v2 + "\t" + v3);

        Set<String> keys = map1.keySet();
        Collection<Integer> value = map1.values();

        int len = map1.size();
        System.out.println(len);

        boolean b1 = map1.containsKey("张三");
        boolean b2 = map1.containsValue(2);

        System.out.println(b1 + "\t" + b2);

        for (Integer i : value) {
            System.out.println(i);
        }
        for (String s : keys) {
            System.out.println(s);
        }

        map1.clear();//清空所有
        map1.remove("张三");//清空某个值

        System.out.println(Arrays.toString(keys.toArray()));
        System.out.println(Arrays.toString(value.toArray()));
    }

    public static void main(String[] args) {
        new G().a();
    }
}
