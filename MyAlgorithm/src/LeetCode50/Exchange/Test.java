package LeetCode50.Exchange;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class Test {

    public static int[] exchange(int [] nums) {
        if (nums == null || nums.length <= 0) return new int[]{};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (isOu(nums[l]) && isOu(nums[r])) {
                r--;
            } else if (isOu(nums[l]) && !isOu(nums[r])) {
                int tmp = nums[r];
                nums[r] = nums[l];
                nums[l] = tmp;
            } else if (!isOu(nums[r]) && !isOu(nums[r])) {
                l++;
            } else {
                l++;
                r--;
            }
        }
        return nums;
    }
    public static boolean isOu(int num) {
        return num%2 == 0;
    }
    public static void main(String[] args) {
        int [] tmp = new int[]{1,4,1};
        for (int m : exchange(tmp)) {
            System.out.println(m);
        }
    }
}
