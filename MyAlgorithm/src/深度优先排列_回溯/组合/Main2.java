package 深度优先排列_回溯.组合;

import java.util.*;

public class Main2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) return res;

        Deque<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    private void dfs(int n, int k, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }
    }
}
