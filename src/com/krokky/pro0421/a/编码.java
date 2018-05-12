package com.krokky.pro0421.a;
import java.util.Arrays;
import java.util.Scanner;

/*
 *
 * djsfdhufdkfidf
 * djsfdh
 * ufdkfi
 * df
 *
 *
 *
 */
public class 编码 {
    // 横加
    /*
     * 将一个字符串转换成字符串数组,每六个一组
     */
    public void a(String str) {
        int len = str.length();
        int count = 0;
        if (len > 6) {
            if (len % 6 == 0) {
                count = len / 6;
            } else {
                count = len / 6 + 1;
            }
        }
        String[] arr = new String[count];
        String s = "";
        for (int i = 0; i < arr.length; i++) {
            int b = 6 * i;
            int e = (6 * (i + 1) > len) ? len : (6 * (i + 1));
            arr[i] = str.substring(b, e);
            s += a1(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(s);
    }
    //就是最后的结果,累加后的值
    int p = 0;
    /*
     * 将字符串转换成字符数组,将这个字符数组累加为整型值
     */
    public int a1(String str) {
        char[] c = str.toCharArray();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            int m = c[i];//将字符转换成int型,按照ASCII
            sum += m;
        }
        a2(sum);
        return p;
    }

    /*
     * 将一个数字按位求和,比如:765 =  7+ 6+ 5=18=1+8 = 9
     */
    public void a2(int a) {
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a = a / 10;
        }
        if (sum > 10) {
            a2(sum);
        } else {
            p = sum;
            System.out.println(sum);
        }
    }

    // 竖加
    public void b(String str) {
        int len = str.length();
        //sdhsjduwjdsdsdds --->
        /*
         * sdhsjd
         * uwjdsd
         * sdds
         */
        int count = (len%6==0)?(len/6):(len/6+1);//数组长度
        String []arr = new String[count];
        for (int i = 0; i < arr.length; i++) {
            int b = (i*6);
            int e = (i+1)*6;
            arr[i] = str.substring(b, (e>len)?(len):(e));
        }

        String[] result = {"","","","","",""};

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < arr.length; j++) {
                String q = arr[j];
                if(q.length()>i){
                    result[i]+=q.charAt(i);
                }else{
                    result[i]+="";
                }
            }
        }

        System.out.println(Arrays.toString(result));


    }

    public static void main(String[] args) {
        编码 b = new 编码();

        Scanner in = new Scanner(System.in);
        System.out.println("请输入:");

        b.b(in.nextLine());

        // b.a2(681);
    }
}
