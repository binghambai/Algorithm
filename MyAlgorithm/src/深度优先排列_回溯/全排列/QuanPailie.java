package 深度优先排列_回溯.全排列;

import java.util.ArrayList;
import java.util.List;

public class QuanPailie {
    public List<List<Integer>> all(int [] nums) {
        int len = nums.length;
        //save result
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        //判断是否使用过当前数数字
        boolean [] used = new boolean[len];
        //存储每一次的结果路径
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {

        //终止条件 达到最深（叶子节点处）
        if (len == depth) {
            res.add(new ArrayList<>(path));
            return;
        }

        //非叶子节点处会选择不同的元素，需要用循环实现
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);

                //回溯，是遍历到了子叶节点，回头的操作
                used[i] = false;
                path.remove(path.size() - 1);

            }
        }
    }
}
