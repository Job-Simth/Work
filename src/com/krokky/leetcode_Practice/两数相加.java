package com.krokky.leetcode_Practice;

class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(0);
        ListNode head = answer;
        ListNode c1 = l1;
        ListNode c2 = l2;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            head.next = new ListNode(sum % 10);
            head = head.next;
        }
        if (sum / 10 == 1) {
            head.next = new ListNode(1);
        }
        return answer.next;
    }
}

public class 两数相加 {
    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);

        ListNode ret = new Solution3().addTwoNumbers(l1, l2);

        String out = listNodeToString(ret);

        System.out.print(out);
    }
}
