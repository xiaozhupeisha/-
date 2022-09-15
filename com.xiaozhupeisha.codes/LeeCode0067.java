import java.util.Arrays;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 */
public class LeeCode0067 {

  public String addBinary(String a, String b) {
    StringBuilder ans = new StringBuilder();
    int ca = 0;
    for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
      int sum = ca;
      sum += i >= 0 ? a.charAt(i) - '0' : 0;
      sum += j >= 0 ? b.charAt(j) - '0' : 0;
      ans.append(sum % 2);
      ca = sum / 2;
    }
    ans.append(ca == 1 ? ca : "");
    return ans.reverse().toString();
  }

  public static void main(String[] args) {
//    String a = "12";
//    System.out.println(Integer.toBinaryString(a.charAt(0)) + "");
    String s = new LeeCode0067().addBinary("11", "1");
    System.out.println(s);
  }

}
