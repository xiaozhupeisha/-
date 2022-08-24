/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 */
public class LeeCode0007 {

  public int reverse(int x) {
    int res = 0;
    while (x != 0) {
      //每次取末尾数字
      int tmp = x % 10;
//      // 判断是否 大于 最大32位整数
//      if (res > 214748364 || (res == 214748364 && tmp > 7)) {
//        return 0;
//      }
//      // 判断是否 小于 最小32位整数
//      if (res < -214748364 || (res == -214748364 && tmp < -8)) {
//        return 0;
//      }
      res = res * 10 + tmp;
      x /= 10;
    }
    return res;
  }

  public static void main(String[] args) {
    int reverse = new LeeCode0007().reverse(123150);
    System.out.println(reverse);
  }
}
