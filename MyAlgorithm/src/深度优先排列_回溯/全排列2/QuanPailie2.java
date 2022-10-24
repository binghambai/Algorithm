package 深度优先排列_回溯.全排列2;

import java.util.*;

public class QuanPailie2 {
    public List<List<Integer>> fullPermutation2(int [] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        //
        Arrays.sort(nums);

        boolean [] used = new boolean[len];
        Deque<Integer> path = new LinkedList<>();

        dfs(nums, len, 0, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<Integer>(path));
        }
        for (int i = 0; i < len; i++) {
            //先剪枝  当前要选择的节点和之前选择的节点相同， 并且 之前选的节点已经真实使用过了,因为使用过再撤销是false
            if (i > 0 && nums[i] == nums[i -1] && !used[i-1]) {
                continue;
            }
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, used, path, res);
                //撤回 回溯操作
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
