package LeetCode50.MyPow;

/**
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 如3^11次，11的二进制是1011，所以11=2^3 + 0^2 + 2^1 + 2^0
 *                                  1    0     1     1
 *                        从中看出，二进制数某位是1的时候，才会计算一次，为0则不计算
 *
 */
public class Test {
    public static double myPow(double x, int n) {
        if (x <= 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1/x;
            b = -b;
        }
        while (b > 0) {
            if ((b&1) == 1)
                res *= x;
            x *= x;
            b >>>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
