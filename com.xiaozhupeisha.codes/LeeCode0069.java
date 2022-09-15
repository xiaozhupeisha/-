/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class LeeCode0069 {

//  /**
//   * 方法一：二分查找
//   *
//   * @param x
//   * @return
//   */
//  public int mySqrt(int x) {
//    int l = 0, r = x, ans = -1;
//    while (l <= r) {
//      int mid = l + (r - l) / 2;
//      if ((long) mid * mid <= x) {
//        ans = mid;
//        l = mid + 1;
//      } else {
//        r = mid - 1;
//      }
//    }
//    return ans;
//  }

  /**
   * 方法二：牛顿迭代
   * @param x
   * @return
   */
  public int mySqrt(int x) {
    if (x == 0) {
      return 0;
    }

    double C = x, x0 = x;
    while (true) {
      double xi = 0.5 * (x0 + C / x0);
      if (Math.abs(x0 - xi) < 1e-7) {
        break;
      }
      x0 = xi;
    }
    return (int) x0;
  }

  public static void main(String[] args) {
    int i = new LeeCode0069().mySqrt(2147395599);
    System.out.println(i);
  }

}
