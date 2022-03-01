package LeetCode50.MergeTwoLists;

import LeetCode50.ReversePrint.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Test {
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null|| l2 == null ) return l1==null?l2:l1;
        ListNode node = new ListNode(-1);
        ListNode res = node;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 != null? l1:l2;
        return res.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(1, new ListNode(2)));
        ListNode l2 = new ListNode(1,new ListNode(2, new ListNode(3)));
        mergeTwoList(l1, l2);
    }
}
