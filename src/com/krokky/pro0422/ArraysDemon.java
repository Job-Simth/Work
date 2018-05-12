package com.krokky.pro0422;

import java.util.ArrayList;
import java.util.List;

public class ArraysDemon {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        //判空
        boolean b = list.isEmpty();
        System.out.print(b+" ");

        //set方法会更改当前的值，null就是"null"字符串，set的返回值为更改的原元素
        String s = list.set(1, null);
        System.out.print(s+" ");

        //删除对应元素，删除带对象的时，不会删除对象，只会检测是否含有此元素，返回布尔值
        list.remove(2);
        System.out.print(list.size()+" ");
        System.out.println(list.remove(list.get(3)));

        Object[] arr = list.toArray();
        for (Object o : arr
                ) {
            System.out.println(o);
        }

        list.clear();
        System.out.println(list.size());

//        list.forEach(System.out::println);
//        List<String> list2 = new ArrayList<>(list);
//        System.out.println("\n" + list.size());
//        list2.forEach(e -> System.out.print(e + " "));
    }
}
