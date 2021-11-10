package Tree.BinaryTree;

import com.sun.jmx.snmp.SnmpNull;

import javax.swing.text.StyledEditorKit;
import java.awt.geom.RectangularShape;
import java.util.*;

/**
 * 遍历一个树
 */
public class Traverse {
    public static void main(String[] args) {
        BinaryTree listNode = new BinaryTree("F",
                new BinaryTree("B",new BinaryTree("A"), new BinaryTree("D", new BinaryTree("C"), new BinaryTree("E"))),
                new BinaryTree("G", null, new BinaryTree("I", new BinaryTree("H"), null)));
//        List<String> res = new ArrayList<>();
//        List<List<String>> lists = levelOrderTraverse(listNode);
//        System.out.println(lists);
        max_depth(listNode, 1);
        System.out.println(resDepth);
//        BinaryTree test1 = new BinaryTree("1", null, new BinaryTree("2", new BinaryTree("3"), null));
//        List<String> res = new ArrayList<>();
//        preOrderTraverse(test1, res);
//        System.out.println(res);

        BinaryTreeInt test2 = new BinaryTreeInt(2,new BinaryTreeInt(3,new BinaryTreeInt(4),null),
                                                new BinaryTreeInt(3, new BinaryTreeInt(5), new BinaryTreeInt(4)));

        boolean symmetric = isSymmetric(test2);
        System.out.println(symmetric);
    }

    /**
     * 前序遍历  中左右
     * @param root 根节点
     * @param res 需要填充的List
     */
    public static void preOrderTraverse(BinaryTree root, List<String> res) {
        if (root != null) {
            res.add(root.val);
            preOrderTraverse(root.left, res);
            preOrderTraverse(root.right, res);
        }
    }

    /**
     * 中序遍历  左中右
     * @param root 根节点
     * @param res 需要填充的List
     */
    public static void inorderTraverse(BinaryTree root, List<String> res) {
        if (root != null) {
            inorderTraverse(root.left, res);
            res.add(root.val);
            inorderTraverse(root.right, res);
        }
    }
    /**
     * 后序遍历  左右中
     * @param root 根节点
     * @param res 需要填充的List
     */
    public static void postorderTraverse(BinaryTree root, List<String> res) {
        if (root != null) {
            postorderTraverse(root.left, res);
            postorderTraverse(root.right, res);
            res.add(root.val);
        }
    }

    /**
     * 层级遍历，返回每一层的数据
     * @param root 根节点
=     */
    public static List<List<String>> levelOrderTraverse(BinaryTree root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            List<String> tmp = new ArrayList<>();
            for(int i = 0; i < count; i++){
                BinaryTree pollTree = queue.poll();

                tmp.add(pollTree.val);

                if(pollTree.left != null) {
                    queue.add(pollTree.left);
                }
                if(pollTree.right != null) {
                    queue.add(pollTree.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }


    public static int resDepth = 0;
    /**
     * 查询二叉树的最大深度  从上而下计算
     * @param root 根节点
     * @param depth 从1开始计算
     */
    public static void max_depth(BinaryTree root, int depth) {
        if(root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            resDepth =  Math.max(depth,resDepth);
        }
        max_depth(root.right, depth + 1);
        max_depth(root.left, depth + 1);
    }

    /**
     * 最大深度，从下往上遍历
     * @param root 根节点
     */
    public static int maximum_depth(BinaryTree root) {
        if (root == null) {
            return 0;
        }
        int left_depth = maximum_depth(root.left);
        int right_depth = maximum_depth(root.right);
        return Math.max(left_depth, right_depth) + 1;
    }

    public static boolean isSymmetric(BinaryTreeInt root){
        if (root == null) return true;
        List<Boolean> res = new ArrayList<>();
        isSymmetric_recursively(root.left, root.right, res);
        for (Boolean re : res) {
            if (!re) return false;
        }
        return true;
    }
    public static void isSymmetric_recursively(BinaryTreeInt left, BinaryTreeInt right, List<Boolean> res) {
        if (right == null && left == null) {
            res.add(true);
        } else if (right != null && left != null){
            if(right.val == left.val) res.add(true);
            else res.add(false);
            isSymmetric_recursively(left.left, right.right, res);
            isSymmetric_recursively(left.right, right.left, res);
        }else {
            res.add(false);
        }
    }
}
