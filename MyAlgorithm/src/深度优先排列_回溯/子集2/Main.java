package 深度优先排列_回溯.子集2;

import java.util.*;

public class Main {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return  res;

        Deque<Integer> path = new LinkedList<>();

        Arrays.sort(nums);
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int start, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        if (nums.length == path.size()) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {1, 2, 2};
        System.out.println(main.subsetsWithDup(nums));
    }
}
