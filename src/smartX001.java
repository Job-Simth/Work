public class smartX001 {

    /**
     * 从5开始遍历到最大的值，每次将得到的数从个位开始判断
     * 含有5就将count自增
     *
     * @param max
     * @return count
     */
    public static int find5(int max) {
        int count = 0;
        int temp;

        for (int i = 5; i <= max; i++) {
            temp = i;
            while (temp >= 5) {
                if (temp % 10 == 5) {
                    count++;
                }
                temp = temp / 10;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(find5(555));
    }
}
