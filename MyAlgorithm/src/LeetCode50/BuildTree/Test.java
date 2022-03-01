package LeetCode50.BuildTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 示例 1:
 *          3
 *         |  |
 *        9   20
 *            | |
 *           15  7
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 *
 */
public class Test {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return doBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    private static TreeNode doBuildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2) {
        if(l1 >= preorder.length || l2 >= inorder.length || l1 > r1 || l2 > r2 )
            return null;
        TreeNode root = new TreeNode(preorder[l1]);
        int count = l2;
        while (inorder[count] != preorder[l1])
            count++;
        count-=l2;
        root.left = doBuildTree(preorder, inorder, l1+1, l1+count, l2, l2+count-1);
        root.right = doBuildTree(preorder, inorder, l1+count+1, r1, l2+count+1, r2);
        return root;

    }

    public static void main(String[] args) {

    }
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        if(matrix.length == 0 || matrix[0].length==0 || word.length() == 0) return false;
        for(int i=0; i< matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                if(dfs(matrix, word.toCharArray(), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] array, char[] words, int i, int j, int index) {
        if(i<0 || i>=array.length || j<0 || j>=array[0].length || index >= words.length || words[index] != array[i][j]) return false;
        if(index == words.length -1 ) {
            return true;
        }
        char tmp = array[i][j];
        array[i][j] = '.';
        boolean res =  dfs(array, words, i, j+1, index + 1)
                || dfs(array, words, i, j-1, index + 1)
                || dfs(array, words, i+1, j, index + 1)
                || dfs(array, words, i-1, j, index + 1);
        array[i][j] = tmp;
        return res;
    }
}
