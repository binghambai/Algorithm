package LeetCode50.ReverseList;

import LeetCode50.ReversePrint.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 */
public class Test {
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Deque<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode node = new ListNode(stack.pop());
        ListNode res = node;
        while (!stack.isEmpty()) {
            Integer num = stack.pop();
            node.next = new ListNode(num);
            node = node.next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseList(node);
    }
}
