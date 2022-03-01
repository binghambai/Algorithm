package LeetCode50.ReversePrint;

import java.util.*;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class Test {
    //使用栈来解决问题
    public static int [] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        Deque<Integer> deque = new LinkedList<Integer>();
        while (head != null) {
            deque.push(head.val);
            head = head.next;
        }
        int [] res = new int[deque.size()];
        int i = 0;
        while (!deque.isEmpty()) {
            res[i++] = deque.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(Arrays.toString(reversePrint(listNode)));
    }
}
