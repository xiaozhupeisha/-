/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是
 */
public class LeeCode0038 {
  public String countAndSay(int n) {
    String str = "1";
    for (int i = 2; i <= n; ++i) {
      StringBuilder sb = new StringBuilder();
      int l = 0, r = 0;
      while (r < str.length()) {
        while (r < str.length() && str.charAt(r) == str.charAt(l)) {
          r++;
        }
        sb.append(r - l).append(str.charAt(l));
        l = r;
      }
      str = sb.toString();
    }
    return str;
  }

  public static void main(String[] args) {
    LeeCode0038 solution = new LeeCode0038();
    String s = solution.countAndSay(5);
    System.out.println(s);
  }
}
