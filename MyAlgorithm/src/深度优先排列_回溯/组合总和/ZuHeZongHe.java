package 深度优先排列_回溯.组合总和;

import java.util.*;

public class ZuHeZongHe {
    public List<List<Integer>> candidates(int [] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        Deque<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, len, target, path, res, 0);
        return res;
    }

    private void dfs(int[] candidates, int len, int remain, Deque<Integer> path, List<List<Integer>> res, int start) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            path.add(candidates[i]);
            //start传入i，表示当前数字可以重复使用求和
            dfs(candidates, len, remain - candidates[i], path, res, i);
            path.removeLast();
        }
    }
}
