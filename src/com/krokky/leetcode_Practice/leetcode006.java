package com.krokky.leetcode_Practice;

import java.util.ArrayList;
import java.util.List;

class Solution6 {
    /**
     * 直接解决，按照逻辑顺序添加
     *
     * @param s
     * @param numRows
     * @return str
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        //建立一个和行数相等的链表
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        int cur = 0;
        boolean goDown = false;
        //将字符遍历加入链表
        for (char c : s.toCharArray()) {
            //将当前字符将入对应的行
            list.get(cur).append(c);
            //如果到底或者到顶了就要转向
            if (cur == 0 || cur == numRows - 1) {
                goDown = !goDown;
            }
            //根据情况向上或者向下走
            cur += goDown ? 1 : -1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder sb : list) {
            stringBuilder.append(sb);
        }
        return stringBuilder.toString();
    }

    /**
     * 间接解决，按照规律直接加入到结果中
     * 主列
     * ↓
     * a   e   i
     * b d f h g
     * c ↑ g   k
     * ↑
     * 中间
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder ans = new StringBuilder();
        //字符串长度
        int n = s.length();
        //第一行两个字符之间的距离
        int temp = 2 * numRows - 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + i < n; j += temp) {
                //将所有主列加入
                ans.append(s.charAt(i + j));
                //如果有中间的加入中间的
                if (j != 0 && j != (numRows - 1) && j + temp - i < n) {
                    ans.append(s.charAt(j + temp - i));
                }
            }
        }
        return ans.toString();
    }
}


public class leetcode006 {
    public static void main(String[] args) {
        String s = "ab";
        int numRows = 1;
        System.out.println(new Solution6().convert(s, numRows));
    }
}
