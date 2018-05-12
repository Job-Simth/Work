package com.krokky.pro0422;

import java.util.LinkedList;

public class LinkedListDemon {
    public void a(){
        LinkedList<Integer> list =new LinkedList<>();
//        LinkedList<Integer> list1 =new LinkedList<>(list);
        //加入元素的方法
        list.add(1);
        list.addFirst(3);
        list.add(1,2);
        list.addLast(4);
        //获取元素的方法
        int i = list.get(2);
        int j = list.getFirst();
        int k = list.getLast();
        //删除元素的方法
        list.remove(1);
        list.removeFirst();
        list.removeLast();
        list.remove(Integer.valueOf(1));
        list.clear();
        //
    }
    public static void main(String[] args) {
        new LinkedListDemon().a();
    }
}
