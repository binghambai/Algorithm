package 深度优先排列_回溯.排列序列;

/**
 * 第K个排序
 */

import java.util.*;

public class Main {
    public String getPermutation(int n, int k) {
        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[n + 1];
        dfs(n, k, 0, used, path);
        return path.toString();
    }

    private void dfs(int n, int k, int depth, boolean [] used, StringBuilder path) {
        if (n == depth) return;
        for (int i = 1; i <= n; i++) {
            int delt = calculateFactorial(n - 1 - depth);
            if (used[i]) {
                continue;
            }
            if (delt < k) {
                k = k - delt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(n, k, depth + 1, used, path);
            return;
        }
    }
    private int calculateFactorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getPermutation(3, 2));
    }

}
