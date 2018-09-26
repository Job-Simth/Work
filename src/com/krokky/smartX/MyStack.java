package com.krokky.smartX;

public class MyStack<T> {
    //初始大小
    private int size = 8;
    //指针指向下一个位置
    private int s = 0;
    //存储对象的数组
    private Object[] obj;

    public MyStack() {
        obj = new Object[size];
    }

    public MyStack(int i) {
        size = i;
        obj = new Object[size];
    }

    public T push(T t) {
        //当前容量满了
        if ((s + 2) > size) {
            //扩容1.5倍
            size = (int) (size * 1.5);
            obj = copyAndBeBig(obj, size);
        }
        obj[s] = t;
        s++;

        return t;
    }

    @SuppressWarnings("unchecked")
    public T pop() throws Exception {
        if (s < 1) {
            throw new Exception("没有元素了");
        }
        T o = (T) obj[s - 1];
        //将对象移除
        obj[--s] = null;
        return o;
    }

    public int size() {
        return this.size;
    }

    public boolean empty() {
        return size() == 0;
    }

    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
        if (s < 1) {
            throw new Exception("没有元素了");
        }
        T t = (T) obj[s];
        return t;
    }

    private Object[] copyAndBeBig(Object[] stack, int size) {
        Object[] newStack = new Object[size];

        for (int i = 0; i < stack.length; i++) {
            newStack[i] = stack[i];
        }
        return newStack;
    }
}
