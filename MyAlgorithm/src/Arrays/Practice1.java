package Arrays;

import java.util.*;

public class Practice1 {

    public int pivotIndex(int[] nums) {
        if (nums.length <= 0) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sumLeft == sum) return i;
            sumLeft += nums[i];
        }
        return -1;
    }
    //二分法查找在排序数组中插入的位置   注意返回的是左边界值
    public int searchIndex(int [] nums, int target) {
        if (nums.length <= 0) return 0;
        int left = 0, right = nums.length -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (nums[mid] > target) {
                right = mid -1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }
    // 合并重叠区间
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->a[0]-b[0]);
        List<int []> list = new ArrayList<>();
        int [] term = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }
    //旋转矩阵     不使用额外空间交换两个数  使用异或操作
    /*
        a = 10, b = 19;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
     */
    //不使用额外空间
    public void changeNum(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }
    //若M × N矩阵中某个元素为0，则将其所在的行与列清零
    public void setZeroes(int[][] matrix) {
        boolean [] row = new boolean[matrix.length];
        boolean [] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    //最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = isPrefix(prefix, strs[i]);
            if (prefix.length() == 0) break;
        }
        return prefix;
    }
    public String isPrefix(String prefix, String str) {
        int len = Math.min(prefix.length(), str.length());
        int index = 0;
        while (index < len && prefix.charAt(index) == str.charAt(index)) {
            index ++;
        }
        return prefix.substring(0, index);
    }
}
