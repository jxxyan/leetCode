package com.jxxyan.leetCode;

/**
 * 2个版本都ok
 * 主要考察自定义加法，进位的问题，不能用int long相加，为溢出
 *
 */
public class LeetCode0002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        l1.next = l12;

        ListNode l2 = new ListNode(1);

        addTwoNumbers(l1, l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int i1, i2;
        int carryBit = 0;
        int sum = 0;
        ListNode result = null;
        ListNode current = null;
        ListNode temp = null;
        while (l1 != null || l2 != null) {
            i1 = l1 == null ? 0 : l1.val;
            i2 = l2 == null ? 0 : l2.val;

            sum = i1 + i2 +carryBit;
            carryBit = 0;
            if(sum >= 10){
                sum = sum - 10;
                carryBit = 1;
            }

            if(current == null){
                current = new ListNode(sum);
                result = current;
            }else{
                temp = new ListNode(sum);
                current.next = temp;
                current = temp;
            }

            l1 = l1 == null ? null :l1.next;
            l2 = l2 == null ? null :l2.next;
        }

        if(carryBit == 1){
            current.next = new ListNode(1);
        }

        return result;
    }


    /**
     * 感觉不需要自定义数组，直接使用链表遍历就行
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        StringBuffer sb = new StringBuffer();
        ListNode l = l1;
        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }
        char[] c1 = sb.toString().toCharArray();

        sb.delete(0, sb.length());
        l = l2;
        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }
        char[] c2 = sb.toString().toCharArray();

        sb.delete(0, sb.length());
        int carryBit = 0;
        for (int i = 0; i < (c1.length > c2.length ? c1.length : c2.length); i++) {

            int sum = 0;

            if (i >= c1.length) {
                sum = c2[i] - '0' + carryBit;
                carryBit = 0;
            } else if (i >= c2.length) {
                sum = c1[i] - '0' + carryBit;
                carryBit = 0;
            } else {
                int a1 = c1[i] - '0';
                int a2 = c2[i] - '0';
                sum = a1 + a2 + carryBit;
                carryBit = 0;
            }

            if (sum >= 10) {
                sum = sum - 10 + carryBit;
                carryBit = 1;
            }

            sb.append(sum);
        }

        if (carryBit == 1) {
            sb.append(1);
        }

        char[] result = sb.toString().toCharArray();

        ListNode resultList = new ListNode(result[0] - '0');
        ListNode current = resultList;
        for (int i = 1; i < result.length; i++) {
            ListNode temp = new ListNode(result[i] - '0');
            current.next = temp;
            current = temp;

        }

        return resultList;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }
}
