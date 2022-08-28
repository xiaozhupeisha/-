import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class LeeCode0029 {
  public int divide(int x, int y) {
    List<Long> exp = new ArrayList<>();
    boolean isNegative = x > 0 && y < 0 || x < 0 && y > 0;
    long a = Math.abs((long) x);
    long b = Math.abs((long) y);
    // 快速幂
    for (long i = b; i <= a; i += i) exp.add(i);
    long res = 0;
    for (int i = exp.size() - 1; i >= 0; i--)
      if (a >= exp.get(i)) {
        a -= exp.get(i);
        res += 1L << i;
      }
    res = isNegative ? -res : res;
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) res = Integer.MAX_VALUE;
    return (int) res;
  }
}