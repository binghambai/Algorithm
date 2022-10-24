package LeetCode50.maxStr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BigDecimal setScale = new BigDecimal("0").movePointLeft(2).setScale(2, RoundingMode.HALF_DOWN);
        System.out.println(setScale.toString());
        System.out.println(setScale);
    }

    public static int maxLength(String s) {
        return 0;
    }

    public static List<List<Integer>> pairSums(int [] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length <= 1) {
            return res;
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                List<Integer> item = Arrays.asList(nums[l++], nums[r--]);
                res.add(item);
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring(String s) {
        return 0;
    }
}
