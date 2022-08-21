/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LeetCode0005 {

  public String longestPalindrome(String s) {
    String result = "";
    for (int i = 0; i < s.length(); i++) {
      // 定义2个指针，紧邻着，开始向右移动，移动过程中膨胀发散

      // 必须两两对称并且在边界值之内,奇
      String firstResult = getString(s, i, i);
      if(firstResult.length() >= result.length()) result = firstResult;

      // 必须两两对称并且在边界值之内,偶
      String secondResult = getString(s, i, i + 1);
      if(secondResult.length() >= result.length()) result = secondResult;
    }
    return result;
  }

  private static String getString(String s, int leftPoint, int rightPoint) {
    String thisResult = "";
    while (leftPoint >= 0 && rightPoint < s.length() && s.charAt(leftPoint) == s.charAt(rightPoint)) {
      thisResult = s.substring(leftPoint, rightPoint + 1);
      leftPoint--;
      rightPoint++;
    }
    return thisResult;
  }

  public static void main(String[] args) {
    String test = "babad";
    String s = new LeetCode0005().longestPalindrome(test);
    System.out.println(s);
  }
}
