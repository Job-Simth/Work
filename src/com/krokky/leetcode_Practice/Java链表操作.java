package com.krokky.leetcode_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public static ListNode sortList(ListNode head) {
        quicksort(head, null);
        return head;
    }

    //链表的快速排序
    public static ListNode partition(ListNode start, ListNode end) {
        int x = start.val;
        ListNode i = start;
        ListNode j = i.next;
        while (j != end) {
            if (j.val < x) {
                i = i.next;
                int temp = i.val;
                i.val = j.val;
                j.val = temp;
            }
            j = j.next;
        }

        int temp1 = i.val;
        i.val = start.val;
        start.val = temp1;
        return i;
    }

    public static void quicksort(ListNode begin, ListNode end) {
        if (begin != end) {
            ListNode p = partition(begin, end);
            quicksort(begin, p);
            quicksort(p.next, end);
        }

    }

    //链表的归并排序
    public static ListNode Merge(ListNode A, ListNode B) {
        ListNode p = A;
        ListNode q = B;
        ListNode result = new ListNode(-1);
        ListNode r = result;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        if (p != null) {
            r.next = p;
        }
        if (q != null) {
            r.next = q;
        }
        return result.next;
    }

    public static ListNode Mergesort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = find(head);
        ListNode later = mid.next;
        mid.next = null;
        return Merge(Mergesort(head), Mergesort(later));


    }

    public static ListNode find(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode sortList1(ListNode head) {

        return Mergesort(head);

    }

}

public class Java链表操作 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            ListNode ret = new Solution().sortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}