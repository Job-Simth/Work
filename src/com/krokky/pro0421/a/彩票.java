package com.krokky.pro0421.a;

import java.util.Arrays;
import java.util.Scanner;

public class 彩票 {

    private int[] result = new int[7];
    private int[] ask = new int[7];
    private int k = 0, j = 0;

    private Scanner in = new Scanner(System.in);

    public void 摇奖() {
        int r = (int) (Math.random() * 33 + 1);

        boolean b = 判断(r, result);
        if (b) {
            result[k] = r;
            k++;
            if (k < 6) {
                摇奖();
            }
            if (k == 6) {
                蓝球();
            }
        } else {
            摇奖();
        }
    }

    public void 蓝球() {
        int r = (int) (Math.random() * 16 + 1);
        result[6] = r;

    }

    public boolean 判断(int r, int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (r == arr[i]) {
                return false;
            }
        }
        return true;
    }

    public void show() {
        System.out.println(Arrays.toString(result));
    }

    public void 竞猜() {
        if (j < 6) {
            System.out.println("请输入第" + (j + 1) + "个红球:");
            int a = in.nextInt();
            boolean b = 判断(a, ask);
            if (b) {
                if (j < 6) {
                    ask[j] = a;
                    j++;
                    竞猜();
                }

            } else {
                System.out.println("输入重复,请重新输入:");
                竞猜();
            }
        } else {
            System.out.println("请输入蓝球:");
            ask[6] = in.nextInt();
        }

    }

    private int num = 0;

    public void 判断() {
        for (int i = 0; i < ask.length - 1; i++) {
            for (int j = 0; j < result.length - 1; j++) {
                if (ask[i] == result[j]) {
                    num++;
                }
            }
        }

        if (ask[6] == result[6]) {
            switch (num) {
                case 6:
                    System.out.println("1等奖");
                    break;
                case 5:
                    System.out.println("2等奖");
                    break;
                case 4:
                    System.out.println("3等奖");
                    break;
                default:
                    System.out.println("对不起,你与大奖擦肩而过!");
                    break;
            }
        } else {
            System.out.println("对不起,你与大奖擦肩而过!");
        }

    }

    public static void main(String[] args) {
        彩票 c = new 彩票();
        c.摇奖();
        c.show();
        c.竞猜();
        c.判断();
    }
}
