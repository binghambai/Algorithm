package Tree.BinaryTree;

import java.util.*;

/**
 * 遍历一个树
 */
public class Traverse {
    public static void main(String[] args) {
        TreeNode test = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                                                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2, null, new TreeNode(4)), new TreeNode(1)),
                new TreeNode(6, new TreeNode(7), null));

        Practice1 practice1 = new Practice1();
        List<List<Integer>> res =  practice1.levelOrder(root);
        System.out.println(res);

//        System.out.println(hasPathSum(test,22));
//        int [] res = new int[]{1,2,3,4,5};
//
//        int []left = Arrays.copyOfRange(res, 0, 2);
//        for (int i : left) {
//            System.out.printf("%d ",i);
//        }
//        int [] preOrder = new int[]{1,2,3,2,3,4};
//        int [] inOrder = new int[]{2,3,1,2,3,4};
//
//        BinaryTreeInt build = build(preOrder, inOrder);

//        int [] r = Arrays.copyOfRange(preOrder, 1, preOrder.length);

//        preOrder(build);
        String s = "meshop.api.goods";
        System.out.println(s.split("\\.")[2]);
    }
    public static void preOrder(BinaryTreeInt root) {
        if (root != null) {
            System.out.println(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
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
     */
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

    /**
     * 判断二叉树 是否镜像对称
     * @param root 根节点
     * @return 结果
     */
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
            isSymmetric_recursively(left.left, right.right, res); // 左树的左边和右树的右边比较
            isSymmetric_recursively(left.right, right.left, res); // 左树的右边和右树的左边比较
        }else {
            res.add(false);
        }
    }

    /**
     * 判断树内是否存在等于target的路径和
     * @param root 根节点
     * @param targetSum 路径和
     * @return 是否
     */
    public static boolean hasPathSum(BinaryTreeInt root, int targetSum) {
        if (root == null) return false;
        BinaryTreeInt left = root.left;
        BinaryTreeInt right = root.right;
        if (left == null && right == null) return targetSum == root.val;
        boolean b1 = false, b2 = false;
        if (left != null){
            b1 = hasPathSum(left, targetSum - root.val);
        }
        if (right != null) {
            b2 = hasPathSum(right, targetSum - root.val);
        }
        return b1||b2;
    }

    public static BinaryTreeInt build(int [] preOrder, int [] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) return null;

        int mid = 0;
        for (int i = 0; i < inOrder.length; i++) {
            if (preOrder[0] == inOrder[i]){
                mid = i;
                break;
            }
        }
        BinaryTreeInt root = new BinaryTreeInt(inOrder[mid]);

        int [] rangeLeft = Arrays.copyOfRange(inOrder, 0 , mid);
        int [] rangeRight = Arrays.copyOfRange(inOrder, mid + 1, inOrder.length);
        root.left = build(Arrays.copyOfRange(preOrder, 1, rangeLeft.length + 1), rangeLeft);
        root.right = build(Arrays.copyOfRange(preOrder, rangeLeft.length + 1, preOrder.length),rangeRight);
        return root;
    }

    /**
     * DFS方式的遍历
     * @param root
     * @return
     */
    public static String serialize(BinaryTree root) {
        if (root == null) return "#";
        return root.val + serialize(root.left) + serialize(root.right);
    }

    public static BinaryTree deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private static BinaryTree helper(Queue<String> queue) {
       String val = queue.poll();
       if("#".equals(val)) {
           return null;
       }
       BinaryTree node = new BinaryTree(val);
       node.left = helper(queue);
       node.right = helper(queue);
       return node;
    }
}
