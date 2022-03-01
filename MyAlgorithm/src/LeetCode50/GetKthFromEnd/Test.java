package LeetCode50.GetKthFromEnd;

import LeetCode50.ReversePrint.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 */
public class Test {
    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int index = count - k + 1, init = 1;
        while (head != null) {
            if (init == index) {
                return head;
            }
            head = head.next;
            init++;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode test = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    }
}
