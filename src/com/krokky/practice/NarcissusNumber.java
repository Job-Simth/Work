package com.krokky.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 水仙花数
 *
 * @author jianggujin
 */
public class NarcissusNumber {
    /**
     * 记录10的0~N次方
     */
    private BigInteger[] powerOf10;
    /**
     * 记录0到9中任意数字i的N次方乘以i出现的次数j的结果（i^N*j）
     */
    private BigInteger[][] preTable1;
    /**
     * 记录离PreTable中对应数最近的10的k次方
     */
    private int[][] preTable2;
    /**
     * 记录0到9中每个数出现的次数
     */
    private int[] selected = new int[10];
    /**
     * 记录水仙花数的位数
     */
    private int length;

    /**
     * 记录水仙花数
     */
    private List<BigInteger> results;
    /**
     * 记录当前的进制
     */
    private int numberSystem = 10;

    /**
     * @param n 水仙花数的位数
     */
    private NarcissusNumber(int n) {
        powerOf10 = new BigInteger[n + 1];
        powerOf10[0] = BigInteger.ONE;
        length = n;
        results = new ArrayList<BigInteger>();

        // 初始化powerPowerOf10
        for (int i = 1; i <= n; i++) {
            powerOf10[i] = powerOf10[i - 1].multiply(BigInteger.TEN);
        }

        preTable1 = new BigInteger[numberSystem][n + 1];
        preTable2 = new int[numberSystem][n + 1];

        // preTable[i][j] 0-i的N次方出现0-j次的值
        for (int i = 0; i < numberSystem; i++) {
            for (int j = 0; j <= n; j++) {
                preTable1[i][j] = new BigInteger(Integer.valueOf(i).toString()).pow(n)
                        .multiply(new BigInteger(Integer.valueOf(j).toString()));

                for (int k = n; k >= 0; k--) {
                    if (powerOf10[k].compareTo(preTable1[i][j]) < 0) {
                        preTable2[i][j] = k;
                        break;
                    }
                }
            }
        }
    }

    public static List<BigInteger> search(int num) {
        NarcissusNumber narcissusNumber = new NarcissusNumber(num);
        narcissusNumber.search(narcissusNumber.numberSystem - 1, BigInteger.ZERO, narcissusNumber.length);
        return narcissusNumber.getResults();
    }

    /**
     * @param currentIndex 记录当前正在选择的数字(0~9)
     * @param sum          记录当前值（如选了3个9、2个8 就是9^N*3+8^N*2）
     * @param remainCount  记录还可选择多少数
     */
    private void search(int currentIndex, BigInteger sum, int remainCount) {
        if (sum.compareTo(powerOf10[length]) >= 0) {
            return;
        }

        if (remainCount == 0) {
            // 没数可选时
            if (sum.compareTo(powerOf10[length - 1]) > 0 && check(sum)) {
                results.add(sum);
            }
            return;
        }

        if (!preCheck(currentIndex, sum, remainCount)) {
            return;
        }

        if (sum.add(preTable1[currentIndex][remainCount]).compareTo(powerOf10[length - 1]) < 0)// 见结束条件2
        {
            return;
        }

        if (currentIndex == 0) {
            // 选到0这个数时的处理
            selected[0] = remainCount;
            search(-1, sum, 0);
        } else {
            for (int i = 0; i <= remainCount; i++) {
                // 穷举所选数可能出现的情况
                selected[currentIndex] = i;
                search(currentIndex - 1, sum.add(preTable1[currentIndex][i]), remainCount - i);
            }
        }
        // 到这里说明所选数currentIndex的所有情况都遍历了
        selected[currentIndex] = 0;
    }

    /**
     * @param currentIndex 记录当前正在选择的数字(0~9)
     * @param sum          记录当前值（如选了3个9、2个8 就是9^N*3+8^N*2）
     * @param remainCount  记录还可选择多少数
     * @return 如果当前值符合条件返回true
     */
    private boolean preCheck(int currentIndex, BigInteger sum, int remainCount) {
        if (sum.compareTo(preTable1[currentIndex][remainCount]) < 0)// 判断当前值是否小于PreTable中对应元素的值
        {
            return true;// 说明还有很多数没选
        }
        BigInteger max = sum.add(preTable1[currentIndex][remainCount]);// 当前情况的最大值
        max = max.divide(powerOf10[preTable2[currentIndex][remainCount]]);// 取前面一部分比较
        sum = sum.divide(powerOf10[preTable2[currentIndex][remainCount]]);

        while (!max.equals(sum)) {
            // 检验sum和max首部是否有相同的部分
            max = max.divide(BigInteger.TEN);
            sum = sum.divide(BigInteger.TEN);
        }

        if (max.equals(BigInteger.ZERO))// 无相同部分
        {
            return true;
        }

        int[] counter = getCounter(max);

        for (int i = 9; i > currentIndex; i--) {
            if (counter[i] > selected[i])// 见结束条件3
            {
                return false;
            }
        }
        for (int i = 0; i <= currentIndex; i++) {
            remainCount -= counter[i];
        }
        return remainCount >= 0;// 见结束条件4
    }

    /**
     * 检查sum是否是花朵数
     *
     * @param sum 记录当前值（如选了3个9、2个8 就是9^N*3+8^N*2）
     * @return 如果sum存在于所选集合中返回true
     */
    private boolean check(BigInteger sum) {
        int[] counter = getCounter(sum);
        for (int i = 0; i < numberSystem; i++) {
            if (selected[i] != counter[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param value 需要检验的数
     * @return 返回value中0到9出现的次数的集合
     */
    private int[] getCounter(BigInteger value) {
        int[] counter = new int[numberSystem];
        char[] sumChar = value.toString().toCharArray();

        for (int i = 0; i < sumChar.length; i++) {
            counter[sumChar[i] - '0']++;
        }

        return counter;
    }

    /**
     * 获得结果
     *
     * @return
     */
    public List<BigInteger> getResults() {
        return results;
    }

    public static void main(String[] args) {
        int num = 21;
        System.err.println("正在求解" + num + "位花朵数");
        long time = System.nanoTime();
        List<BigInteger> results = NarcissusNumber.search(num);
        time = System.nanoTime() - time;
        System.err.println("求解时间:\t" + time / 1000000000.0 + "s");
        System.err.println("求解结果:\t" + results);
    }
}