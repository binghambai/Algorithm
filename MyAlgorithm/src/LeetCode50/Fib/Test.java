package LeetCode50.Fib;

import java.util.Arrays;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *示例 1：
 * 输入：n = 2
 * 输出：1
 *
 *示例 2：
 *
 * 输入：n = 5
 * 输出：5
 */
public class Test {
    public static int[] memory;
    public static int fib(int n) {
        memory = new int[n + 1];
        return help(n);
    }

    private static int help(int n) {
        if (n <= 1) return n;
        if (memory[n] != 0)
            return memory[n];
        int res = help(n-1) + help(n-2);
        n %= 1000000007;
        memory[n] = res;

        return memory[n];
    }
    //动态规划
    /*
        斐波那契数列是当前元素是前两个元素之和，因此有了动态转移方程
        dp[i] = dp[i-1] + dp[i-2]
        从0开始依次相加向后传递
     */
    public static int fib2(int n) {
        int a=0, b=1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a+b)%1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
    public static void main(String[] args) {

    }
}
