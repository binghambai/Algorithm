package Tree.BST;


import Tree.BinaryTree.BinaryTreeInt;
import Tree.BinaryTree.Practice1;
import Tree.BinaryTree.TreeNode;

import java.util.List;

/*
    二叉搜索树 Binary Search Tree(BST)
    满足：节点的值大于右树或等于，小于或等于左树
 */
public class Traverse {
    public static void main(String[] args) {
        BinaryTreeInt tree = new BinaryTreeInt(2, new BinaryTreeInt(1), new BinaryTreeInt(3));

        TreeNode root = new TreeNode(5,
                                        new TreeNode(3, new TreeNode(2, null, new TreeNode(4)), new TreeNode(1)),
                                        new TreeNode(6, new TreeNode(7), null));
        Practice1 practice1 = new Practice1();
        List<List<Integer>> lists = practice1.levelOrder(root);
        System.out.println(lists);

        int i = practice1.maxDepth(root);
        System.out.println(i);


        boolean b = practice1.hasPathSum(root, 9);
        System.out.println(b);
    }

    /**
     * 验证二叉搜索树， 二叉搜索树的定义符合中序遍历的顺序
     * @param root
     * @return
     */
    public static boolean isValidBST(BinaryTreeInt root) {
        isValidBST_mid(root);
        return count==0;
    }
    public static int val = Integer.MIN_VALUE;
    public static int count = 0;
    public static void isValidBST_mid(BinaryTreeInt root) {
        if(root == null) return;
        isValidBST_mid(root.left);
        if(root.val <= val) count++;
        val = root.val;
        isValidBST_mid(root.right);
    }
}
