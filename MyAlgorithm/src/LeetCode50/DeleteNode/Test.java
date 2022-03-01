package LeetCode50.DeleteNode;

import LeetCode50.ReversePrint.ListNode;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *
 * 给定的参数为要删除的那一个节点，无法访问上一个节点的内容，但是题目设定给的节点不是末尾节点，所以可以复制下一个节点的值，然后删除下一个节点
 */
public class Test {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
