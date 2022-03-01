package LeetCode50.FindNumberIn2DArray;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 *
 */
public class Test {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] > target) break;
                if (matrix[i][j] == target) return true;
            }
        }
        return false;
    }
    //遍历每一行使用二分法
    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0) return false;
        if (matrix[0].length <= 0) return false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) continue;
            //二分查找
            int left = 0;
            int right = matrix[0].length - 1;
            while (left <= right) {
                int mid = (right - left)/2 + left;
                if (matrix[i][mid] < target) {
                    left = mid + 1;
                } else if (matrix[i][mid] > target) {
                    right = mid -1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
