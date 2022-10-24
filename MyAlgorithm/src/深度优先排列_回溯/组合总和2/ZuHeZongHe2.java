package 深度优先排列_回溯.组合总和2;

import java.util.*;

/**
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 */
public class ZuHeZongHe2 {
    public List<List<Integer>> candidates(int [] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new LinkedList<>();

        Arrays.sort(candidates);
        dfs(candidates, len, target, path, res, 0);
        return res;
    }

    private void dfs(int[] candidates, int len, int remain, Deque<Integer> path, List<List<Integer>> res, int start) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            //大剪枝
            if ((remain - candidates[i]) < 0) break;
            //小剪枝
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, len, remain - candidates[i], path, res, i + 1);
            //回溯
            path.removeLast();
        }
    }

    public List<List<Integer>> candidates2(int [] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new LinkedList<>();

        Arrays.sort(candidates);
        boolean [] used = new boolean[len];
        dfs2(candidates, len, target, path, res, used, 0);
        return res;
    }

    private void dfs2(int[] candidates, int len, int target, Deque<Integer> path, List<List<Integer>> res, boolean[] used, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (target < candidates[i]) continue;
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            if (!used[i]) {
                path.add(candidates[i]);
                used[i] = true;

                dfs2(candidates, len, target - candidates[i], path, res, used, i +1);
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
