package com.krokky.Test;

import java.util.Scanner;

public class KMP {
    //    public int KMP(){
//     int KMP(char *str, int slen, char *ptr, int plen)
//    {
//        int *next = new int[plen];
//        cal_next(ptr, next, plen);//计算next数组
//        int k = -1;
//        for (int i = 0; i < slen; i++)
//        {
//            while (k >-1&& ptr[k + 1] != str[i])//ptr和str不匹配，且k>-1（表示ptr和str有部分匹配）
//                k = next[k];//往前回溯
//            if (ptr[k + 1] == str[i])
//                k = k + 1;
//            if (k == plen-1)//说明k移动到ptr的最末端
//            {
//                //cout << "在位置" << i-plen+1<< endl;
//                //k = -1;//重新初始化，寻找下一个
//                //i = i - plen + 1;//i定位到该位置，外层for循环i++可以继续找下一个（这里默认存在两个匹配字符串可以部分重叠），感谢评论中同学指出错误。
//                return i-plen+1;//返回相应的位置
//            }
//        }
//        return -1;
//    }

    public static int[] cal_next(char[] str, int[] next) {
        next[0] = -1;//next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
        int k = -1;//k初始化为-1
        for (int q = 1; q < str.length; q++) {
            while (k > -1 && str[k + 1] != str[q]) {//如果下一个不同，那么k就变成next[k]，注意next[k]是小于k的，无论k取任何值。
                k = next[k];//往前回溯
            }
            if (str[k + 1] == str[q]) {//如果相同，k++
                k = k + 1;
            }
            next[q] = k;//这个是把算的k的值（就是相同的最大前缀和最大后缀长）赋给next[q]
        }
        return next;
    }

    public static int KMP(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        int[] next = getNext(ps);
        while (i < t.length && j < p.length) {
            if (j == -1 || t[i] == p[j]) { // 当j为-1时，要移动的是i，当然j也要归0
                i++;
                j++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                j = next[j]; // j回到指定位置
            }
        }
        if (j == p.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String ps = s.next();
            String str = s.next();
            int x = Math.max(KMP(ps, str), KMP(str, ps));
            System.out.println(x);
        }
//        System.out.println(x + "," + (x + str.length()));
//        System.out.println(ps.substring(x, x + str.length()));
//        int[] next = getNext(str);
//        char[] c = str.toCharArray();
//        int len = c.length;
//        int[] next = new int[len];
//        next = cal_next(c, next);
//        System.out.println(Arrays.toString(next));
    }
}
