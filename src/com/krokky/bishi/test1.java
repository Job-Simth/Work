package com.krokky.bishi;

public class test1 {
    public static void main(String[] args) {
        int[] a = {2};
        System.out.println(new test1().findMissing(a));
    }

    /**
     * 查找丢失的数字
     *
     * @param nums
     * @return
     */

    public int findMissing(int[] nums) {
        boolean[] A = new boolean[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            A[nums[i]] = true;
        }
        int n = 0;
        for (int i = 1; i < A.length; i++) {
            if (!A[i]) {
                n = i;
                break;
            }
        }
        return n;
    }
}
//    public int findMissing(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i =0;i<nums.length;i++) {
//            set.add(nums[i]);
//        }
//        for (int i = 1; i <= nums.length + 1; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//        throw new IllegalArgumentException("Not find");
//    }