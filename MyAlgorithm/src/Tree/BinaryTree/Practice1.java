package Tree.BinaryTree;

import java.util.*;

public class Practice1 {
    public List<Integer> middleOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        doMiddleOrder(root, res);
        return res;
    }
    public void doMiddleOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        doMiddleOrder(root.left, res);
        res.add(root.val);
        doMiddleOrder(root.right, res);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        //根节点入队列
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                tmpList.add(poll.val);
                if (poll.left != null) queue.add(poll.left);
                if (poll.right != null) queue.add(poll.right);
            }
            res.add(tmpList);
        }
        return res;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        //只要有一侧存在true， 则结果就为true所以用或
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int rootNum = postorder[inorder.length -1];
        TreeNode root = new TreeNode(rootNum);
        if (inorder.length == 1) {
            root.left = null;
            root.right = null;
        } else  {
            int index = 0;
            while (inorder[index] != rootNum) index++;
            int [] inorder_left = Arrays.copyOfRange(inorder, 0, index);
            int [] inorder_right = Arrays.copyOfRange(inorder, index + 1, postorder.length);
            int [] postorder_left = Arrays.copyOfRange(postorder, 0, inorder_left.length);
            int [] postorder_right = Arrays.copyOfRange(postorder, inorder_left.length, postorder.length - 1);

            root.left = buildTree(inorder_left, postorder_left);
            root.right = buildTree(inorder_right, postorder_right);
        }
        return root;
    }
}
