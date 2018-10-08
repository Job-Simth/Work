package com.krokky.bishi;

import java.util.ArrayList;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();
//        int m = s.nextInt();
        List<Integer> money = new ArrayList<>();
        List<Integer> lvl = new ArrayList<>();
//        while (s.hasNextInt()) {
//            money.add(s.nextInt());
//            lvl.add(s.nextInt());
//        }

        int n = 130;
        int m = 3;
        money.add(100);
        lvl.add(380);

        money.add(20);
        lvl.add(320);

        money.add(40);
        lvl.add(360);

        money.add(50);
        lvl.add(310);


        System.out.println(knapsackOptimal(n, m, money, lvl));
    }

    public static int knapsackOptimal(int c, int m, List<Integer> money, List<Integer> lvl) {
        int n = money.size(); //物品数量
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        int[][] G = new int[n + 1][c + 1];
        for (int i = 1; i < n + 1; i++) {
            w[i] = money.get(i - 1);
            v[i] = lvl.get(i - 1);
        }

        //初始化values[0...c]=0————在不超过背包容量的情况下，最多能获得多少价值
        //原因：如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，这个解的价值为0，所以初始时状态的值也就全部为0了
        int[] values = new int[c + 1];
        //初始化values[0]=0，其它全为负无穷————解决在恰好装满背包的情况下，最多能获得多少价值的问题
        //原因：只有容量为0的背包可以什么物品都不装就能装满，此时价值为0，其它容量背包均无合法的解，属于未定义的状态，应该被赋值为负无穷
        /*for (int i = 1; i < values.length; i++) {
            values[i] = MIN;
        }*/

        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }

        System.out.println("最大价值为： " + values[c]);
        System.out.print("装入背包的物品编号为： ");
        /*
        输出顺序:逆序输出物品编号
        注意：这里另外开辟数组G[i][v],标记上一个状态的位置
        G[i][v] = 1:表示物品i放入背包了，上一状态为G[i - 1][v - w[i]]
        G[i][v] = 0:表示物品i没有放入背包，上一状态为G[i - 1][v]
        */
        int i = n;
        int j = c;
        while (i > 0) {
            if (G[i][j] == 1) {
                System.out.print(i + " ");
                j -= w[i];
            }
            i--;
        }
        return values[c];
    }
}