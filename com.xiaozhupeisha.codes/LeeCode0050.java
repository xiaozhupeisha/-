import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
public class LeeCode0050 {

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      return myPow(1 / x, -n);
    }
    if (n % 2 == 1) { //n为奇数
      return x * myPow(x, n - 1);
    } else { //n为偶数
      double v = myPow(x, n / 2);
      return v * v;
    }
  }

  public static void main(String[] args) {
    System.out.println(new LeeCode0050().myPow(2.00, 3));
  }
}
