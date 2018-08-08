package com.krokky.leetcode_Practice;

import java.util.Arrays;
import java.util.Stack;

public class ScoreOfParentheses_856 {
    public static void main(String[] args) {

//        String string = "(()()((()())()))";
        String string = "(()())()";

        char[] c = string.toCharArray();
        System.out.println(Arrays.toString(c));
        Stack<String> action = new Stack<>();
        Stack<Integer> score = new Stack<>();
        int x;
        int y;
        /**
         * 伪代码实现:
         *     循环数组{
         *         遇到'('和'('{
         *             将乘法操作符加入操作符栈;
         *         }遇到'('和')'{
         *             将数字1加入操作数栈;
         *         }遇到')'和'('{
         *             将加法操作符加入操作符栈
         *         }遇到')'和')'{
         *             如果操作符栈顶为加法操作符{
         *                 先计算所有加法，
         *                 最后将结果乘以2，每次计算都要弹出一个操作符
         *             }如果操作符栈顶为乘法操作符{
         *                 直接将操作数栈顶数字乘以2，每次计算都要弹出一个操作符
         *             }
         *         }
         *     }
         *     遍历结束后只到了倒数第二个字符串的位置，如果最后两个是')'')'程序是会正常运行
         *     但是如果遇到'('')'栈中的加法没有计算，需要将加法计算完
         */
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == '(' && c[i + 1] == '(') {
                action.push("*");
            } else if (c[i] == '(' && c[i + 1] == ')') {
                score.push(1);
            } else if (c[i] == ')' && c[i + 1] == '(') {
                action.push("+");
            } else if (c[i] == ')' && c[i + 1] == ')') {
                if (action.peek().equals("+")) {
                    while (action.peek().equals("+")) {
                        x = score.pop();
                        y = score.pop();
                        score.push(x + y);
                        action.pop();
                    }
                    x = score.pop();
                    score.push(x << 1);
                    action.pop();
                } else {
                    x = score.pop();
                    score.push(x << 1);
                    action.pop();
                }
            }
        }
        while (!action.empty()) {
            x = score.pop();
            y = score.pop();
            score.push(x + y);
            action.pop();
        }
        System.out.println(score.peek());
    }
}
