package LeetCode50.IsSubStructure;

import Tree.BinaryTree.TreeNode;

import java.util.*;
import java.util.stream.Stream;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Test {

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        //根节点重合（在同一个层的同一个位置）判断下是否相同，相同就直接返回true
        if (isSame(A, B)) return true;
        //否则需要对比A的左右数是否与B相同结构，想下一层移动A的根节点，  把B节点对比再A的下一个节点位置进行比较（左树||右树）
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    // 当根节点重合时，判断下是否为一样的结构
    public static boolean isSame(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
    public static void main(String[] args) {

        Queue<Integer> t = new LinkedList<>();
        t.add(10);
        t.add(6);
        t.poll();
        System.out.println(t);

    }

    public static String fillZero(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i ++) {
            sb.append(str.charAt(i));
        }
        for (int i = 0; i< 8 - str.length(); i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}
