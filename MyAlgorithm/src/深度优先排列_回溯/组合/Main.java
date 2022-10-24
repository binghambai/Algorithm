package 深度优先排列_回溯.组合;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Main {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1 ) {
            res.add(Arrays.asList(1));
            return res;
        }
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        Deque<Integer> path = new LinkedList<>();
        int len = nums.length;
        dfs(nums, k, 0, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);

            dfs(nums, len, depth + 1, i + 1, path, res);
            //回溯
            path.removeLast();
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.combine(4, 2));
    }
}
